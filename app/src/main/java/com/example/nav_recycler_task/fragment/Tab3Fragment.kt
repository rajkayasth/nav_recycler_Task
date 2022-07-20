package com.example.nav_recycler_task.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nav_recycler_task.R
import com.example.nav_recycler_task.adapters.RecyclerAdopter
import com.example.nav_recycler_task.api.RetroFitClient
import com.example.nav_recycler_task.databinding.FragmentTab3Binding
import com.example.nav_recycler_task.models.Article
import com.example.nav_recycler_task.respository.NewsRespository
import com.example.nav_recycler_task.viewModels.DemoViewModel
import com.example.nav_recycler_task.viewModels.DemoViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.chip.ChipGroup
import com.google.android.material.textview.MaterialTextView


class Tab3Fragment : Fragment() {

    private var _binding: FragmentTab3Binding? = null
    private val binding get() = _binding!!
    lateinit var recyclerAdopter: RecyclerAdopter
    lateinit var newList: ArrayList<Article>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab3, container, false)

        var author: String

        val apiService = RetroFitClient.getInstance()
        var repository = NewsRespository(apiService)

        var viewModel = ViewModelProvider(
            requireActivity(),
            DemoViewModelFactory(respository = repository)
        )[DemoViewModel::class.java]

        newList = arrayListOf()
        viewModel.quotes.observe(viewLifecycleOwner) {
          //  Log.e("Tab3", it.articles.toString())
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
            newList.addAll(it.articles)
            recyclerAdopter = RecyclerAdopter(it.articles)
            binding.recyclerView.adapter = recyclerAdopter
        }


        binding.btnFilter.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext())

            val view = layoutInflater.inflate(R.layout.bottomsheet_dailog_layout, null)

            val btnClose = view.findViewById<MaterialTextView>(R.id.txtViewReset)
            val btnDone = view.findViewById<MaterialTextView>(R.id.txtViewDone)
            val editText = view.findViewById<EditText>(R.id.edTxtAuthor)

            val chipGroup = view.findViewById<ChipGroup>(R.id.chipGroup)


            btnDone.setOnClickListener {
                author = editText.text.toString()

               val list = newList.filter { it.author == author }
               // Log.e("list", chip)
                binding.recyclerView.adapter = RecyclerAdopter(list)
                dialog.dismiss()
            }


            btnClose.setOnClickListener {
                binding.recyclerView.adapter = RecyclerAdopter(newList)
                dialog.dismiss()

            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()
        }


        return binding.root
    }

}