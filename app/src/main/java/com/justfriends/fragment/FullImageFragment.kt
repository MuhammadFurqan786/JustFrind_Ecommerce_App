package com.justfriends.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.justfriends.R
import com.justfriends.adapter.ImageSlidesShowAdapter
import com.justfriends.databinding.FragmentFullImageBinding

private const val TAG ="FullImageFragment"
class FullImageFragment : Fragment() {
    private lateinit var binding: FragmentFullImageBinding
    private var imgSlideShowAdapter: ImageSlidesShowAdapter? = null
    private val navArgs: FullImageFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFullImageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgSlideShowAdapter = ImageSlidesShowAdapter(navArgs.images, true)
        binding.pagerImages.adapter = imgSlideShowAdapter
        binding.pagerImages.post {
            binding.pagerImages.currentItem = navArgs.clickedPosition
        }

        setupListeners()
    }



    private fun setupListeners() {
        binding.fabBack.setOnClickListener {
           it.findNavController().navigateUp()
        }





    }



}