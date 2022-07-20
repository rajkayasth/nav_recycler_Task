package com.example.nav_recycler_task.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.nav_recycler_task.R
import com.example.nav_recycler_task.databinding.FragmentDetailsBinding
import com.example.nav_recycler_task.models.ItemDetails
import java.io.Serializable


class DetailsFragment : Fragment() {

    private var _binding : FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater ,R.layout.fragment_details, container, false)

        val transactionList = arguments?.getSerializable("key") as ItemDetails
        Log.e("List",transactionList.toString())

//        val bundle = Bundle()
//
//        val itemDetails: ItemDetails? = bundle.getSerializable("key") as ItemDetails?

        //Log.e("Details",itemDetails.toString())


        val image = transactionList.imageUrl
        val title = transactionList.Title
        val description = transactionList.Description

        Glide.with(requireContext())
            .load(image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.detailsImage)

        binding.detailsTitle.text = title
        binding.detailsDescription.text = description

        return binding.root
    }

}