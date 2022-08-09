package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.justfriends.adapter.FavoritesAdapter
import com.justfriends.databinding.FragmentFavoritesBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.model.FavouriteItem
import com.justfriends.preference.PreferenceHelper
import com.justfriends.preference.PreferenceKeys
import com.justfriends.utils.PrefKeys
import com.justfriends.viewModel.FavouriteViewModel


class FavoritesFragment : Fragment(), FavoritesAdapter.FavItemClickInterFace {
    lateinit var binding: FragmentFavoritesBinding
    private val favouriteViewModel: FavouriteViewModel by viewModels()
    private lateinit var helper: PreferenceHelper
    private var mIMainActivity: IMainActivity? = null
    private var favouriteAdapter: FavoritesAdapter? = null
    private var mClickedPosition = -1;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        helper = PreferenceHelper.getPref(requireContext())
        val auth=PreferenceHelper.getPref(requireContext()).getStringValue(PrefKeys.KEY_USER_TOKEN)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favouriteViewModel.getFavouritePosts(helper.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "")
        setUpObserver()
    }

    private fun setUpObserver() {
        favouriteViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        favouriteViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        favouriteViewModel.getFavouritesObserver.observe(viewLifecycleOwner) {

            favouriteAdapter = FavoritesAdapter(it, this)
            binding.rvFavorites.adapter = favouriteAdapter

        }


        favouriteViewModel.getFavouriteStatusObserver.observe(viewLifecycleOwner) {
            if (!it) {
                favouriteAdapter?.removeItem(mClickedPosition)

            }
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

    companion object {
        @JvmStatic
        fun newInstance() =
            FavoritesFragment()
    }

    override fun onItemClick(post: FavouriteItem) {
    }

    override fun onFavClick(postId: Long, isFav: Int, position: Int) {
        mClickedPosition = position
        favouriteViewModel.removeFromFav(
            helper.getStringValue("token") ?: "",
            postId
        )
    }
}