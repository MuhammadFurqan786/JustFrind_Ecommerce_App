package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.justfriends.R
import com.justfriends.adapter.ReviewsAdapter
import com.justfriends.databinding.FragmentSeeAllReviewsBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.model.Review
import com.justfriends.preference.PreferenceHelper
import com.justfriends.utils.Global
import com.justfriends.utils.PrefKeys
import com.justfriends.viewModel.ReviewRatingViewModel


class SeeAllReviewsFragment : Fragment(), ReviewsAdapter.IReview {
    lateinit var binding: FragmentSeeAllReviewsBinding
    private val navArgs: SeeAllReviewsFragmentArgs by navArgs()
    private var mReviewsAdapter: ReviewsAdapter? = null
    private val reviewRatingViewModel: ReviewRatingViewModel by viewModels()
    private lateinit var helper: PreferenceHelper
    private var mIMainActivity: IMainActivity? = null
    private var mClickedPosition = -1;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mReviewsAdapter = ReviewsAdapter()
        mReviewsAdapter?.setOnReviewClickListener(this)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSeeAllReviewsBinding.inflate(inflater, container, false)
        helper = PreferenceHelper.getPref(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvReviews.setHasFixedSize(true)
        binding.rvReviews.adapter =mReviewsAdapter
        reviewRatingViewModel.getAllReviews(mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "", navArgs.userId)
        setUplistener()
        setupObserver()
        setupDeleteReviewObserver()
    }

    private fun setupObserver() {
        reviewRatingViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        reviewRatingViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        reviewRatingViewModel.getAllReviewsObserver.observe(viewLifecycleOwner) {
            mReviewsAdapter?.setData(it)

        }
        reviewRatingViewModel.getDeleteReviewObserver.observe(viewLifecycleOwner) {
            Global.showMessage(binding.root, it.message)
            mReviewsAdapter?.removeItem(mClickedPosition)
        }
       
        reviewRatingViewModel.getReportReviewObserver.observe(viewLifecycleOwner) {
            MaterialAlertDialogBuilder(requireContext())
                .setMessage(it.message)
                .setPositiveButton(getString(R.string.ok)) { dialog, _ ->
                    dialog.dismiss()
                }.show()


        }


    }

    private fun setupDeleteReviewObserver() {
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
                .setPositiveButton(getString(R.string.ok)){dialog,_ ->
                    dialog.dismiss()
                }.show()


        }


    }

    private fun setUplistener() {
        binding.topAppBar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
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
                            navArgs.userImg,
                            navArgs.userName,
                            navArgs.userId,
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
            .setPositiveButton(getString(R.string.cancel)){dialog,_->
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.delete)){dialog,_ ->
                dialog.dismiss()
                reviewRatingViewModel.deleteReviewFromUserProfile(
                    mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN)?:"",
                    review.reviewToUserId,
                    review.id
                )


            }
            .show()

    }



}