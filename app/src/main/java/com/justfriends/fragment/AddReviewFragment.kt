package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.justfriends.R
import com.justfriends.databinding.FragmentAddReviewBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.utils.Global
import com.justfriends.utils.PrefKeys
import com.justfriends.viewModel.ReviewRatingViewModel

private const val TAG = "AddReviewFragment"

class AddReviewFragment : Fragment() {
    private lateinit var binding: FragmentAddReviewBinding
    private val navArgs: AddReviewFragmentArgs by navArgs()
    private var mIMainActivity : IMainActivity?=null
    private val reviewRatingViewModel: ReviewRatingViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddReviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupData()
        setupObserver()
        setupListener()
        setupCommentTextChangeListener()

    }

    private fun setupCommentTextChangeListener() {
        binding.etComment.addTextChangedListener {
           val count =  "${it.toString().length}/500"
            binding.tvCommentLetterCount.text = count
        }
    }


    private fun setupData() {
        Glide.with(requireContext())
            .load(Global.getImageUrl(navArgs.userImage)).into(binding.ivUser)
        Glide.with(requireContext())
            .load(Global.getImageUrl(navArgs.userImage)).into(binding.ivUser1)
        binding.tvUserName.text = navArgs.userName
        binding.tvUserName1.text = navArgs.userName
        binding.ratingBarReview.rating = navArgs.rating
        binding.etComment.setText(navArgs.comment)

    }

    private fun setupObserver() {
        reviewRatingViewModel.getMessageObserver.observe(viewLifecycleOwner){
            mIMainActivity?.showMessage(it)
        }
        reviewRatingViewModel.getProgressObserver.observe(viewLifecycleOwner){
            mIMainActivity?.showProgress(it)
        }
        reviewRatingViewModel.getAddReviewToUserProfileObserver.observe(viewLifecycleOwner){
            MaterialAlertDialogBuilder(requireContext())
                .setMessage(it.message)
                .setPositiveButton(getString(R.string.ok)){dialog,_->
                    dialog.dismiss()
                    findNavController().navigateUp()
                }
                .show()
        }

    }

    private fun setupListener() {
        binding.ivClose.setOnClickListener {
            it.findNavController().navigateUp()
        }

        binding.btSend.setOnClickListener {
            validateData()
        }



    }

    private fun validateData() {
        val rating = binding.ratingBarReview.rating
        val comment = binding.etComment.text.toString().trim()

        if(rating ==0f){
         mIMainActivity?.showMessage(getString(R.string.messagePleaseSelectRating))
         return
        }

        if(comment.isEmpty()){
            mIMainActivity?.showMessage(getString(R.string.messagePleaseAddAComment))
            return
        }

        Global.hideKeyboard(requireContext(),binding.root)

        if(navArgs.isEditReview){
            reviewRatingViewModel.editUserProfileReview(
                mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN)?:"",
                navArgs.reviewId,
                navArgs.userId,
                comment,
                rating
            )
        }else{
            reviewRatingViewModel.addReviewToUserProfile(
                mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN)?:"",
                navArgs.userId,
                comment,
                rating
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