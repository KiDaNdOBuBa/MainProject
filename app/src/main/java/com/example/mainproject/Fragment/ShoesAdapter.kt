package com.example.listproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mainproject.Fragment.ShoeClass
import com.example.mainproject.R


class ShoesAdapter(var list: List<ShoeClass>) :
    RecyclerView.Adapter<ShoesAdapter.ShoesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_shoes_list, parent, false)
        return ShoesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoesViewHolder, position: Int) {
        val flower = list[position]
        var selectedItemPosition = -1
        holder.apply {
            name.text = flower.name
            price.text = flower.price
            idkWhat.text = flower.idkWhat
            Glide.with(itemView).load(flower.imageUrl).into(image)

        }
    }

    override fun getItemCount(): Int = list.size

    class ShoesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: AppCompatTextView
        val image: AppCompatImageView
        val idkWhat: AppCompatTextView
        val price: AppCompatTextView

        init {
            image = itemView.findViewById(R.id.image)
            name = itemView.findViewById(R.id.shoe_name)
            idkWhat = itemView.findViewById(R.id.idk_what)
            price = itemView.findViewById(R.id.shoe_price)
        }
    }

}
