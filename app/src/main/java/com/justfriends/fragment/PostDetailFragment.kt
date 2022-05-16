package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.justfriends.NavGraphDirections
import com.justfriends.R
import com.justfriends.adapter.ImageSlidesShowAdapter
import com.justfriends.adapterClasses.MyTabSelectedListener
import com.justfriends.databinding.FragmentPostDetailBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.model.PostDetailData
import com.justfriends.utils.Global
import com.justfriends.utils.PrefKeys
import com.justfriends.viewModel.FavouriteViewModel
import com.justfriends.viewModel.PostViewModel
import java.text.SimpleDateFormat
import java.util.*


class PostDetailFragment : Fragment(), ImageSlidesShowAdapter.IImageClick {
    private lateinit var binding: FragmentPostDetailBinding
    private val postViewModel: PostViewModel by viewModels()
    private val navArgs: PostDetailFragmentArgs by navArgs()
    private var mIMainActivity: IMainActivity? = null
    private var imgSlideShowAdapter: ImageSlidesShowAdapter? = null
    private val favouriteViewModel: FavouriteViewModel by viewModels()
    private var isFav = false
    private var postDetailData: PostDetailData? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPostDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPostDetail()

        setupObserver()
        setupListener()
        setupTabChangeListener()
    }


    private fun getPostDetail() {
        postViewModel.getPostDetail(
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
            navArgs.postId
        )
    }


    private fun setupObserver() {
        postViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        postViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }

        postViewModel.getPostDetailObserver.observe(viewLifecycleOwner) {
            setData(it)
        }


    }

    private fun setData(post: PostDetailData) {
        postDetailData = post
        binding.tvProductName.text = post.name
        binding.tvPostDescription.text = post.productDesc
        setupImageSlides(post.imgs.toTypedArray())
        isFav = post.isFav == 1

        binding.ivFav.setImageResource(
            if (post.isFav == 1)
                R.drawable.ic_like
            else R.drawable.ic_like_normal
        )

        binding.gpBtChatBuy.visibility = if (post.userId == mIMainActivity?.getPreference()?.getCurrentUser()?.id
        ) View.VISIBLE else View.GONE


        val price =
            if (post.price == null) "0.0 won" else "${String.format("%,d", post.price)} won"
        binding.tvProductPrice.text = price
        binding.tvPrice.text = price
        binding.tvTime.text = requireContext().getString(
            R.string.time, Global.getTimeDifference(
                post.createdDtm ?: "",
                SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
            )
        )
        binding.tvSellerName.text = post.userName ?: ""
        binding.tvCondition.text=post.productCondition


        Glide.with(requireContext())
            .load(Global.getImageUrl(post.userImg ?: ""))
            .placeholder(R.drawable.ic_user)
            .error(R.drawable.ic_empty_photo)
            .into(binding.ivSeller)


    }

    private fun setupListener() {
        binding.ivFav.setOnClickListener {
            isFav = if (isFav) {
                binding.ivFav.setImageResource(R.drawable.ic_heart)
                favouriteViewModel.addToFav(
                    mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
                    navArgs.postId
                )
                false
            } else {
                binding.ivFav.setImageResource(R.drawable.ic_heart_unlike)
                favouriteViewModel.removeFromFav(
                    mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
                    navArgs.postId
                )
                true
            }
        }
        binding.topAppBar.setNavigationOnClickListener {
            Log.d("TAG", "setUpListener: topbar")
            it.findNavController().navigateUp()
        }

        binding.ivViewProfile.setOnClickListener {
            val direction =
                PostDetailFragmentDirections.actionNavPostDetailFragmentToPublicProfileFragment(
                    postDetailData?.userId ?: return@setOnClickListener
                )
            findNavController().navigate(direction)

        }


    }

    private fun setupTabChangeListener() {
        binding.tabPostDetail.addOnTabSelectedListener(object : MyTabSelectedListener() {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.gpPostDetail.visibility =
                    if (tab?.position == 0) View.VISIBLE else View.GONE
                binding.tvPostDescription.visibility =
                    if (tab?.position == 1) View.VISIBLE else View.GONE


            }
        })
    }


    private fun setupImageSlides(images: Array<String>) {
        imgSlideShowAdapter = ImageSlidesShowAdapter(images)
        imgSlideShowAdapter?.setOnImageClickListener(this)
        binding.pagerProductImage.adapter = imgSlideShowAdapter
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mIMainActivity = context as IMainActivity
    }

    override fun onDetach() {
        super.onDetach()
        mIMainActivity = null
    }


    override fun onImageClick(position: Int, images: Array<String>) {
        val direction = NavGraphDirections.actionGlobalFullImageFragment(images, position)
        findNavController().navigate(direction)
    }


}