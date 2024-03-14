package com.example.mytest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mytest.databinding.SingleRowItemBinding

class ImageAdapter(private val imageList: MutableList<ImageResponseItem> = mutableListOf()) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

   inner class ImageViewHolder(val singleRowItemBinding: SingleRowItemBinding) :
        RecyclerView.ViewHolder(singleRowItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.single_row_item,
            parent,false))
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.singleRowItemBinding.images = imageList[position]
    }
}