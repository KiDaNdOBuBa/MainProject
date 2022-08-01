package com.example.mainproject.adapter

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mainproject.Constant.Companion.CAMERA_STATE
import com.example.mainproject.Constant.Companion.CONTACTS_STATE
import com.example.mainproject.Constant.Companion.LOCATION_STATE
import com.example.mainproject.Constant.Companion.PREF_NAME
import com.example.mainproject.Constant.Companion.SETTING_IS_ENABLE
import com.example.mainproject.Constant.Companion.STATE
import com.example.mainproject.Constant.Companion.STORAGE_STATE
import com.example.mainproject.Constant.Companion.getSharedForSettings
import com.example.mainproject.R
import com.example.mainproject.model.SettingModel
import com.google.gson.Gson

class SettingsAdapter(
    var itemList: ArrayList<SettingModel>
) : RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder>() {
    var onItemClickListener: ShoesAdapter.OnItemClickListener? = null
    private lateinit var boolList: Array<Boolean>
    private lateinit var shared: SharedPreferences
    private val gson = Gson()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_settings, parent, false)
        return SettingsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        val setting = itemList[position]

        holder.apply {
            val shared = getSharedForSettings(itemView.context)
            boolList =
                gson.fromJson(shared.getString(SETTING_IS_ENABLE, ""), Array<Boolean>::class.java)
            settingName.text = setting.settingName
            switch.isChecked = setting.switch
            Glide.with(itemView.context).load(setting.image).into(image)
            switch.setOnCheckedChangeListener { _, _ ->
                boolList[position] = switch.isChecked
                shared.edit()
                    .putString(SETTING_IS_ENABLE, gson.toJson(boolList))
                    .apply()
            }
        }
    }


    override fun getItemCount(): Int = itemList.size

    inner class SettingsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: AppCompatImageView
        var settingName: AppCompatTextView
        var switch: SwitchCompat

        init {
            image = itemView.findViewById(R.id.ic_setting)
            settingName = itemView.findViewById(R.id.tv_setting_name)
            switch = itemView.findViewById(R.id.sw_setting)
        }
    }
}
