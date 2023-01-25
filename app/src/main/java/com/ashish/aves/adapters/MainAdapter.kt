package com.ashish.aves

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ashish.aves.databinding.AdapterImageBinding
import com.ashish.aves.listners.ClickListener
import com.ashish.aves.model.ImageResponse
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var list = mutableListOf<ImageResponse>()
    private var clickListener: ClickListener<ImageResponse>? = null
    private var imageClickListener: ClickListener<ImageResponse>? = null
    fun setImgList(data: List<ImageResponse>) {
        this.list = data.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterImageBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val details = list[position]
        holder.binding.name.text = details.user?.name
        holder.binding.description.text = details.description
        Glide.with(holder.itemView.context).load(details.urls?.full).centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.binding.imageView)
        Glide.with(holder.itemView.context).load(details.user?.profileImage?.medium).into(holder.binding.displayPic)
        holder.binding.personLy.setOnClickListener { v -> clickListener!!.onClick(v, details, position) }
        holder.binding.imageView.setOnClickListener { v -> imageClickListener!!.onClick(v, details, position) }


    }
    fun getData() = list
    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnItemClickListener(clickListener: ClickListener<ImageResponse>) {
        this.clickListener = clickListener
    }
    fun setOnImageItemClickListener(clickListener: ClickListener<ImageResponse>) {
        this.imageClickListener = clickListener
    }
}

class MainViewHolder(val binding: AdapterImageBinding) : RecyclerView.ViewHolder(binding.root) {

}
