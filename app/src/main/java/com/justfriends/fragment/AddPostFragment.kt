package com.justfriends.fragment

import android.Manifest
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.justfriends.R
import com.justfriends.adapter.PhotosAdapter
import com.justfriends.databinding.FragmentAddPostBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.model.FoundationItem
import com.justfriends.preference.PreferenceHelper
import com.justfriends.utils.Global
import com.justfriends.utils.PrefKeys
import com.justfriends.viewModel.AddPostViewModel
import com.nguyenhoanglam.imagepicker.model.Image
import com.nguyenhoanglam.imagepicker.ui.imagepicker.ImagePicker
import java.io.File
import java.io.IOException


class AddPostFragment : Fragment(), PhotosAdapter.PhotosClickInterface,
    FoundationDialogFragment.IFoundation {
    private lateinit var binding: FragmentAddPostBinding
    private val navArgs: AddPostFragmentArgs by navArgs()
    private var photosAdapter: PhotosAdapter? = null
    private var chooseOptDia: Dialog? = null
    private var mCurrentPhotoPath: String? = null
    private val ROOT_DIR_DCIM: String = Environment.DIRECTORY_PICTURES
    private val addPostViewModel: AddPostViewModel by viewModels()
    private var mMaxImageSelectionCount: Int = 10
    private var mIMainActivity: IMainActivity? = null
    private var mCategoryId = ""
    private var mProductStatusSelectedValue = ""
    private var mFoundationId = ""
    private var mTerms = 1
    private var isCharityValue = 0
    private var mFoundationName = ""
    private lateinit var helper: PreferenceHelper
    private var someStateValue = 0
    private val SOME_VALUE_KEY = "someValueToSave"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        helper = PreferenceHelper.getPref(requireContext())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddPostBinding.inflate(inflater, container, false)
        if (savedInstanceState != null) {
            someStateValue = savedInstanceState.getInt(SOME_VALUE_KEY)
            // Do something with value if needed
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        mCategoryId = helper.getStringValue("category_id").toString()
        binding.tvCategory.text = navArgs.catName
        binding.tvLocation.text = navArgs.address
        photosAdapter = PhotosAdapter()
        photosAdapter?.onPhotosClickListener(this)
        addPostViewModel.removeAllImagesBitMap()
        setupAdapter()
        setupObserver()
        setupListener()
        setAddress()
    }


    private fun setupObserver() {
        addPostViewModel.getLiveDataImages.observe(viewLifecycleOwner) {
            photosAdapter?.setData(it)
            val addedImageSize: Int = photosAdapter!!.itemCount
            binding.tvPhotoCount.text = ("$addedImageSize/10")
        }
        addPostViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        addPostViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }

        addPostViewModel.getAddPostObserver.observe(viewLifecycleOwner) {
            if (it.success) {
                addPostViewModel.removeAllImagesBitMap()
                openSuccessDialog(it.data.productId)
            }
        }
    }

    private fun openSuccessDialog(productId: Long) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.success))
            .setMessage(getString(R.string.message_create_successfully))
            .setPositiveButton(
                getString(R.string.ok)
            ) { dialog, which ->
                val directions =
                    AddPostFragmentDirections.actionNavPostAdFragmentToNavHomeFragment()
                findNavController().navigate(directions)
            }.show()
    }


    private fun setupAdapter() {
        binding.rvPhotos.adapter = photosAdapter
    }

    private fun setupListener() {
        setSpannable()
        binding.tvCategory.setOnClickListener {
            val direction = AddPostFragmentDirections.actionNavSellFragmentToCategoryFragment()
            findNavController().navigate(direction)
        }

        binding.topAppBar.setNavigationOnClickListener {
            val directions = AddPostFragmentDirections.actionNavPostAdFragmentToNavHomeFragment()
            findNavController().navigate(directions)
        }

        binding.ivCar.setOnClickListener {
            if ((photosAdapter ?: return@setOnClickListener).itemCount >= 10) {
                Global.showMessage(
                    binding.root,
                    getString(R.string.maximum_limit_reached),
                    Snackbar.LENGTH_LONG
                )
                return@setOnClickListener
            }
            chooseOptionsDialog()
        }

        binding.tvLocation.setOnClickListener {
            openMap()
        }

        binding.tvFoundation.setOnClickListener {
            val addFoundationBottomDialogFragment = FoundationDialogFragment.newInstance()
            addFoundationBottomDialogFragment.setFoundationOnClickListener(this)
            addFoundationBottomDialogFragment.show(
                requireActivity().supportFragmentManager,
                getString(R.string.dialog_filter)
            )
        }

        binding.toggleCharity.setOnCheckedChangeListener { compoundButton, b ->
            if (compoundButton.isChecked) {
                binding.tvFoundation.visibility = View.VISIBLE
                binding.etCharitableAmount.visibility = View.VISIBLE
            } else {
                binding.tvFoundation.visibility = View.GONE
                binding.etCharitableAmount.visibility = View.GONE
            }
        }
        binding.tvProductStatus.setOnClickListener {
            openProjectStatusDialog()
        }

        binding.tvPost.setOnClickListener {
            validatePostData()
        }
    }

    private fun openProjectStatusDialog() {
        val items = arrayOf(
            getString(R.string.best),
            getString(R.string.good),
            getString(R.string.ok),
            getString(R.string.poor)
        )

        MaterialAlertDialogBuilder(requireContext())
            .setItems(items) { dialog, which ->
                binding.tvProductStatus.text = items[which]
                mProductStatusSelectedValue = items[which]
            }
            .show()
    }


    private fun validatePostData() {
//        if (photosAdapter?.itemCount == 0) {
//            Global.showMessage(binding.root, getString(R.string.message_upload_image))
//        } else if (photosAdapter?.itemCount!! < 3) {
//            Global.showMessage(binding.root, getString(R.string.message_select_minimum_images))
//        } else
            if (binding.tvCategory.text.toString().trim().isEmpty()) {
            Global.showMessage(binding.root, getString(R.string.message_select_category))
        } else if (binding.etTitle.text.toString().trim().isEmpty()) {
            Global.showMessage(binding.root, getString(R.string.message_product_title))
        } else if (binding.etPrice.text.toString().trim().isEmpty()) {
            Global.showMessage(binding.root, getString(R.string.message_enter_price))
        } else if (binding.etDescription.text.toString().trim().isEmpty()) {
            Global.showMessage(binding.root, getString(R.string.message_enter_description))
        } else if (binding.toggleCharity.isChecked && binding.etCharitableAmount.text.toString()
                .trim().isEmpty()
        ) {
            Global.showMessage(binding.root, getString(R.string.message_enter_amount))

        } else if (!binding.cbTermsConditions.isChecked) {
            Global.showMessage(
                binding.root,
                getString(R.string.message_read_terms_and_conditions)
            )
        } else {

            addPostViewModel.getPostData.name = binding.etTitle.text.toString().trim()
            addPostViewModel.getPostData.product_desc =
                binding.etDescription.text.toString().trim()
            addPostViewModel.getPostData.category_id = mCategoryId
            addPostViewModel.getPostData.production_condition = mProductStatusSelectedValue
            // mProductStatusSelectedValue[0].toString()
            addPostViewModel.getPostData.price = binding.etPrice.text.toString().trim()
            if (binding.toggleCharity.isChecked) {
                addPostViewModel.getPostData.is_charity = getString(R.string.one_charity_value)
            } else {
                addPostViewModel.getPostData.is_charity = getString(R.string.zero_charity_value)
            }

            isCharityValue.toString()
            addPostViewModel.getPostData.foundation_id = mFoundationId
            addPostViewModel.getPostData.foundation_name = mFoundationName
            addPostViewModel.getPostData.charity_amt =
                binding.etCharitableAmount.text.toString().trim()
            addPostViewModel.getPostData.terms = mTerms.toString()
            addPostViewModel.getPostData.latitude =
                mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_LATITUDE) ?: ""

            addPostViewModel.getPostData.longitude =
                mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_LONGITUDE) ?: ""
            addPostViewModel.getPostData.sub_category_id = navArgs.categoryId
            Log.d(
                "TOKEN",
                mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: ""
            )
            addPostViewModel.addPost(
                mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
                helper.getCurrentUser()?.id.toString()
            )
        }
    }

    private fun openMap() {
        val direction =
            AddPostFragmentDirections.actionNavPostAdFragmentToSearchKakaoLocationFragment()
        findNavController().navigate(direction)
    }

    private fun chooseOptionsDialog() {
        chooseOptDia = Dialog(requireActivity())
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

    private fun chooseFromCamera() {
        if (!Global.hasFeatureCamera(requireActivity())) {
            Global.showMessage(
                binding.root,
                getString(R.string.unable_to_detect_camera),
                Snackbar.LENGTH_LONG
            )
        } else if (!Global.hasPermissions(requireActivity(), arrayOf(Manifest.permission.CAMERA))
        ) {
            requestPermissions(
                arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ), Global.RC_CAMERA
            )
        } else {
            openCamera()
        }

    }

    private fun chooseFromGallery() {
        if (!Global.hasPermissions(
                requireActivity(),
                arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            )
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                Global.RC_GALLERY
            )
        } else {
            openGallery()
        }
    }

    private fun openCamera() {
        val cameraIntent = Intent()
        cameraIntent.action = MediaStore.ACTION_IMAGE_CAPTURE
        if (cameraIntent.resolveActivity(requireActivity().packageManager) != null) {
            var photoFile: File? = null
            try {
                photoFile = Global.createImgFile(requireActivity())
                mCurrentPhotoPath = photoFile.absolutePath
            } catch (e: IOException) {
                print(e.printStackTrace())
            }
            if (photoFile != null) {
                val photoUri = FileProvider.getUriForFile(
                    requireActivity(),
                    getString(R.string.package_name),
                    photoFile
                )
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
            }
            startActivityForResult(cameraIntent, Global.RC_CAMERA)
        } else {
            Global.showMessage(
                binding.root,
                getString(R.string.message_capture_photo),
                Snackbar.LENGTH_LONG
            )
        }
        if (chooseOptDia != null) chooseOptDia!!.dismiss()
    }

    private fun setSpannable() {
        val title = getString(R.string.title)
        val price = getString(R.string.price)
        val productStatus = getString(R.string.product_status)
        val colored = getString(R.string.star)
        val builderTitle = SpannableStringBuilder()
        val builderPrice = SpannableStringBuilder()
        val builderProductStatus = SpannableStringBuilder()
        builderTitle.append(title)
        builderPrice.append(price)
        builderProductStatus.append(productStatus)
        val start = builderTitle.length
        val startPrice = builderPrice.length
        val startProductStatus = builderProductStatus.length

        builderTitle.append(colored)
        builderPrice.append(colored)
        builderProductStatus.append(colored)
        val end = builderTitle.length
        val endPrice = builderPrice.length
        val endProductStatus = builderProductStatus.length
        builderTitle.setSpan(
            ForegroundColorSpan(Color.RED), start, end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        builderPrice.setSpan(
            ForegroundColorSpan(Color.RED), startPrice, endPrice,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        builderProductStatus.setSpan(
            ForegroundColorSpan(Color.RED), startProductStatus, endProductStatus,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.etTitle.hint = builderTitle
        binding.etPrice.hint = builderPrice
        binding.tvProductStatus.hint = builderProductStatus
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
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
    }

    private fun openGallery() {
        mMaxImageSelectionCount = 10 - photosAdapter!!.itemCount
        ImagePicker.with(this)
            .setFolderMode(true)
            .setFolderTitle(getString(R.string.album))
            .setRootDirectoryName(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString())
            .setDirectoryName(getString(R.string.image_picker))
            .setMultipleMode(true)
            .setShowNumberIndicator(true)
            .setMaxSize(mMaxImageSelectionCount)
            .setLimitMessage("You can select up to $mMaxImageSelectionCount images")
            .setRequestCode(Global.RC_GALLERY)
            .start()
        if (chooseOptDia != null) chooseOptDia!!.dismiss()
    }


    private fun showManuallyAlert() {
        AlertDialog.Builder(requireActivity())
            .setTitle(getString(R.string.permission_alert))
            .setMessage("We need Permission to access this functionality\nPlease enable it manually from settings")
            .setPositiveButton(getString(R.string.enable)) { dialog: DialogInterface?, which: Int -> enableManually() }
            .setNegativeButton(getString(R.string.cancel)) { dialog: DialogInterface, which: Int -> dialog.dismiss() }
            .show()
    }


    private fun enableManually() {
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        val uri = Uri.fromParts("package", requireActivity().packageName, null)
        intent.data = uri
        startActivity(intent)
    }

    private fun accessPermissionReason(permission: String, reason: String?) {
        val reasonDialog = Dialog(requireActivity())
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
                requestPermissions(arrayOf(Manifest.permission.CAMERA), Global.RC_CAMERA)
            } else if (permission == Manifest.permission.WRITE_EXTERNAL_STORAGE) {
                requestPermissions(
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    Global.RC_GALLERY
                )
            }
        }
        reasonDialog.show()
    }

    override fun onPhotosClick(photoPath: String, position: Int) {
    }

    override fun onDeletephoto(position: Int) {
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Global.RC_CAMERA && resultCode == Activity.RESULT_OK) {
            val bitmap = BitmapFactory.decodeFile(File(mCurrentPhotoPath!!).absolutePath)
            addPostViewModel.addImage(mCurrentPhotoPath ?: "")
            addPostViewModel.addImageBitmap(bitmap)

        } else if (ImagePicker.shouldHandleResult(
                requestCode,
                resultCode,
                data,
                Global.RC_GALLERY
            )
        ) {
            try {

                val images: ArrayList<Image> = ImagePicker.getImages(data)
                for (image in images) {
                    addPostViewModel.addImage(image.path)
                    val bitmap = BitmapFactory.decodeFile(File(image.path).absolutePath)
                    addPostViewModel.addImageBitmap(bitmap)
                }
            } catch (e: Exception) {
            }
        }

    }

    override fun onItemClick(foundationItem: FoundationItem) {
        mFoundationId = foundationItem.id.toString()
        mFoundationName = foundationItem.name!!
        binding.tvFoundation.text = foundationItem.name
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mIMainActivity = context as IMainActivity
    }

    override fun onDetach() {
        super.onDetach()
        mIMainActivity = null
    }

    private fun setAddress() {
        val address = Global.getAddress(
            requireContext(),
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_LATITUDE) ?: "",
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_LONGITUDE) ?: ""
        )

        Log.d("TAG", "setAddress: address = $address")
        address?.let {

            val subLocality = it.subLocality ?: "Unnamed Area"
            val subAdminArea = it.subAdminArea ?: "Unnamed Location"
            binding.tvLocation.text = "$subLocality,$subAdminArea"
        }


    }

    override fun onStop() {
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("SavedState",1)
        super.onSaveInstanceState(outState)
    }


}


