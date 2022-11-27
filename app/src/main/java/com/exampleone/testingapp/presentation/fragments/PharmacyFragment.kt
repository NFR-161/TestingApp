package com.exampleone.testingapp.presentation.fragments


import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.*
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.exampleone.testingapp.R
import com.exampleone.testingapp.databinding.FragmentPharmacyBinding
import com.exampleone.testingapp.presentation.fragments.product_fragments.adapter.ActionAdapter
import com.exampleone.testingapp.presentation.fragments.product_fragments.adapter.ProductStateAdapter
import com.exampleone.testingapp.presentation.fragments.product_fragments.adapter.RecentlyOrderAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions
import me.relex.circleindicator.CircleIndicator3


class PharmacyFragment : Fragment() {


    private lateinit var actionAdapter: ActionAdapter
    lateinit var recentlyAdapter: RecentlyOrderAdapter

//    var isAutoScroll = true
    //    private var coroutineScope = CoroutineScope(Dispatchers.Main)

    private val binding by lazy {
        FragmentPharmacyBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPager()
        initCircleIndicator()
        initAdapterAction()
        initAdapterRecently()
        speak()

        binding.docScan.setOnClickListener {
            scanCode()
        }
        binding.searchView.setOnClickListener {
            view.findNavController().navigate(R.id.action_pharmacyFragment_to_searchResultFragment)
        }
    }

    private fun initAdapterAction() {
        actionAdapter = ActionAdapter(initList())
        binding.rcAction.adapter = actionAdapter
        binding.rcAction.animation = null
        val customSnapHelper = CustomSnapHelper()
        binding.rcAction.onFlingListener = null
        customSnapHelper.attachToRecyclerView(binding.rcAction)

    }

    var barcodeLauncher = registerForActivityResult(
        ScanContract()
    ) { result: ScanIntentResult ->
        if (result.contents == null) {
            Toast.makeText(requireContext(), "Cancelled", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(
                requireContext(),
                "Scanned: " + result.contents,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun initPager() {
        binding.viewPager.adapter = ProductStateAdapter(requireActivity())
        /* для того, чтобы бэкстэк работал нормально*/
        binding.viewPager.isSaveEnabled = false

        val tabLayoutMediator = binding.tabLayout.let {
            binding.viewPager.let { it1 ->
                TabLayoutMediator(it,
                    it1,
                    TabLayoutMediator.TabConfigurationStrategy { tab, position -> })
            }
        }
        tabLayoutMediator.attach()
    }

    private fun initCircleIndicator() {

        val indicator: CircleIndicator3 = binding.indicator
        indicator.setViewPager(binding.viewPager)
    }


    private fun initList(): List<Int> {
        return listOf(
            R.drawable.three,
            R.drawable.one,
            R.drawable.two,
            R.drawable.abstrakciya,
            R.drawable.black,
            R.drawable.purple
        )
    }

    private fun initAdapterRecently() {

        recentlyAdapter = RecentlyOrderAdapter(initList())
        binding.rcRecentlyOrder.adapter = recentlyAdapter
        val manager = LinearLayoutManager(requireContext())
        manager.orientation = HORIZONTAL
        binding.rcRecentlyOrder.layoutManager = manager
        binding.rcRecentlyOrder.animation = null
    }

    private fun speak() {
        binding.iconVoice.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Start speaking")
            startActivityForResult(intent, 100)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d("MyLog", "onActivityResult")
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK) {
            binding.searchView.setQuery(
                data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.get(0).toString(),
                false
            )
            Log.d(
                "MyLog",
                "ТЕКСТ: ${
                    data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.get(0).toString()
                }"
            )
        }
    }

    private fun scanCode() {
        val options = ScanOptions()
        options.setPrompt("Увеличьте громкость чтобы включить вспышку")
        options.setBeepEnabled(true)
        options.setOrientationLocked(true)
        options.captureActivity = CaptureAct::class.java
        barcodeLauncher.launch(options)
    }

//    private fun launchAutoscroll() {
//        val interval = 2000
//        var count = 0
//        binding.apply {
//            coroutineScope.launch {
//                while (isAutoScroll) {
//                    for (i in count until actionAdapter.itemCount) {
//                        rcAction.smoothScrollToPosition(count)
//                        Log.d("MyLog", "1 count: $count")
//                        count++
//                        delay(interval.toLong())
//
//                        if (count >= actionAdapter.itemCount) {
//                            while (count > 0) {
//                                rcAction.smoothScrollToPosition(count)
//                                Log.d("MyLog", "2 count: $count")
//                                count--
//                                delay(interval.toLong())
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }

    override fun onResume() {
        super.onResume()
//        isAutoScroll = true
//        launchAutoscroll()

    }

    override fun onPause() {
        super.onPause()
//        isAutoScroll = false

    }
}
//}


