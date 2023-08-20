package com.example.cinema_provider_app.main_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.cinema_provider_app.R


class BlankHomeFragment : Fragment() {
    private lateinit var imageView: ImageView
    private var imageResId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank_home, container, false)
        imageView = view.findViewById(R.id.blankImage)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("imageResId")?.let { imageResId ->
            changeImage(imageResId)
        }
    }

    fun changeImage(imageResId: Int) {
        imageView.setImageResource(imageResId)
    }

    companion object {
        @JvmStatic
        fun newInstance(imageResId: Int) = BlankHomeFragment().apply {
            arguments = Bundle().apply {
                putInt("imageResId", imageResId)
            }
        }
    }
}