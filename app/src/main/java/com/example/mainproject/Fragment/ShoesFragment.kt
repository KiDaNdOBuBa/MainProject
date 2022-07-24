package com.example.mainproject.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listproject.ShoesAdapter
import com.example.mainproject.R


class ShoesFragment : Fragment() {

    private val list = ArrayList<ShoeClass>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ShoesAdapter

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
        adapter = ShoesAdapter(list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun setList() {
        list.add(
            ShoeClass(
                "https://www.nikesb.com/assets/uploads/product/nikesb_airzoom_url.jpg",
                "Nike",
                "7.50",
                "300$"
            )
        )
        list.add(
            ShoeClass(
                "https://assets.adidas.com/images/w_600,f_auto,q_auto/b005f131d9fa4b389d88adfe010c1363_9366/Krossovki_Handball_Spezial_seryj_GZ4761_01_standard.jpg",
                "Adidas",
                "7.50",
                "300$"
            )
        )
        list.add(
            ShoeClass(
                "https://m.media-amazon.com/images/I/419YDCW46hL.jpg",
                "Vellore",
                "7.50",
                "300$"
            )
        )
        list.add(
            ShoeClass(
                "https://images.lululemon.com/is/image/lululemon/Web_LW9EF1S_055218_0075",
                "Lululemon",
                "7.50",
                "300$"
            )
        )
        list.add(
            ShoeClass(
                "https://cloud.kujo.com/wr-styled-yardshoe-backlit-medium-blended-25d77e4f37-ea5bbd79bc.jpeg",
                "Kujo Yard",
                "7.50",
                "300$"
            )
        )
        list.add(
            ShoeClass(
                "https://cloud.kujo.com/wr-styled-yardshoe-backlit-medium-blended-25d77e4f37-ea5bbd79bc.jpeg",
                "Kujo Yard",
                "7.50",
                "300$"
            )
        )
        list.add(
            ShoeClass(
                "https://cloud.kujo.com/wr-styled-yardshoe-backlit-medium-blended-25d77e4f37-ea5bbd79bc.jpeg",
                "Kujo Yard",
                "7.50",
                "300$"
            )
        )
        list.add(
            ShoeClass(
                "https://cloud.kujo.com/wr-styled-yardshoe-backlit-medium-blended-25d77e4f37-ea5bbd79bc.jpeg",
                "Kujo Yard",
                "7.50",
                "300$"
            )
        )
        list.add(
            ShoeClass(
                "https://cloud.kujo.com/wr-styled-yardshoe-backlit-medium-blended-25d77e4f37-ea5bbd79bc.jpeg",
                "Kujo Yard",
                "7.50",
                "300$"
            )
        )
        list.add(
            ShoeClass(
                "https://cloud.kujo.com/wr-styled-yardshoe-backlit-medium-blended-25d77e4f37-ea5bbd79bc.jpeg",
                "Kujo Yard",
                "7.50",
                "300$"
            )
        )
        list.add(
            ShoeClass(
                "https://cloud.kujo.com/wr-styled-yardshoe-backlit-medium-blended-25d77e4f37-ea5bbd79bc.jpeg",
                "Kujo Yard",
                "7.50",
                "300$"
            )
        )
    }

}