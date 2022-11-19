package com.exampleone.testingapp.presentation.fragments.product_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.exampleone.testingapp.R
import com.exampleone.testingapp.databinding.FragmentFirstBinding
import com.exampleone.testingapp.databinding.FragmentSecondBinding
import com.exampleone.testingapp.presentation.fragments.product_fragments.adapter.PharmProdAdapter

class SecondFragment : Fragment() {

    private val binding by lazy {
        FragmentSecondBinding.inflate(layoutInflater)
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
        val recyclerView = binding.rcSecond
        pharmProdAdapter = PharmProdAdapter(requireContext(),photoUrl.toMutableList())
        recyclerView.adapter = pharmProdAdapter
    }



    private val photoUrl = listOf(
        "https://sankt-peterburg.vse-footbolki.ru/image/cache/catalog/vsm/0/1/1925/1925159/previews/people_1_sign_front_white_700-280x280.jpg",
        "https://imagetext2.ru/pics_max/imagetext_ru_27626.jpg",
        "https://i.pinimg.com/280x280_RS/56/4e/5f/564e5ff55817527e72df9816392f411e.jpg",
        "https://coolsen.ru/wp-content/uploads/2021/09/184.jpg",
        "https://coolsen.ru/wp-content/uploads/2021/06/138-8.jpg",
        "https://drasler.ru/wp-content/uploads/2019/10/%D0%A1%D0%BA%D0%B0%D1%87%D0%B0%D1%82%D1%8C-%D0%BA%D1%80%D1%83%D1%82%D1%8B%D0%B5-%D0%B8-%D0%BB%D1%83%D1%87%D1%88%D0%B8%D0%B5-%D1%84%D0%BE%D1%82%D0%BE-%D0%BD%D0%B0-%D0%B0%D0%B2%D0%B0%D1%82%D0%B0%D1%80%D0%BA%D1%83-%D0%B2-%D0%B2%D0%BA-%D0%B4%D0%BB%D1%8F-%D0%BF%D0%B0%D1%86%D0%B0%D0%BD%D0%BE%D0%B2014.jpg",
        "https://sankt-peterburg.vse-footbolki.ru/image/cache/catalog/vsm/0/1/1925/1925159/previews/people_1_sign_front_white_700-280x280.jpg",
        "https://placepic.ru/wp-content/uploads/2021/02/kinopoisk_ru_Brad_Pi-41.jpg",
        "https://i.pinimg.com/280x280_RS/56/4e/5f/564e5ff55817527e72df9816392f411e.jpg",
        "https://imagetext2.ru/pics_max/imagetext_ru_27626.jpg"
    )

}