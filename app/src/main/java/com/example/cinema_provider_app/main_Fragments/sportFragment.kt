package com.example.cinema_provider_app.main_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cinema_provider_app.R

class sportFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sport, container, false)
    }
    /**
    returns an instance of the class
     **/

    companion object {
        @JvmStatic
        fun newInstance() = sportFragment()

    }
}