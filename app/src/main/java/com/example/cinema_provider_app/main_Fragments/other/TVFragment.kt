package com.example.cinema_provider_app.main_Fragments.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cinema_provider_app.R

class TVFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_t_v_, container, false)
    }
    /**
    returns an instance of the class
     **/

    companion object {
        @JvmStatic
        fun newInstance() = TVFragment()

    }
}