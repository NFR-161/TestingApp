package com.exampleone.testingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.exampleone.testingapp.adapters.PeopleAdapter
import com.exampleone.testingapp.data.User
import com.exampleone.testingapp.databinding.FragmentPeopleBinding

class PeopleFragment : Fragment() {

    private lateinit var  peopleAdapter: PeopleAdapter

    private val binding by lazy {
        FragmentPeopleBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val listImages = arrayOf(
            User("https://kartinkin.net/uploads/posts/2022-02/1645377795_2-kartinkin-net-p-moto-kartinki-2.jpg"),
            User("https://bikeland.ru/upload/medialibrary/95a/tvvb3un3nwknlltyk13qh1iu5g9rdvht/hus401.png"),
            User("https://a.d-cd.net/ac6ea72s-960.jpg"),
            User("https://basetop.ru/wp-content/uploads/2022/03/harley-davidson-sportster-s.jpg"),
            User("https://img2.akspic.ru/crops/1/1/0/0/7/170011/170011-motocikl-aksessuary_dlya_motociklov-fara-shina-koleso-1080x1920.png"),
            User("https://vyborok.com/wp-content/uploads/2019/02/prevyu-1.jpg"),
            User("https://hdpic.club/pic77.php?src=https://hdpic.club/uploads/posts/2021-11/thumbs/1637764004_1-hdpic-club-p-mototsikli-na-avatarku-2.jpg&w=330&h=490&zc=1"),
        )
       peopleAdapter = PeopleAdapter(listImages)
        binding.rcPeople.adapter =  peopleAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}