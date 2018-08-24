package com.example.user.mykotlin.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceScreen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.user.mykotlin.R
import com.example.user.mykotlin.ui.activity.AboutActivity


class SettingFragment : PreferenceFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        //从xml文件中加载布局
        addPreferencesFromResource(R.xml.preferences)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onPreferenceTreeClick(preferenceScreen: PreferenceScreen?, preference: Preference?): Boolean {

        val key = preference?.key
        when(key){
            "about" ->  activity.startActivity(Intent(activity, AboutActivity::class.java))
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference)
    }
}