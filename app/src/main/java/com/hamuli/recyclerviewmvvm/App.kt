package com.hamuli.recyclerviewmvvm

import android.app.Application
import androidx.preference.PreferenceManager
import com.hamuli.recyclerviewmvvm.util.ThemeHelper
import com.hamuli.recyclerviewmvvm.util.ThemeMode

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val sharePreference = PreferenceManager.getDefaultSharedPreferences(this)
        val themePreference = sharePreference.getString("themePref", ThemeMode.DEFAULT.name)

        ThemeHelper.applyTheme(ThemeMode.DARK.name)
    }
}