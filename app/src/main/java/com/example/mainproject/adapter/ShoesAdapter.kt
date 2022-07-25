package com.example.mainproject.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mainproject.model.ShoeClass
import com.example.mainproject.R

class ShoesAdapter(
    var itemList: ArrayList<ShoeClass>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var selectedPosition = -1
    var onItemClickListener: OnItemClickListener? = null

    override fun getItemViewType(position: Int): Int {
        return itemList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {
            val itemView =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_shoe, parent, false)
            ShoesViewHolder(itemView)
        } else {
            val itemView =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_shoe_reverse, parent, false)
            ShoesReverseViewHolder(itemView)
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val shoe = itemList[position]
        holder.apply {
            if (selectedPosition == position) {
                itemView.setBackgroundColor(Color.RED)
            } else {
                itemView.setBackgroundColor(Color.WHITE)
            }
            when (this) {
                is ShoesViewHolder -> {
                    name.text = shoe.name
                    price.text = shoe.price
                    Glide.with(itemView.context).load(shoe.imageUrl).into(image)
                    itemView.setOnClickListener {
                        selectedPosition = position
                        notifyDataSetChanged()
                        onItemClickListener?.onItemClick(shoe)
                    }
                }
                is ShoesReverseViewHolder -> {
                    nameReverse.text = shoe.name
                    priceReverse.text = shoe.price
                    Glide.with(itemView.context).load(shoe.imageUrl).into(imageReverse)
                    itemView.setOnClickListener {
                        selectedPosition = position
                        notifyDataSetChanged()
                        onItemClickListener?.onItemClick(shoe)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = itemList.size

    fun setListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(shoes: ShoeClass)
    }

    inner class ShoesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: AppCompatTextView
        val price: AppCompatTextView
        val image: AppCompatImageView

        init {
            name = itemView.findViewById(R.id.shoe_name)
            price = itemView.findViewById(R.id.shoe_price)
            image = itemView.findViewById(R.id.image)
        }
    }

    inner class ShoesReverseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameReverse: AppCompatTextView
        val priceReverse: AppCompatTextView
        val imageReverse: AppCompatImageView

        init {
            nameReverse = itemView.findViewById(R.id.shoe_name_reverse)
            priceReverse = itemView.findViewById(R.id.shoe_price_reverse)
            imageReverse = itemView.findViewById(R.id.image_reverse)
        }
    }
}