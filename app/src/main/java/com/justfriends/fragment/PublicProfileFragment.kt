package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.justfriends.NavGraphDirections
import com.justfriends.R
import com.justfriends.adapter.ReviewsAdapter
import com.justfriends.adapter.UserMarketplaceAdapter
import com.justfriends.customDialogs.UserReportDialogFragment
import com.justfriends.databinding.FragmentPublicProfileBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.model.Post
import com.justfriends.model.PublicProfileData
import com.justfriends.model.Review
import com.justfriends.utils.Global
import com.justfriends.utils.PrefKeys
import com.justfriends.viewModel.AccountViewModel
import com.justfriends.viewModel.ReviewRatingViewModel

private const val TAG = "PublicProfileFragment"

class PublicProfileFragment : Fragment(), UserMarketplaceAdapter.PostItemClickInterface,
    ReviewsAdapter.IReview {
    private lateinit var binding: FragmentPublicProfileBinding
    private val accountViewModel: AccountViewModel by viewModels()
    private val reviewRatingViewModel: ReviewRatingViewModel by viewModels()
    private val navArgs: PublicProfileFragmentArgs by navArgs()
    private var mIMainActivity: IMainActivity? = null
    private var userMarketplaceAdapter: UserMarketplaceAdapter? = null
    private var mReviewsAdapter: ReviewsAdapter? = null
    private var mPublicProfileData: PublicProfileData? = null
    private var isEditRating = false
    private var mClickedPosition: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mReviewsAdapter = ReviewsAdapter()
        mReviewsAdapter?.setOnReviewClickListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPublicProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvReviews.setHasFixedSize(true)
        binding.rvReviews.adapter = mReviewsAdapter

        accountViewModel.getPublicProfile(
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
            navArgs.userId.toString()
        )
        accountViewModel.getMarketPlacePosts(
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
            navArgs.userId
        )
        setUpListener()
        setupObserver()
        setupReviewRatingObserver()
        setupRatingChangeListener()
    }


    private fun setupObserver() {
        accountViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        accountViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        accountViewModel.getPublicProfileObserver.observe(viewLifecycleOwner) {
            setupProfileData(it)

        }
        accountViewModel.getMarketplacePostsObserver.observe(viewLifecycleOwner) {

            userMarketplaceAdapter = UserMarketplaceAdapter(it, this)
            binding.rvPhotos.adapter = userMarketplaceAdapter
        }
        accountViewModel.getBlockUserObserver.observe(viewLifecycleOwner) {
            Log.d(TAG, "setupObserver: ${it.message}")

            mIMainActivity?.showAlter(it.message)
        }
    }


    private fun setupReviewRatingObserver() {
        reviewRatingViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        reviewRatingViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        reviewRatingViewModel.getDeleteReviewObserver.observe(viewLifecycleOwner) {
            mReviewsAdapter?.removeItem(mClickedPosition)
            MaterialAlertDialogBuilder(requireContext())
                .setMessage(it.message)
                .setPositiveButton(getString(R.string.ok)) { dialog, _ ->
                    dialog.dismiss()
                }.show()


        }

        reviewRatingViewModel.getReportReviewObserver.observe(viewLifecycleOwner) {
            MaterialAlertDialogBuilder(requireContext())
                .setMessage(it.message)
                .setPositiveButton(getString(R.string.ok)) { dialog, _ ->
                    dialog.dismiss()
                }.show()


        }


    }


    private fun setupProfileData(profileData: PublicProfileData) {
        mPublicProfileData = profileData
        mPublicProfileData?.let {
            Glide.with(requireContext())
                .load(Global.getImageUrl(it.userImg))
                .placeholder(R.drawable.ic_user)
                .error(R.drawable.ic_user)
                .into(binding.ivProfile)
            binding.tvName.text = it.name
            if (it.myreview.isNotEmpty()) {
                binding.ratingBarReview.rating = it.myreview[0].rating
                isEditRating = true
            }
            mReviewsAdapter?.setData(it.reviews)


        }

    }

    private fun setupRatingChangeListener() {
        binding.ratingBarReview.setOnRatingChangeListener { ratingBar, rating, fromUser ->
            Log.d(TAG, "setupRatingChangeListener: fromUser = $fromUser  == rating = $rating")
            if (fromUser && rating != 0.0f) {
                mPublicProfileData?.let { user ->
                    val direction =
                        PublicProfileFragmentDirections.actionNavPublicProfileFragmentToAddReviewFragment(
                            rating,
                            if (isEditRating) mPublicProfileData?.myreview?.get(0)?.review!! else "",
                            user.userImg,
                            user.name,
                            user.id,
                            isEditRating,
                            if (isEditRating) mPublicProfileData?.myreview?.get(0)?.id!! else return@let
                        )
                    binding.ratingBarReview.rating = 0.0f
                    findNavController().navigate(direction)
                }

            }

        }

    }

    private fun setUpListener() {
        binding.topAppBar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
        binding.btReport.setOnClickListener {
            val userReportFragmentBottomDialogDialogFragment: UserReportDialogFragment =
                UserReportDialogFragment().newInstance(navArgs.userId)
            userReportFragmentBottomDialogDialogFragment.show(
                requireActivity().supportFragmentManager,
                getString(R.string.dialog_filter)
            )
        }
        binding.btBlock.setOnClickListener {
            openConfirmationDialog()
        }
        binding.btWriteReview.setOnClickListener {
            val rating = binding.ratingBarReview.rating

            mPublicProfileData?.let { user ->
                val direction =
                    PublicProfileFragmentDirections.actionNavPublicProfileFragmentToAddReviewFragment(
                        if (rating == 0.0f) 1.0f else rating,
                        "",
                        user.userImg ?: "",
                        user.name ?: "",
                        user.id
                    )
                binding.ratingBarReview.rating = 0.0f
                findNavController().navigate(direction)

            }

        }

        binding.btSeeFullReviews.setOnClickListener {
            val direction =
                PublicProfileFragmentDirections.actionNavPublicProfileFragmentToNavSeeAllReviewsFragment(
                    navArgs.userId,
                    mPublicProfileData?.name ?: "",
                    mPublicProfileData?.userImg ?: "",

                    )
            it.findNavController().navigate(direction)
        }
    }

    private fun openConfirmationDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.message_block_user))
            .setPositiveButton(getString(R.string.block)) { dialog, arg1 ->
                accountViewModel.blockUser(
                    mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
                    navArgs.userId
                )
            }
            .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mIMainActivity = context as IMainActivity
    }

    override fun onDetach() {
        super.onDetach()
        mIMainActivity = null
    }


    override fun onItemClick(post: Post) {
        val directions =
            NavGraphDirections.actionGlobalNavPostDetailFragment(
                post.id
            )
        findNavController().navigate(directions)
    }

    override fun onOptionClick(review: Review, position: Int, view: View) {
        mClickedPosition = position

        showReviewPopupMenu(review, view)


    }

    private fun showReviewPopupMenu(review: Review, view: View) {

        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.menuInflater.inflate(R.menu.menu_reviews, popupMenu.menu)

        popupMenu.menu.findItem(R.id.popup_menu_report).setVisible(
            review.reviewByUserId != mIMainActivity?.getPreference()?.getCurrentUser()?.id
        )

        popupMenu.menu.findItem(R.id.popup_menu_edit).setVisible(
            review.reviewByUserId == mIMainActivity?.getPreference()?.getCurrentUser()?.id
        )
        popupMenu.menu.findItem(R.id.popup_menu_delete).setVisible(
            review.reviewByUserId == mIMainActivity?.getPreference()?.getCurrentUser()?.id
        )

        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.popup_menu_edit -> {
                    val direction =
                        PublicProfileFragmentDirections.actionNavPublicProfileFragmentToAddReviewFragment(
                            review.rating,
                            review.review,
                            mPublicProfileData?.userImg ?: "",
                            mPublicProfileData?.name ?: "",
                            mPublicProfileData?.id ?: 0,
                            true,
                            review.id
                        )
                    findNavController().navigate(direction)
                    return@setOnMenuItemClickListener true
                }
                R.id.popup_menu_delete -> {
                    showDeleteReviewAlert(review)
                    return@setOnMenuItemClickListener true
                }
                R.id.popup_menu_report -> {
                    reviewRatingViewModel.reportReview(
                        mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN)?:"",
                        review.id
                    )
                    return@setOnMenuItemClickListener true
                }

                else -> return@setOnMenuItemClickListener false
            }
        }
        popupMenu.show()

    }

    private fun showDeleteReviewAlert(review: Review) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.alert))
            .setMessage(getString(R.string.messageSureDeleteReview))
            .setPositiveButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.delete)) { dialog, _ ->
                dialog.dismiss()
                reviewRatingViewModel.deleteReviewFromUserProfile(
                    mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
                    review.reviewToUserId,
                    review.id
                )


            }
            .show()

    }


}