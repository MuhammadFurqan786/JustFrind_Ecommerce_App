package com.justfriends.fragment

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.justfriends.NavGraphDirections
import com.justfriends.adapter.HomeCategoriesAdapter
import com.justfriends.adapter.PostsAdapter
import com.justfriends.databinding.FragmentHomeBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.viewModel.FavouriteViewModel
import com.justfriends.viewModel.PostViewModel

import com.justfriends.R
import com.justfriends.model.Post
import com.justfriends.utils.Global
import com.justfriends.utils.PrefKeys
import com.justfriends.viewModel.CategoryViewModel

private const val RC_PERMISSIONS = 101

class HomeFragment : Fragment(), HomeCategoriesAdapter.ICategoryClick,
    OnMapReadyCallback, PostsAdapter.IPost {
    private lateinit var binding: FragmentHomeBinding
    private var mClickedPosition: Int = -1
    private var mPostsAdapter: PostsAdapter? = null
    private var mHomeCategoryAdapter: HomeCategoriesAdapter? = null
    private val postViewModel: PostViewModel by viewModels()
    private val categoryViewModel: CategoryViewModel by viewModels()
    private var mIMainActivity: IMainActivity? = null
    private val favouriteViewModel: FavouriteViewModel by viewModels()
    private var categoryID = ""
    private val permissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mIMainActivity?.getPreference()?.setUserLogin(true)
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
        mPostsAdapter = PostsAdapter()
        mHomeCategoryAdapter = HomeCategoriesAdapter()
        mPostsAdapter?.setOnPostClickListener(this)
        mHomeCategoryAdapter?.setOnCategoryClickListener(this)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Global.hideKeyboard(requireContext(),binding.root)
        checkForPermission()
        binding.rvHomeCategories.setHasFixedSize(true)
        binding.rvHomePost.setHasFixedSize(true)
        binding.rvHomeCategories.adapter = mHomeCategoryAdapter
        binding.rvHomePost.adapter = mPostsAdapter
        categoryViewModel.getCategories()
        postViewModel.getRecentPosts(
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: ""
        )

        setupCategoryObserver()
        setupPostObserver()
        setupFavouriteObserver()
        setUpListener()
    }
    private fun setupCategoryObserver() {
        categoryViewModel.getProgressObserver.observe(viewLifecycleOwner){
            mIMainActivity?.showProgress(it)
        }
        categoryViewModel.getMessageObserver.observe(viewLifecycleOwner){
            mIMainActivity?.showMessage(it)
        }
        categoryViewModel.getCategoryObserver.observe(viewLifecycleOwner){
            mHomeCategoryAdapter?.setData(it)



        }
    }

    private fun setupPostObserver() {
        postViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        postViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        postViewModel.getPostsObserver.observe(viewLifecycleOwner){
            mPostsAdapter?.setData(it)
        }
    }




    private fun setupFavouriteObserver() {
        favouriteViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }

        favouriteViewModel.getFavouriteStatusObserver.observe(viewLifecycleOwner) {
            mClickedPosition = if (it) {
                mPostsAdapter?.notifyItem(1, mClickedPosition)
                -1
            } else {
                mPostsAdapter?.notifyItem(0, mClickedPosition)
                -1
            }
        }
    }

    private fun checkForPermission() {
        Log.d(
            "TAG",
            "checkForPermission: called   ${Global.hasPermissions(requireActivity(), permissions)}"
        )
        if (Global.hasPermissions(requireActivity(), permissions)) {
            getCurrentLocation()


        } else {
            requestPermissions(permissions, RC_PERMISSIONS)
        }
    }

    private fun getCurrentLocation() {
        Log.d("TAG", "getCurrentLocation: called")
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Global.showMessage(binding.root, getString(R.string.message_permission_denied))
            return
        }
        LocationServices.getFusedLocationProviderClient(requireActivity()).lastLocation.addOnSuccessListener {

            try {
                Log.d(
                    "TAG",
                    "getCurrentLocation: Current location =${it.latitude} -  ${it.longitude}"
                )
                mIMainActivity?.getPreference()
                    ?.saveStringValue(PrefKeys.KEY_LATITUDE, it.latitude.toString())
                mIMainActivity?.getPreference()
                    ?.saveStringValue(PrefKeys.KEY_LONGITUDE, it.longitude.toString())

            } catch (e: Exception) {
                Global.checkLocationProvider(requireContext())
                Log.d("TAG", "getCurrentLocation: Current location Exception = $e")
                //mIMainActivity?.getPreference()?.saveStringValue(PrefKeys.KEY_LATITUDE, "0")
                // mIMainActivity?.getPreference()?.saveStringValue(PrefKeys.KEY_LONGITUDE, "0")
            }
            setAddress()

        }


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
            binding.btLocation.text = "$subLocality,$subAdminArea"
        }


    }






    private fun setUpListener() {
        binding.etSearch.setOnClickListener {
            val direction = HomeFragmentDirections.actionNavHomeFragmentToNavSearchFragment(
                0,
                "",
                true)
            findNavController().navigate(direction)
        }

        binding.btLocation.setOnClickListener {
            val directions =
                HomeFragmentDirections.actionNavHomeFragmentToNavSearchKakaoLocationFragment(
                    true
                )
            findNavController().navigate(directions)
        }

        /* binding.btSearch.setOnEditorActionListener { textView, i, keyEvent ->
             val keyword = binding.btSearch.text.toString().trim()
             if (keyword.isEmpty()) {
                 Global.showMessage(
                     binding.root,
                     getString(R.string.message_search_keyword_required)
                 )
             }
             val directions =
                 HomeFragmentDirections.actionNavHomeFragmentToNavSearchFragment(
                     categoryID, binding.btSearch.text.toString().trim(), true
                 )
             findNavController().navigate(directions)
             true
         }*/

        binding.ivBell.setOnClickListener {
            val directions = HomeFragmentDirections.actionNavHomeFragmentToNotificationFragment()
            it.findNavController().navigate(directions)
        }

    }


    override fun onCategoryClick(categoryId: Long) {
        categoryID = categoryId.toString()
        val direction = HomeFragmentDirections.actionNavHomeFragmentToNavSearchFragment(
            categoryId,
            "",
            false)
        findNavController().navigate(direction)
    }


    override fun onMapReady(p0: GoogleMap) {
    }


    override fun onItemClick(post: Post) {
        val direction =
            NavGraphDirections.actionGlobalNavPostDetailFragment(post.id)
        findNavController().navigate(direction)

    }

    override fun onFavClick(postId: Long, isFav: Int, position: Int) {
        mClickedPosition = position
        if (isFav == 1) {
            favouriteViewModel.removeFromFav(
                mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
                postId
            )

        } else {
            favouriteViewModel.addToFav(
                mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
                postId
            )
        }
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