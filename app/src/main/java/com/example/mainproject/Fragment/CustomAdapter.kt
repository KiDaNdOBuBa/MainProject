package com.example.listproject

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.bumptech.glide.Glide
import com.example.mainproject.Fragment.ShoeClass
import com.example.mainproject.R


class CustomAdapter(
    context: Context,
    @LayoutRes var resource: Int,
    var list: List<ShoeClass>
) : ArrayAdapter<ShoeClass>(context, resource, list) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)

        val rowView: View = inflater.inflate(resource, null, true)

        val image = rowView.findViewById<AppCompatImageView>(R.id.image)
        val shoeName = rowView.findViewById<AppCompatTextView>(R.id.shoe_name)
        val idkWhat = rowView.findViewById<AppCompatTextView>(R.id.idk_what)
        val shoePrice = rowView.findViewById<AppCompatTextView>(R.id.shoe_price)

        Glide.with(context).load(list[position].imageUrl).into(image)
        shoeName.text = list[position].name
        idkWhat.text = list[position].idkWhat
        shoePrice.text = list[position].price

        return rowView
    }
}
