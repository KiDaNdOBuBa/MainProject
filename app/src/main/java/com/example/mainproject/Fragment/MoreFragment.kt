package com.example.mainproject.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.listproject.CustomAdapter
import com.example.mainproject.R
import com.example.mainproject.databinding.ActivityMainBinding
import com.example.mainproject.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {
    private lateinit var binding: FragmentMoreBinding
    private lateinit var arrayAdapter: ArrayAdapter<String>
    private var nameList = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_more, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMoreBinding.bind(view)
        initFun()
        binding.apply {
            lvString.adapter = arrayAdapter
        }
    }

    private fun initFun(){
        arrayAdapter = CustomAdapter(
            requireContext(),
            R.layout.item_username,
            nameList
        )
        nameList.add("Bub")
        nameList.add("Ero")
        nameList.add("Noy")
        nameList.add("Saq")
        nameList.add("Gev")
    }
}