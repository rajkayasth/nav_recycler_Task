package com.example.nav_recycler_task.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nav_recycler_task.fragment.*


class PagerAdopter (fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 10
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> Tab1Fragment()
            1 -> Tab2Fragment()
            2 -> Tab3Fragment()
            3 -> Tab4Fragment()
            4 -> Tab5Fragment()
            5 -> Tab6Fragment()
            6 -> Tab7Fragment()
            7 -> Tab8Fragment()
            8 -> Tab9Fragment()
            else -> Tab10Fragment()
        }
    }

}