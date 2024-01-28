package com.example.flexboxdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.flexbox.FlexboxLayoutManager

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    val mList = mutableListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
                return ImageViewHolder(view)
            }
            1 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image_2, parent, false)
                return ImageViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image_3, parent, false)
                return ImageViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemViewType(position: Int): Int {
        return mList[position].toInt()
    }

    fun addData(list: List<String>) {
        mList.addAll(list)
        notifyItemRangeInserted(0, itemCount)
    }

    class ImageViewHolder(view: View) : ViewHolder(view) {
        val parent = itemView.findViewById<CardView>(R.id.parent)
        val iv = itemView.findViewById<ImageView>(R.id.img)

        fun bind(position: Int) {
            val lp = parent.layoutParams
            if (lp is FlexboxLayoutManager.LayoutParams) {
                val flexboxLp = parent.layoutParams as FlexboxLayoutManager.LayoutParams
                flexboxLp.flexGrow = 1.0f
            }
        }
    }
}