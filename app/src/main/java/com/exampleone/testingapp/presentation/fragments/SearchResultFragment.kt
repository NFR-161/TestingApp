package com.exampleone.testingapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.exampleone.testingapp.R
import com.exampleone.testingapp.databinding.FragmentSearchResultBinding

class SearchResultFragment : Fragment() {

    private val binding by lazy {
         FragmentSearchResultBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.arrowBack.setOnClickListener {

//            requireActivity().onBackPressed()
            findNavController().popBackStack()
//            view?.findNavController()?.navigate(R.id.action_searchResultFragment_to_pharmacyFragment)
        }


        return binding.root
    }

}