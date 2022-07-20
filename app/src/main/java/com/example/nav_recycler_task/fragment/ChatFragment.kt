package com.example.nav_recycler_task.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.nav_recycler_task.R
import com.example.nav_recycler_task.databinding.FragmentChatBinding
import com.example.nav_recycler_task.databinding.FragmentHomeBinding


class ChatFragment : Fragment() {

    private var _binding : FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater ,R.layout.fragment_chat, container, false)

        return binding.root
    }

}