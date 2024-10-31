package com.example.myapplication.Adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.Model.viewData
import com.example.myapplication.R
import com.example.myapplication.databinding.ViewholderDsBinding

class ViewDSAdapter(private val items: List<viewData>) : RecyclerView.Adapter<ViewDSAdapter.MyViewHolder>() {

    private var selectedPosition = -1

    inner class MyViewHolder(private val binding: ViewholderDsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    notifyItemChanged(selectedPosition)
                    selectedPosition = position
                    notifyItemChanged(selectedPosition)
                }
            }
        }

        fun bind(item: viewData, isSelected: Boolean) {
            binding.titleTxt.text = item.title // Đảm bảo `titleTxt` tồn tại trong XML
            Glide.with(binding.root.context).load(item.picUrl).into(binding.pic)

            if (isSelected) {
                binding.mainLayout.setBackgroundResource(R.drawable.grey_bg)
                ImageViewCompat.setImageTintList(binding.pic, ColorStateList.valueOf(ContextCompat.getColor(binding.root.context, R.color.white)))
                binding.titleTxt.visibility = View.VISIBLE
                binding.titleTxt.setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))
            } else {
                binding.mainLayout.setBackgroundResource(0)
                ImageViewCompat.setImageTintList(binding.pic, ColorStateList.valueOf(ContextCompat.getColor(binding.root.context, R.color.black)))
                binding.titleTxt.visibility = View.GONE
                binding.titleTxt.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ViewholderDsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position], position == selectedPosition)
    }

    override fun getItemCount(): Int = items.size
}
