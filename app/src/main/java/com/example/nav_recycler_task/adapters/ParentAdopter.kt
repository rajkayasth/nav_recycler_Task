package com.example.nav_recycler_task.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nav_recycler_task.databinding.RecyclerItemLayoutBinding
import com.example.nav_recycler_task.models.ItemDetails

class ParentAdopter(private val ImageList:ArrayList<ItemDetails>,private val onItemClickListener: ChildAdopter.OnItemClickListener) : RecyclerView.Adapter<ParentAdopter.ViewHolderParent>() {
    inner class ViewHolderParent(recyclerItemLayoutBinding: RecyclerItemLayoutBinding) :
        RecyclerView.ViewHolder(recyclerItemLayoutBinding.root) {
        val childRecyler = recyclerItemLayoutBinding.childRecyclerView
        val parentCardLayout = recyclerItemLayoutBinding.reyclerItemCard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderParent {
        val binding = RecyclerItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderParent(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderParent, position: Int) {
        holder.childRecyler.layoutManager = LinearLayoutManager(holder.itemView.context,LinearLayoutManager.HORIZONTAL,false)
        val childAdapter = ChildAdopter(ImageList,onItemClickListener)
        holder.childRecyler.adapter = childAdapter

    }

    override fun getItemCount(): Int {
        return 20
    }
}