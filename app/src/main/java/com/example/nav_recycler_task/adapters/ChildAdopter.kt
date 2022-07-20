package com.example.nav_recycler_task.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.nav_recycler_task.databinding.ChildRecyclerItemBinding
import com.example.nav_recycler_task.models.ItemDetails

class ChildAdopter(private val ImageList: ArrayList<ItemDetails>,private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<ChildAdopter.ChildViewHolder>() {

    interface OnItemClickListener{
        fun onItemClickDetails(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val binding =
            ChildRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChildViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(ImageList[position].imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.image)
        Log.e("ImageList", ImageList.toString())
        holder.title.text = ImageList[position].Title
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClickDetails(position)
        }
    }

    override fun getItemCount(): Int {
        return ImageList.size
    }

    inner class ChildViewHolder(childRecyclerItemBinding: ChildRecyclerItemBinding) :
        RecyclerView.ViewHolder(childRecyclerItemBinding.root) {

        val image = childRecyclerItemBinding.imageviewChildRecycler
        val title = childRecyclerItemBinding.txtTitle



    }
}