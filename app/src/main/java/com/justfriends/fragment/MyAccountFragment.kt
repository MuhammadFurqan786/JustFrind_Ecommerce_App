package com.justfriends.fragment

import android.Manifest
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.justfriends.NavGraphDirections
import com.justfriends.R
import com.justfriends.databinding.FragmentMyAccountBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.preference.PreferenceHelper
import com.justfriends.utils.Global
import com.justfriends.viewModel.AuthViewModel
import com.nguyenhoanglam.imagepicker.model.Image
import com.nguyenhoanglam.imagepicker.ui.imagepicker.ImagePicker
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.util.*


class MyAccountFragment : Fragment() {
    private lateinit var binding: FragmentMyAccountBinding
    private var mIMainActivity: IMainActivity? = null
    private var helper: PreferenceHelper? = null
    private val authViewModel: AuthViewModel by viewModels()
    private var chooseOptDia: Dialog? = null
    private var mCurrentPhotoPath: String? = null
    private var mImagePart: MultipartBody.Part? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyAccountBinding.inflate(inflater, container, false)
        helper = PreferenceHelper.getPref(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel.getUserData(
            helper?.getStringValue("token") ?: "",
            helper?.getCurrentUser()?.id.toString()
        )
        setUpListener()
        setupObserver()
    }

    private fun setupObserver() {
        authViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        authViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        authViewModel.getUserDataObserver.observe(viewLifecycleOwner) {
            binding.tvName.text = it.data.name
            binding.tvEmail.text = it.data.email
            Glide.with(requireContext())
                .load(Global.getImageUrl(it.data.userImg))
                .placeholder(R.drawable.ic_user)
                .into(binding.ivProfile)
        }
        authViewModel.getProfileImageUpdateObserver.observe(viewLifecycleOwner) {
            Global.showMessage(binding.root, it.message)
        }
    }

    private fun setUpListener() {
        binding.ivEditChangePassword.setOnClickListener {
            val directions =
                MyAccountFragmentDirections.actionNavMyAccountFragmentToChangePasswordFragment()
            findNavController().navigate(directions)
        }
        binding.btLogOut.setOnClickListener {
            showLLogoutAlert()
        }
        binding.ivEditName.setOnClickListener {
            val direction =
                MyAccountFragmentDirections.actionNavMyAccountFragmentToEditNameFragment(
                    binding.tvName.text.toString().trim()
                )
            findNavController().navigate(direction)


            /*    binding.tvName.isEnabled = true
                   binding.tvName.isCursorVisible = true
                   binding.tvName.isFocusableInTouchMode = true
                   binding.tvName.inputType = InputType.TYPE_CLASS_TEXT;
                   binding.tvName.requestFocus()*/
        }
        binding.ivEditEmail.setOnClickListener {
            val directions =
                MyAccountFragmentDirections.actionNavMyAccountFragmentToEditEmailFragment(
                    binding.tvEmail.text.toString().trim()
                )
            findNavController().navigate(directions)

            /*        binding.tvEmail.isEnabled = true
                    binding.tvEmail.isCursorVisible = true
                    binding.tvEmail.isFocusableInTouchMode = true
                    binding.tvEmail.inputType = InputType.TYPE_CLASS_TEXT;
                    binding.tvEmail.requestFocus()*/
        }
        binding.ivEditLocation.setOnClickListener {
        }
        binding.tvListing.setOnClickListener {
            val directions =
                MyAccountFragmentDirections.actionNavMyAccountFragmentToNavMyListingsFragment()
            findNavController().navigate(directions)
        }
        binding.ivEditProfile.setOnClickListener {
            chooseOptionsDialog()
        }
    }

    private fun chooseOptionsDialog() {
        chooseOptDia = Dialog(requireContext())
        chooseOptDia?.setCancelable(true)
        chooseOptDia?.setContentView(R.layout.dialog_choose_img_options)
        chooseOptDia?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

        chooseOptDia?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val params = chooseOptDia?.window?.attributes
        params?.gravity = Gravity.CENTER_VERTICAL


        val fabGallery: FloatingActionButton = chooseOptDia!!.findViewById(R.id.fab_gallery)
        val fabCamera: FloatingActionButton = chooseOptDia!!.findViewById(R.id.fab_camera)

        fabCamera.setOnClickListener { v: View? -> chooseFromCamera() }
        fabGallery.setOnClickListener { v: View? -> chooseFromGallery() }
        chooseOptDia?.show()

    }

    private fun chooseFromGallery() {
        requestPermissions(
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            Global.RC_GALLERY
        )
    }

    private fun chooseFromCamera() {
        if (!Global.hasFeatureCamera(requireContext())) {
            Global.showMessage(binding.root, "Unable to detect camera", Snackbar.LENGTH_LONG)
        } else
            requestPermissions(
                arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ), Global.RC_CAMERA
            )
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (chooseOptDia != null) chooseOptDia!!.dismiss()
        if (requestCode == Global.RC_CAMERA && grantResults.isNotEmpty()) {
            val isAllowed = grantResults[0] == PackageManager.PERMISSION_GRANTED
            if (!isAllowed && Global.requiredRational(
                    requireActivity(),
                    Manifest.permission.CAMERA
                )
            ) {
                accessPermissionReason(
                    Manifest.permission.CAMERA,
                    getString(R.string.cameraPermissionReason)
                )
            } else if (!isAllowed && !Global.requiredRational(
                    requireActivity(),
                    Manifest.permission.CAMERA
                )
            ) {
                showManuallyAlert()
            } else {
                openCamera()
            }
        } else if (requestCode == Global.RC_GALLERY && grantResults.isNotEmpty()) {
            val isAllowed = grantResults[0] == PackageManager.PERMISSION_GRANTED
            if (!isAllowed && Global.requiredRational(
                    requireActivity(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            ) {
                accessPermissionReason(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    getString(R.string.galleryPermissionReason)
                )
            } else if (!isAllowed && !Global.requiredRational(
                    requireActivity(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            ) {
                showManuallyAlert()
            } else {
                openGallery()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun openCamera() {
        val cameraIntent = Intent()
        cameraIntent.action = MediaStore.ACTION_IMAGE_CAPTURE

        if (requireActivity().packageManager.hasSystemFeature(
                PackageManager.FEATURE_CAMERA_ANY
            )
        ) {
            var photoFile: File? = null
            try {
                photoFile = Global.createImgFile(requireContext())
                mCurrentPhotoPath = photoFile.absolutePath
            } catch (e: IOException) {
                Log.d("TAG", "openCamera: unable to create path ")
            }
            if (photoFile != null) {
                val photoUri = FileProvider.getUriForFile(
                    requireContext(),
                    "com.justfriends.fileprovider",
                    photoFile
                )
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
            }
            startActivityForResult(cameraIntent, Global.RC_CAMERA)
        } else {
            Global.showMessage(
                binding.root,
                "Could not found any application to capture Photo",
                Snackbar.LENGTH_LONG
            )
        }

        if (chooseOptDia != null) chooseOptDia!!.dismiss()
    }

    private fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_PICK
        startActivityForResult(
            Intent.createChooser(intent, "Choose picture from"),
            Global.RC_GALLERY
        )
        if (chooseOptDia != null) chooseOptDia!!.dismiss()
    }

    private fun enableManually() {
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        val uri = Uri.fromParts("package", requireActivity().packageName, null)
        intent.data = uri
        startActivity(intent)
    }

    private fun showManuallyAlert() {
        AlertDialog.Builder(requireContext())
            .setTitle("Permission Alert")
            .setMessage("We need Permission to access this functionality\nPlease enable it manually from settings")
            .setPositiveButton("Enable") { dialog: DialogInterface?, which: Int -> enableManually() }
            .setNegativeButton("cancel") { dialog: DialogInterface, which: Int -> dialog.dismiss() }
            .show()
    }

    private fun accessPermissionReason(permission: String, reason: String?) {
        val reasonDialog = Dialog(requireContext())
        reasonDialog.setContentView(R.layout.dia_permission_reason)
        reasonDialog.setCancelable(false)

        reasonDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        reasonDialog.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        val params = reasonDialog.window?.attributes
        params?.gravity = Gravity.CENTER_VERTICAL

        val tvPermissionReason = reasonDialog.findViewById<TextView>(R.id.tv_permission_reason)
        val tvRetry = reasonDialog.findViewById<TextView>(R.id.bt_retry)
        val tvIamSure = reasonDialog.findViewById<TextView>(R.id.bt_iam_sure)
        tvPermissionReason.text = reason
        tvIamSure.setOnClickListener { reasonDialog.dismiss() }
        tvRetry.setOnClickListener {
            reasonDialog.dismiss()
            if (permission == Manifest.permission.CAMERA) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CAMERA),
                    Global.RC_CAMERA
                )
            } else if (permission == Manifest.permission.WRITE_EXTERNAL_STORAGE) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    Global.RC_GALLERY
                )
            }
        }
        reasonDialog.show()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Global.RC_CAMERA && resultCode == AppCompatActivity.RESULT_OK) {
            mCurrentPhotoPath?.let {
                val bitmap = BitmapFactory.decodeFile(File(mCurrentPhotoPath!!).absolutePath)

                Glide.with(this)
                    .load(bitmap)
                    .into(binding.ivProfile)
                uploadPhoto(bitmap)
                Log.d("bitmap", "onActivityResult: $bitmap")
                Log.d("current photo path", "onActivityResult: $mCurrentPhotoPath")

            } ?: Global.showMessage(binding.root, "unable to capture Image")


        } else if (requestCode == Global.RC_GALLERY) {
            if (data != null) {
                try {
                    val `is` = requireActivity().contentResolver.openInputStream(data.data!!)
                    val bitmap = BitmapFactory.decodeStream(`is`)
                    Glide.with(this)
                        .load(bitmap)
                        .into(binding.ivProfile)
                    uploadPhoto(bitmap)

                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                }
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun uploadPhoto(bitmap: Bitmap) {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 40, outputStream)
        val byteArr = outputStream.toByteArray()

        val requestBody = byteArr.toRequestBody("file/*".toMediaTypeOrNull(), 0, byteArr.size)
        val random = Random()
        mImagePart = MultipartBody.Part.createFormData(
            "userImg", "Image_${random.nextInt(1000)}.jpg", requestBody
        )
        authViewModel.updateProfileImage(
            helper?.getStringValue("token") ?: "",
            mImagePart!!
        )
    }


    private fun showLLogoutAlert() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.logout))
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton(getString(R.string.cancel)) { dialog, which ->
                dialog.dismiss()

            }
            .setNegativeButton(getString(R.string.logout)) { dialog, _ ->
                dialog.dismiss()
                mIMainActivity?.getPreference()?.setUserLogin(false)
                gotoLoginFragment()
            }
            .show()
    }

    private fun gotoLoginFragment() {
        val direction =
            NavGraphDirections.actionGlobalNavLoginFragment()
        findNavController().navigate(direction)
        findNavController().popBackStack(R.id.nav_home_fragment, true)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mIMainActivity = context as IMainActivity
    }

    override fun onDetach() {
        super.onDetach()
        mIMainActivity = null
    }
}