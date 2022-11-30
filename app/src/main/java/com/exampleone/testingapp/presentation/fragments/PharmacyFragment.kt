package com.exampleone.testingapp.presentation.fragments


import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
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
        launchSearchFrag()
        launchSearchFragIfMoreChar()

        binding.docScan.setOnClickListener {
            scanCode()
        }

    }

    private fun launchSearchFragIfMoreChar() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    if (newText.isNotEmpty()) {
                        findNavController().navigate(R.id.action_pharmacyFragment_to_searchResultFragment)
                    }
                }
                return false
            }
        })
    }

    private fun launchSearchFrag() {
        binding.searchView.inputType = InputType.TYPE_NULL
        binding.searchView.setOnQueryTextFocusChangeListener(object : OnFocusChangeListener {
            override fun onFocusChange(view: View?, isActive: Boolean) {
                if (isActive) {
                    findNavController().navigate(R.id.action_pharmacyFragment_to_searchResultFragment)

                }
            }
        })
    }

    private fun initAdapterAction() {
        binding.apply {
            actionAdapter = ActionAdapter(initList())
            rcAction.adapter = actionAdapter
            rcAction.animation = null
            val customSnapHelper = CustomSnapHelper()
            rcAction.onFlingListener = null
            customSnapHelper.attachToRecyclerView(rcAction)
        }
    }

    private var barcodeLauncher = registerForActivityResult(
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
        /* для того, чтобы pop бэкстэк работал нормально*/
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
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK) {
            binding.searchView.setQuery(
                data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.get(0).toString(),
                false
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
}



