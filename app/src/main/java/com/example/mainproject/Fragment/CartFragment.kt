package com.example.mainproject.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mainproject.R
import com.example.mainproject.SectionAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inintView()
        setList()
        initPager()
        initTabLayout()
    }

    private fun inintView() {
        tabLayout = requireActivity().findViewById(R.id.tab_menu)
        pager = requireActivity().findViewById(R.id.view_pager)
    }

    private fun initTabLayout() {
        TabLayoutMediator(tabLayout, pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Apparel"
                    tab.setIcon(R.drawable.ic_cart)
                    tab.icon?.setTint(
                        ContextCompat.getColor(requireContext(),R.color.apparel_color)
                    )
                }
                1 -> {
                    tab.text = "Beauty"
                    tab.setIcon(R.drawable.ic_home)
                    tab.icon?.setTint(
                        ContextCompat.getColor(requireContext(),R.color.beauty_color)
                    )
                }
                2 -> {
                    tab.text = "Shoes"
                    tab.setIcon(R.drawable.ic_more)
                    tab.icon?.setTint(
                        ContextCompat.getColor(requireContext(),R.color.shoes_color)
                    )
                }
            }
        }.attach()
    }

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