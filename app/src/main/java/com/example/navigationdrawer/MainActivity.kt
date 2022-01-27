package com.example.navigationdrawer

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.navigationdrawer.fragment.*


class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().add(R.id.framLayout, homeFragment).commit()

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }


        initViews()
    }

    fun initViews() {
        val layout_home = findViewById<LinearLayout>(R.id.layout_home)
        layout_home.setOnClickListener { replaceFragment(HomeFragment()) }

        val layout_photos = findViewById<LinearLayout>(R.id.layout_photos)
        layout_photos.setOnClickListener { replaceFragment(PhotosFragment()) }

        val layout_movies = findViewById<LinearLayout>(R.id.layout_movies)
        layout_movies.setOnClickListener { replaceFragment(MoviesFragment()) }

        val layout_notifications = findViewById<LinearLayout>(R.id.layout_notifications)
        layout_notifications.setOnClickListener { replaceFragment(NotificationsFragment()) }

        val layout_settings = findViewById<LinearLayout>(R.id.layout_settings)
        layout_settings.setOnClickListener { replaceFragment(SettingsFragment()) }
    }

    private fun replaceFragment(fragment: Fragment) {
        val backStateName = fragment.javaClass.name
        val manager = supportFragmentManager
        val fragmentPopupCallback = manager.popBackStackImmediate(backStateName, 0)
        if (!fragmentPopupCallback) {
            val ft = manager.beginTransaction()
            ft.replace(R.id.framLayout, fragment)
            ft.addToBackStack(backStateName)
            ft.commit()
        }
        count++
    }

    override fun onBackPressed() {
        if (count == 0) finish()
        val ft = supportFragmentManager
        for (i in 1..count) {
            ft.popBackStack()
        }
        count = 0
    }
}

