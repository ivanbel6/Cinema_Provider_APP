package com.example.cinema_provider_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.cinema_provider_app.main_Fragments.ProfileFragment
import com.example.cinema_provider_app.main_Fragments.TVFragment
import com.example.cinema_provider_app.main_Fragments.sportFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("начнем")
        changeFragment(ProfileFragment.newInstance())

    }

    /**
    Function for quick change of fragments
     **/
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.Main_Space_To_Fragment, fragment)
            .commit()
    }


}

