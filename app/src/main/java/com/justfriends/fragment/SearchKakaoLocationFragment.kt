package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.justfriends.R
import com.justfriends.adapter.KakaoLocationAdapter
import com.justfriends.databinding.FragmentSearchKakaoLocationBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.model.DocumentsItem
import com.justfriends.preference.PreferenceHelper
import com.justfriends.preference.PreferenceKeys
import com.justfriends.utils.Global
import com.justfriends.utils.PrefKeys
import com.justfriends.viewModel.KakaoMapViewModel


class SearchKakaoLocationFragment : Fragment(), KakaoLocationAdapter.LocationClickListener {
    private lateinit var binding: FragmentSearchKakaoLocationBinding
    private lateinit var helper: PreferenceHelper
    private var mIMainActivity: IMainActivity? = null
    private val kakaoViewModel: KakaoMapViewModel by viewModels()
    private var adapterKakaoLocations: KakaoLocationAdapter? = null
    private val navArgs: SearchKakaoLocationFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        helper = PreferenceHelper.getPref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchKakaoLocationBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mIMainActivity?.showAnimation(true)
        setupListener()
        setupObserver()
    }

    private fun setupObserver() {

        kakaoViewModel.getKakaoMapObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showAnimation(false)
            adapterKakaoLocations = KakaoLocationAdapter(it.documents, this)
            binding.rvKakaoMapLocations.adapter = adapterKakaoLocations
            if (it.documents.isNullOrEmpty()) {
                Global.showMessage(binding.root, getString(R.string.message_no_data_found))
            }
        }
    }

    private fun setupListener() {
        binding.topAppBar.setNavigationOnClickListener {
            mIMainActivity?.showAnimation(false)
            findNavController().navigateUp()
        }
        binding.etSearch.requestFocus()
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(
                s: CharSequence, start: Int, before: Int,
                count: Int
            ) {
                if (count == 0) {
                    mIMainActivity?.showAnimation(true)

                }
                context?.let {
                    PreferenceHelper.getPref(it).getStringValue(PreferenceKeys.KEY_LOCATION)?.let {
                        kakaoViewModel.getKakaoMap(mIMainActivity?.getPreference()?.getStringValue(
                            PrefKeys.KEY_USER_TOKEN) ?: "",
                            binding.etSearch.text.toString().trim()

                        )
                    }
                }
               // KakaoAK 2d7c9c8c9a403b7b28eead5e68aaadd9

            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {
                mIMainActivity?.showAnimation(true)
            }

            override fun afterTextChanged(s: Editable) {

                mIMainActivity?.showAnimation(true)
            }
        })

        binding.etSearch.setOnEditorActionListener {
                  textView, keyCode, keyEvent ->
              kakaoViewModel.getKakaoMap(
                  mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
                  binding.etSearch.text.toString().trim()
              )
              false
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

    override fun onLocationClick(mapData: DocumentsItem?) {
        if (navArgs.isFrom) {
            val directions =
                SearchKakaoLocationFragmentDirections.actionNavSearchKakaoLocationFragmentToNavHomeFragment()
            findNavController().navigate(directions)
        } else {
            val directions =
                SearchKakaoLocationFragmentDirections.actionNavSearchKakaoLocationFragmentToNavPostAdFragment(
                    "", "", mapData?.addressName!!, mapData.X!!, mapData.Y!!
                )
            findNavController().navigate(directions)
        }

    }


}