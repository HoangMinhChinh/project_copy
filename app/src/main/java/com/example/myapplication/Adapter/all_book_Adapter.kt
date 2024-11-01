package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ViewholderAllBookBinding

class all_book_Adapter(val items:MutableList<>):RecyclerView.Adapter<all_book_Adapter.ViewHolder>{

    class ViewHolder(val binding: ViewholderAllBookBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType:
    ): all_book_Adapter.ViewHolder {
        val binding=ViewholderAllBookBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: all_book_Adapter.ViewHolder, position: Int) {
        val item=items[position]

        with(holder.binding){
            titleTxt.text=item.title
            priceTxt.text="$${item.price}"
            ratingTxt.text=item.rating.toString()

            Glide.with(holder.itemView.context)
                .load(item.picUrl[0])
                .into(pic)
        }
    }

    override fun getItemCount(): Int = items.size
}