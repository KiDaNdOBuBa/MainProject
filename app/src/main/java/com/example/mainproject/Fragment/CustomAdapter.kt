package com.example.listproject

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatTextView
import com.example.mainproject.R


class CustomAdapter(
    context: Context,
    @LayoutRes var resource: Int,
    var list: List<String>
) : ArrayAdapter<String>(context, resource, list) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)

        val rowView: View = inflater.inflate(resource, null, true)

        val name = rowView.findViewById<AppCompatTextView>(R.id.name)

        name.text = list[position]

        return rowView
    }
}
