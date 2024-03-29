package com.example.mainproject.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mainproject.R
import com.example.mainproject.adapter.SectionAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class CartFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var pager: ViewPager2
    private lateinit var adapter: SectionAdapter
    private var list = ArrayList<Fragment>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.new_tab_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inintView()
        setList()
        initPager()
        initTabLayout()
    }

    private fun inintView() {
        tabLayout = requireActivity().findViewById(R.id.tab_menu_new)
        pager = requireActivity().findViewById(R.id.view_pager_new)
    }


    private fun initTabLayout() {
        TabLayoutMediator(tabLayout, pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "ONE"
                    tab.setIcon(R.drawable.ic_heart)
                    tab.icon?.setTint(
                        ContextCompat.getColor(requireContext(),R.color.white)
                    )
                }
                1 -> {
                    tab.text = "TWO"
                    tab.setIcon(R.drawable.ic_phone)
                    tab.icon?.setTint(
                        ContextCompat.getColor(requireContext(),R.color.white)
                    )
                }
                2 -> {
                    tab.text = "THREE"
                    tab.setIcon(R.drawable.ic_person)
                    tab.icon?.setTint(
                        ContextCompat.getColor(requireContext(),R.color.white)
                    )
                }
            }
        }.attach()
    }

//    private fun initTabLayout() {
//        TabLayoutMediator(tabLayout, pager) { tab, position ->
//            when (position) {
//                0 -> {
//                    tab.text = "Apparel"
//                    tab.setIcon(R.drawable.ic_cart)
//                    tab.icon?.setTint(
//                        ContextCompat.getColor(requireContext(),R.color.apparel_color)
//                    )
//                }
//                1 -> {
//                    tab.text = "Beauty"
//                    tab.setIcon(R.drawable.ic_home)
//                    tab.icon?.setTint(
//                        ContextCompat.getColor(requireContext(),R.color.beauty_color)
//                    )
//                }
//                2 -> {
//                    tab.text = "Shoes"
//                    tab.setIcon(R.drawable.ic_more)
//                    tab.icon?.setTint(
//                        ContextCompat.getColor(requireContext(),R.color.shoes_color)
//                    )
//                }
//            }
//        }.attach()
//    }

    private fun initPager() {
        adapter = SectionAdapter(childFragmentManager, lifecycle, list)
        pager.adapter = adapter
    }

    private fun setList() {
        list.add(ApparelFragment())
        list.add(BeautyFragment())
        list.add(ShoesFragment())
    }
}