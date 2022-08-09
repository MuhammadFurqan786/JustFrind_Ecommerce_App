package com.justfriends.fragment


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.justfriends.R
import com.justfriends.adapter.PostsAdapter
import com.justfriends.databinding.FragmentSearchBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.preference.PreferenceKeys
import com.justfriends.utils.Global
import com.justfriends.viewModel.FavouriteViewModel

import android.view.inputmethod.EditorInfo
import com.iamport.sampleapp.ui.PaymentActivity
import com.justfriends.NavGraphDirections
import com.justfriends.model.Post
import com.justfriends.utils.PrefKeys
import com.justfriends.viewModel.PostViewModel


class SearchFragment : Fragment(), PostsAdapter.IPost, SortDialogFragment.SortOptionClickListener,
    FilterDialogFragment.ApplyFilterInterface {
    lateinit var binding: FragmentSearchBinding
    private val navArgs: SearchFragmentArgs by navArgs()
    private val postViewModel: PostViewModel by viewModels()
    private val favouriteViewModel: FavouriteViewModel by viewModels()

    private var mIMainActivity: IMainActivity? = null
    private var mPostAdapter: PostsAdapter? = null
    private var mClickedPosition: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPostAdapter = PostsAdapter()
        mPostAdapter?.setOnPostClickListener(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvPosts.setHasFixedSize(true)
        binding.rvPosts.adapter = mPostAdapter
        getPosts()
        setupFavouriteObserver()
        setupObserver()
        setupListener()
    }

    private fun getPosts() {
        if (!navArgs.isFromSearch) {
            postViewModel.getCategoryPosts(
                mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
                navArgs.categoryId
            )

        }

    }

    private fun setupFavouriteObserver() {
        favouriteViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }

        favouriteViewModel.getFavouriteStatusObserver.observe(viewLifecycleOwner) {
            mClickedPosition = if (it) {
                mPostAdapter?.notifyItem(1, mClickedPosition)
                -1
            } else {
                mPostAdapter?.notifyItem(0, mClickedPosition)
                -1
            }
        }
    }

    private fun setupObserver() {
        postViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        postViewModel.getProgressObserver.observe(viewLifecycleOwner) {

            mIMainActivity?.showProgress(it)

        }
        postViewModel.getPostsObserver.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                binding.emptyFile.root.visibility = View.VISIBLE
                binding.rvPosts.visibility = View.GONE
            } else {
                binding.emptyFile.root.visibility = View.GONE
                binding.rvPosts.visibility = View.VISIBLE
                mPostAdapter?.setData(it)
            }


        }
    }

    private fun setupListener() {
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btFilter.setOnClickListener {
            val addFilterBottomDialogFragment: FilterDialogFragment =
                FilterDialogFragment().newInstance()
            addFilterBottomDialogFragment.show(
                requireActivity().supportFragmentManager,
                getString(R.string.dialog_filter)
            )
        }
        binding.btSort.setOnClickListener {
            val addSortDialogFragment: SortDialogFragment = SortDialogFragment().newInstance()
            addSortDialogFragment.show(
                requireActivity().supportFragmentManager,
                getString(R.string.dialog_sort)
            )
        }

        binding.etSearch.setOnEditorActionListener { textView, i, keyEvent ->

            if (i == EditorInfo.IME_ACTION_SEARCH) {
                validateAndSearchPosts()
            }
            true
        }
    }

    private fun validateAndSearchPosts() {
        Global.hideKeyboard(requireContext(), binding.root)
        val keyword = binding.etSearch.text.toString().trim()
        if (keyword.isEmpty()) {
            mIMainActivity?.showMessage(getString(R.string.message_search_keyword_required))
            return
        }

        postViewModel.getSearchPosts(
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
            binding.etSearch.text.toString().trim()
        )
    }


    override fun onItemClick(post: Post) {
        val direction = NavGraphDirections.actionGlobalNavPostDetailFragment(post.id)
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

    override fun onTradingClick(postId: Long, userId: Int, position: Int) {
        startActivity(Intent(context, PaymentActivity::class.java))
    }

    override fun onApplyFiledClick(
        minPrice: String,
        maxPrice: String,
        condition: String,
        distance: String,
    ) {
        postViewModel.getFilteredPosts(
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
            navArgs.categoryId.toString(),
            mIMainActivity?.getPreference()?.getStringValue(PreferenceKeys.KEY_SORT_BY) ?: "",
            minPrice,
            maxPrice,
            condition,
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_LATITUDE) ?: "",
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_LONGITUDE) ?: "",
            distance
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mIMainActivity = context as IMainActivity
    }

    override fun onDetach() {
        super.onDetach()
        mIMainActivity = null
    }

    override fun onSortOptionClick(sort: String) {
        postViewModel.getFilteredPosts(
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
            navArgs.categoryId.toString(),
            sort,
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_MIN_PRICE) ?: "",
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_MAX_PRICE) ?: "",
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_CONDITION) ?: "",
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_LATITUDE) ?: "",
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_LONGITUDE) ?: "",
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_DISTANCE) ?: "",

            )
    }


}