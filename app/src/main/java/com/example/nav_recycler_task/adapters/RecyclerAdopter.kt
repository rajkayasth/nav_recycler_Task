package com.example.nav_recycler_task.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nav_recycler_task.databinding.RecylerItemTab3Binding
import com.example.nav_recycler_task.models.Article

class RecyclerAdopter(private val article: List<Article>) :
    RecyclerView.Adapter<RecyclerAdopter.MyViewHolder>() {
    inner class MyViewHolder(recylerItemTab3Binding: RecylerItemTab3Binding) :
        RecyclerView.ViewHolder(recylerItemTab3Binding.root) {
        val titleImage = recylerItemTab3Binding.newsImage
        val title = recylerItemTab3Binding.newsTitle
        val desc = recylerItemTab3Binding.newsDescription
        val publish = recylerItemTab3Binding.newsPublishAt
        val content = recylerItemTab3Binding.newConetnt
        val author = recylerItemTab3Binding.newsAuthor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecylerItemTab3Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(article[position].urlToImage).into(holder.titleImage)
        holder.title.text = article[position].title
        holder.author.text = article[position].author
        holder.desc.text = article[position].description
        holder.publish.text = article[position].publishedAt
        holder.content.text = article[position].content
    }

    override fun getItemCount(): Int {
        return article.size
    }
}