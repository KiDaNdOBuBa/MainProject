package com.example.mainproject.Fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mainproject.Constant.Companion.SETTING_IS_ENABLE
import com.example.mainproject.Constant.Companion.getSharedForSettings
import com.example.mainproject.R
import com.example.mainproject.adapter.SettingsAdapter
import com.example.mainproject.databinding.FragmentSettingsBinding
import com.example.mainproject.model.SettingModel
import com.google.gson.Gson

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private val list = ArrayList<SettingModel>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var settingSwitchBoolList: Array<Boolean>
    private lateinit var settingsAdapter: SettingsAdapter
    private lateinit var shared: SharedPreferences
    private lateinit var binding: FragmentSettingsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        binding = FragmentSettingsBinding.bind(view)
        setSHaredSetting()
        getSettingBoolList()
        setSettingItems()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun getSettingBoolList() {
        val gson = Gson()
        settingSwitchBoolList = gson.fromJson(
            shared.getString(SETTING_IS_ENABLE, ""),
            Array<Boolean>::class.java
        )
    }


    private fun setSHaredSetting() {
        shared = getSharedForSettings(requireContext())
    }

    private fun setSettingItems() {
        list.add(
            SettingModel(
                R.drawable.ic_camera,
                getString(R.string.Camera_title),
                settingSwitchBoolList[0]
            )
        )
        list.add(
            SettingModel(
                R.drawable.ic_contact,
                getString(R.string.Contacts_title),
                settingSwitchBoolList[1]
            )
        )
        list.add(
            SettingModel(
                R.drawable.ic_location,
                getString(R.string.Location_title),
                settingSwitchBoolList[2]
            )
        )
        list.add(
            SettingModel(
                R.drawable.ic_storage,
                getString(R.string.Storage_title),
                settingSwitchBoolList[3]
            )
        )
    }

    private fun initRecyclerView() {
        recyclerView = requireView().findViewById(R.id.recycler_view)
        settingsAdapter = SettingsAdapter(list)
        recyclerView.adapter = settingsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }
}