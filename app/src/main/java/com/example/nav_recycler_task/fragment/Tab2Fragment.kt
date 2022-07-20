package com.example.nav_recycler_task.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.TabHostBindingAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.nav_recycler_task.R
import com.example.nav_recycler_task.api.RetroFitClient
import com.example.nav_recycler_task.databinding.FragmentTab2Binding
import com.example.nav_recycler_task.respository.NewsRespository
import com.example.nav_recycler_task.viewModels.DemoViewModel
import com.example.nav_recycler_task.viewModels.DemoViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Tab2Fragment : Fragment() {

    private var _binding: FragmentTab2Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab2, container, false)


        val apiService = RetroFitClient.getInstance()
        var repository = NewsRespository(apiService)

        var viewModel = ViewModelProvider(requireActivity(),DemoViewModelFactory(respository = repository))[DemoViewModel::class.java]


        binding.btnSend.setOnClickListener {
            val text = binding.edTextMsg.text.toString()
            val page = binding.edTextPage.text.toString()
            viewModel.setHeadline(text,page.toInt())
            val tab3Fragment =  Tab3Fragment()
            parentFragmentManager.beginTransaction().replace(R.id.tab2Id,tab3Fragment)

        }

        return binding.root
    }

}