package com.exampleone.testingapp.presentation.fragments.product_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.exampleone.testingapp.R
import com.exampleone.testingapp.databinding.FragmentSecondBinding
import com.exampleone.testingapp.databinding.FragmentThirdBinding
import com.exampleone.testingapp.presentation.fragments.product_fragments.adapter.PharmProdAdapter

class ThirdFragment : Fragment() {

    private val binding by lazy {
        FragmentThirdBinding.inflate(layoutInflater)
    }
    lateinit var pharmProdAdapter: PharmProdAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initRec()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initRec() {
        val recyclerView = binding.rcThird
        pharmProdAdapter = PharmProdAdapter(requireContext(),photoUrl.toMutableList())
        recyclerView.adapter = pharmProdAdapter
    }



    private val photoUrl = listOf(
        "https://i.pinimg.com/280x280_RS/56/4e/5f/564e5ff55817527e72df9816392f411e.jpg",
        "https://imagetext2.ru/pics_max/imagetext_ru_27626.jpg",
        "https://imagetext2.ru/pics_max/imagetext_ru_27626.jpg",
        "https://coolsen.ru/wp-content/uploads/2021/09/184.jpg",
        "https://placepic.ru/wp-content/uploads/2021/02/kinopoisk_ru_Brad_Pi-41.jpg",
        "https://i.pinimg.com/280x280_RS/56/4e/5f/564e5ff55817527e72df9816392f411e.jpg",
        "https://sankt-peterburg.vse-footbolki.ru/image/cache/catalog/vsm/0/1/1925/1925159/previews/people_1_sign_front_white_700-280x280.jpg",
        "https://placepic.ru/wp-content/uploads/2021/02/kinopoisk_ru_Brad_Pi-41.jpg",
        "https://i.pinimg.com/280x280_RS/56/4e/5f/564e5ff55817527e72df9816392f411e.jpg",
        "https://imagetext2.ru/pics_max/imagetext_ru_27626.jpg"
    )

}
