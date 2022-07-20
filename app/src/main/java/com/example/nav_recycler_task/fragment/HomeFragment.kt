package com.example.nav_recycler_task.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.nav_recycler_task.R
import com.example.nav_recycler_task.adapters.PagerAdopter
import com.example.nav_recycler_task.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {
    var tabTitle   = arrayOf("Tab1","Tab2","Tab3","Tab4","Tab5","Tab6","Tab7","Tab8","Tab9","Tab10")
    private var _binding :FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater ,R.layout.fragment_home, container, false)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
//        tabLayout.setupWithViewPager(viewPager)
        val adapter = PagerAdopter(childFragmentManager, lifecycle)
        viewPager.adapter = adapter
        //viewPager.requestDisallowInterceptTouchEvent(true)
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
       // tabLayout.setupWithViewPager(viewPager)
        //viewPager.orientation   = ViewPager2.ORIENTATION_HORIZONTAL
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()

        return binding.root
    }


}