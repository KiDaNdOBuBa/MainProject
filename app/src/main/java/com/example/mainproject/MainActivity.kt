package com.example.mainproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.blue
import androidx.fragment.app.Fragment
import com.example.mainproject.Fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setMenuListener()
    }

    private fun setMenuListener() {
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_nav_bt -> {
                    goToSelectedFragment(HomeFragment())
                    true
                }
                R.id.search_nav_bt -> {
                    goToSelectedFragment(SearchFragment())
                    true
                }
                R.id.cart_nav_bt -> {
                    goToSelectedFragment(CartFragment())
                    true
                }
                R.id.profile_nav_bt -> {
                    goToSelectedFragment(ProfileFragment())
                    true
                }
                R.id.more_nav_bt -> {
                    goToSelectedFragment(MoreFragment())
                    true
                }
                else -> {
                    true
                }
            }
        }
    }


    private fun goToSelectedFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    private fun initView() {
        bottomNav = findViewById(R.id.bottom_nav)
    }
}