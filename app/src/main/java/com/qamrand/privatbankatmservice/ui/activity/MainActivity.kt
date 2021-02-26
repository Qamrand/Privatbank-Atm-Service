package com.qamrand.privatbankatmservice.ui.activity

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.qamrand.privatbankatmservice.R
import com.qamrand.privatbankatmservice.ui.fragment.main.MainFragment
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    lateinit var fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fm = supportFragmentManager
        showMainFragment()
    }

    private fun showMainFragment() {
        val transaction: FragmentTransaction = fm.beginTransaction()
        transaction.replace(R.id.main_container, MainFragment())
        transaction.commit()
    }

    fun showFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = fm.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (fm.backStackEntryCount == 0) {
            Log.d("TAG_APP1", "if: ${fm.backStackEntryCount}" )
            AlertDialog.Builder(this)
                .setMessage("Do you want to quit the app?")
                .setCancelable(false)
                .setPositiveButton("No") { _, _  ->}
                .setNegativeButton("Yes") { _, _ ->
                    this.finishAndRemoveTask()
                }
                .create()
                .show()
        } else {
            Log.d("TAG_APP1", "else: ${fm.backStackEntryCount}" )
            super.onBackPressed()
        }
    }

}