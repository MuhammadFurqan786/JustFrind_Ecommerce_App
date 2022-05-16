package com.justfriends.interfaces

import android.content.Context
import com.justfriends.preference.PreferenceHelper

interface IMainActivity {

    fun getContext(): Context
    fun hideKeyBoard()
    fun showError(message: String)
    fun showLongError(message: String)
    fun showAlter(message: String)
    fun showProgress(isShown: Boolean)
    fun showMessage(message: String)
    fun showAnimation(isShown: Boolean)
    fun getPreference() : PreferenceHelper
    fun hideSoftInput()
}