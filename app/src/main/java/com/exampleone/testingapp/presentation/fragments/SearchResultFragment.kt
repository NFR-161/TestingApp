package com.exampleone.testingapp.presentation.fragments

import android.R
import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.exampleone.testingapp.databinding.FragmentSearchResultBinding


class SearchResultFragment : Fragment() {

    private val binding by lazy {
        FragmentSearchResultBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        showKeyPad()

        binding.arrowBack.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        removeVoiceAndBar()

    }

    private fun removeVoiceAndBar() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                binding.apply {
                    val text = newText
                    if (text != null) {
                        if (text.length > 0) {
                            iconVoice.visibility = View.GONE
                            docScan.visibility = View.GONE
                        } else {
                            iconVoice.visibility = View.VISIBLE
                            docScan.visibility = View.VISIBLE
                        }
                    }
                    return false
                }
            }
        })
    }

    private fun showKeyPad() {
        binding.apply {
            searchView.apply {
                setIconifiedByDefault(false)
                isFocusable = true
                isIconified = false
                requestFocusFromTouch()
                requestFocus()
                inputType = InputType.TYPE_CLASS_TEXT
            }
        }

        binding.searchView.setOnQueryTextFocusChangeListener(object : View.OnFocusChangeListener {
            override fun onFocusChange(view: View?, boolean: Boolean) {
                if (boolean) {
                    val imm =
                        requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
                    imm!!.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
                } else {
                    val imm =
                        requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
                    imm!!.hideSoftInputFromWindow(view!!.windowToken, 0)
                }
            }
        })

    }
}