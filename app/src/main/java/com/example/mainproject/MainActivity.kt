package com.example.mainproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        goToMainFragment()
    }

    private fun setMenuListener() {
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_nav_bt -> {
                    true
                }
                R.id.search_nav_bt -> {
                    true
                }
                R.id.cart_nav_bt -> {
                    true
                }
                R.id.profile_nav_bt -> {
                    true
                }
                R.id.more_nav_bt -> {
                    true
                }else -> {
                    true
                }
            }
        }
    }

    private fun goToMainFragment() {
        supportFragmentManager.beginTransaction().add(R.id.container, MainFragment(), "").commit()
    }

    private fun initView() {
        bottomNav = findViewById(R.id.bottom_nav)
    }
}