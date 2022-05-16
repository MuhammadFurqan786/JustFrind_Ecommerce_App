package com.justfriends.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.justfriends.R
import com.justfriends.databinding.ActivityMainBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.preference.PreferenceHelper
import com.justfriends.utils.Global

class MainActivity : AppCompatActivity(), IMainActivity {

    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null
    private lateinit var helper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        helper = PreferenceHelper.getPref(this)
        //  binding.bottomNavBar.background = null
        binding.bottomNavBar.menu.getItem(2).isEnabled = false
        setupNavigation()
        setUpListener()
    }


    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNavBar, navController!!)
        navController!!.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.nav_home_fragment -> showBottomBar(true)
                R.id.nav_chat_fragment -> showBottomBar(true)
                R.id.nav_my_listings_fragment -> showBottomBar(true)
                R.id.nav_my_account_fragment -> showBottomBar(true)
                else -> showBottomBar(false)
            }
        }
    }

    private fun setUpListener() {
        /* if (navController?.currentDestination?.id == R.id.nav_my_listings_fragment) {
             navController?.navigate(R.id.nav_home_fragment)
         }*/

        binding.fabAdd.setOnClickListener {
            navController?.navigate(R.id.nav_post_ad_fragment)
        }
    }

    private fun showBottomBar(isShowing: Boolean) {
        binding.bar.visibility = if (isShowing) View.VISIBLE else View.GONE
        binding.fabAdd.visibility = if (isShowing) View.VISIBLE else View.GONE
    }

    override fun getContext(): Context {
        return this
    }

    override fun hideKeyBoard() {
        Global.hideKeyboard(this, binding.root)

    }

    override fun showError(message: String) {
        Global.showMessage(binding.root, message)

    }

    override fun showLongError(message: String) {
        Global.showMessage(binding.root, message, Snackbar.LENGTH_LONG)

    }

    override fun showAlter(message: String) {
        MaterialAlertDialogBuilder(this)
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok)){dialog,which->
                dialog.dismiss()
            }.show()
    }


    override fun showProgress(isShown: Boolean) {
        binding.progressBar.visibility = if (isShown) View.VISIBLE else View.GONE
    }


    override fun showMessage(message: String) {
        val snackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT)
        snackbar.show()

    }

    override fun showAnimation(isShown: Boolean) {
        binding.lottieAnimView.visibility = if (isShown) View.VISIBLE else View.GONE
    }

    override fun getPreference(): PreferenceHelper {
        return helper
    }

    override fun hideSoftInput() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
    }

    override fun onBackPressed() {
        if (navController?.currentDestination?.id == R.id.nav_home_fragment) {
            finish()
        } else {
            super.onBackPressed()
        }
    }


}