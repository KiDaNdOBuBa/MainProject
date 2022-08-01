package com.example.mainproject.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mainproject.R
import com.example.mainproject.databinding.FragmentShoeItemBinding


class ShoeItemFragment : Fragment() {

    private lateinit var binding: FragmentShoeItemBinding
    private val args: ShoeItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shoe_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShoeItemBinding.bind(view)

        Glide.with(requireContext()).load(args.imageUrl).centerCrop().into(binding.ivShoe)
        binding.shoeTitle.text = args.title
        binding.shoeInfo.text = args.shoeTitle
        binding.price.text = args.price
    }
}