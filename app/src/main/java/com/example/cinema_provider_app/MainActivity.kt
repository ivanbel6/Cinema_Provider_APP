package com.example.cinema_provider_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.cinema_provider_app.main_Fragments.Home_Fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("начнем")
        changeFragment(HomeFragment.newInstance())
        var bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.itemIconTintList = ContextCompat.getColorStateList(this, R.color.bottom_nav_item_color_selector)
        bottomNavigationView.itemTextColor = ContextCompat.getColorStateList(this, R.color.bottom_nav_item_color_selector)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.first_item -> {

                    Toast.makeText(this, "message", Toast.LENGTH_SHORT).show()

                    true
                }
                R.id.second_item -> {

                    true
                }
                R.id.third_item -> {
                    true
                }
                R.id.fourth_item -> {
                    true
                }
                else -> false
            }
        }

    }



    /**
    Function for quick change of fragments
     **/
    private fun changeFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().replace(R.id.Main_Space_To_Fragment, fragment)
            .commit()
    }


}

