package com.example.mainproject.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mainproject.R
import com.example.mainproject.adapter.ShoesAdapter
import com.example.mainproject.model.ShoeModel


class ShoesFragment : Fragment(), ShoesAdapter.OnItemClickListener {

    private val list = ArrayList<ShoeModel>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var shoesAdapter: ShoesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shoes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setList()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView = requireView().findViewById(R.id.rv_shoe)
        shoesAdapter = ShoesAdapter(list)
        shoesAdapter.setListener(this)
        recyclerView.adapter = shoesAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onItemClick(shoes: ShoeModel) {
        passShoeItemFragment(shoes.imageUrl, shoes.name, shoes.price, shoes.name)
    }

    private fun passShoeItemFragment(
        imageUrl: String,
        title: String,
        price: String,
        shoeInfo: String
    ) {
        val direction = ShoesFragmentDirections.actionShoesFragmentToShoeItemFragment(
            imageUrl, title, price, shoeInfo
        )
        findNavController().navigate(direction)
    }

    private fun setList() {
        list.add(
            ShoeModel(
                "https://www.nikesb.com/assets/uploads/product/nikesb_airzoom_url.jpg",
                "Nike",
                "7.50",
                "300$",
                type = 1
            )
        )
        list.add(
            ShoeModel(
                "https://assets.adidas.com/images/w_600,f_auto,q_auto/b005f131d9fa4b389d88adfe010c1363_9366/Krossovki_Handball_Spezial_seryj_GZ4761_01_standard.jpg",
                "Adidas",
                "7.50",
                "300$",
                type = 0
            )
        )
        list.add(
            ShoeModel(
                "https://m.media-amazon.com/images/I/419YDCW46hL.jpg",
                "Vellore",
                "7.50",
                "300$",
                type = 0
            )
        )
        list.add(
            ShoeModel(
                "https://images.lululemon.com/is/image/lululemon/Web_LW9EF1S_055218_0075",
                "Lululemon",
                "7.50",
                "300$",
                type = 1
            )
        )
        list.add(
            ShoeModel(
                "https://cloud.kujo.com/wr-styled-yardshoe-backlit-medium-blended-25d77e4f37-ea5bbd79bc.jpeg",
                "Kujo Yard",
                "7.50",
                "300$",
                type = 1
            )
        )
        list.add(
            ShoeModel(
                "https://cloud.kujo.com/wr-styled-yardshoe-backlit-medium-blended-25d77e4f37-ea5bbd79bc.jpeg",
                "Kujo Yard",
                "7.50",
                "300$",
                type = 0
            )
        )
        list.add(
            ShoeModel(
                "https://cloud.kujo.com/wr-styled-yardshoe-backlit-medium-blended-25d77e4f37-ea5bbd79bc.jpeg",
                "Kujo Yard",
                "7.50",
                "300$",
                type = 1
            )
        )
        list.add(
            ShoeModel(
                "https://cloud.kujo.com/wr-styled-yardshoe-backlit-medium-blended-25d77e4f37-ea5bbd79bc.jpeg",
                "Kujo Yard",
                "7.50",
                "300$",
                type = 1
            )
        )
        list.add(
            ShoeModel(
                "https://cloud.kujo.com/wr-styled-yardshoe-backlit-medium-blended-25d77e4f37-ea5bbd79bc.jpeg",
                "Kujo Yard",
                "7.50",
                "300$",
                type = 0
            )
        )
        list.add(
            ShoeModel(
                "https://cloud.kujo.com/wr-styled-yardshoe-backlit-medium-blended-25d77e4f37-ea5bbd79bc.jpeg",
                "Kujo Yard",
                "7.50",
                "300$",
                type = 0
            )
        )
        list.add(
            ShoeModel(
                "https://cloud.kujo.com/wr-styled-yardshoe-backlit-medium-blended-25d77e4f37-ea5bbd79bc.jpeg",
                "Kujo Yard",
                "7.50",
                "300$",
                type = 1
            )
        )
    }
}