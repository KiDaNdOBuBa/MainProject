package com.example.mainproject

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.SyncStateContract
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.dynamicfeatures.Constants
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.example.mainproject.Constant.Companion.BOOL_LIST_KEY
import com.example.mainproject.Constant.Companion.SETTING_IS_ENABLE
import com.example.mainproject.Constant.Companion.getSharedForSettings
import com.example.mainproject.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var sideBar: NavigationView
    private lateinit var shared: SharedPreferences
    private var settingSwitchBoolList = mutableListOf<Boolean>()
    private var isAdded: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(binding.root)
        setSettingShared()
        addSettingBoolLIst(isAdded)
        initView()

        bottomNav.setupWithNavController(navController)
        sideBar.setupWithNavController(navController)
        binding.apply {
            appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun addSettingBoolLIst(isAdded: Boolean) {
        if (isAdded) {
            settingSwitchBoolList.add(true)
            settingSwitchBoolList.add(false)
            settingSwitchBoolList.add(true)
            settingSwitchBoolList.add(true)
            val gson = Gson()
            val json = gson.toJson(settingSwitchBoolList)
            shared.edit()
                .putString(SETTING_IS_ENABLE, json)
                .apply()
        }
        setIsAdded()
    }

    private fun setSettingShared() {
        shared = getSharedForSettings(this)
        isAdded = shared.getBoolean(BOOL_LIST_KEY, true)
    }

    private fun setIsAdded() {
        if (isAdded)
            shared.edit()
                .putBoolean(BOOL_LIST_KEY, false)
                .apply()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun initView() {
        bottomNav = findViewById(R.id.bottom_nav)
        sideBar = findViewById(R.id.nav_drawer_view)
        navController = findNavController(R.id.container)
    }
}