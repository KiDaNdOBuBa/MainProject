package com.example.mainproject.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.listproject.CustomAdapter
import com.example.mainproject.R


class ShoesFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var customAdapter: CustomAdapter
    private var userList = ArrayList<ShoeClass>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shoes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
    }


    private fun initList(){

        userList = ArrayList()
        userList.add(ShoeClass(name ="Kerambit 800l k200 vllksmja", idkWhat ="15", price = "250"))
        userList.add(ShoeClass(name ="Kerambit 800l k200 vllksmja", idkWhat ="15", price = "250"))
        userList.add(ShoeClass(name ="Kerambit 800l k200 vllksmja", idkWhat ="15", price = "250"))
        userList.add(ShoeClass(name ="Kerambit 800l k200 vllksmja", idkWhat ="15", price = "250"))
        userList.add(ShoeClass(name ="Kerambit 800l k200 vllksmja", idkWhat ="15", price = "250"))

        customAdapter = CustomAdapter(
            requireContext(),
            R.layout.item_shoes_list,
            userList
        )

        listView = requireView().findViewById(R.id.lv_shoe)
        listView.adapter = customAdapter

    }
}