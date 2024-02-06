package com.example.cinema_provider_app.main_Fragments


import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import com.example.cinema_provider_app.R


class BlankHomeFragment : Fragment() {

    private var imageResId: Int = 0
    private var squareTitle: ArrayList<String> = arrayListOf()
    private var Descriprion: String = ""
    private var Status: String = ""

    private val channelId = "example_channel"
    private val notificationId = 100


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageResId = it.getInt(IMG)
            squareTitle = it.getStringArrayList(TITLE) as ArrayList<String>
            Descriprion = it.getString(DESCRIPTION).toString()
            Status = it.getString(STATUS).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank_home, container, false)
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView = view.findViewById<ImageView>(R.id.blankImage)
        imageView.setImageResource(imageResId)

        val DescriprionTextView = view.findViewById<TextView>(R.id.descriptionn)
        DescriprionTextView.text = Descriprion


        val StatusTextView = view.findViewById<TextView>(R.id.status)
        StatusTextView.text = Status

        val squaresLayout: LinearLayout = view.findViewById(R.id.squaresLayout)

        squareTitle.forEach {
            createSquare(squaresLayout, it.toString())
        }
        val button = view.findViewById<Button>(R.id.btn)


        button.setOnClickListener {
            Toast.makeText(getActivity(),"Text!",Toast.LENGTH_SHORT).show();
        }

    }




    private fun createSquare(
        parentLayout: LinearLayout,
        text: String,
        textColor: Int = resources.getColor(R.color.silver_transparent),
        cornerRadius: Float = 80f
    ) {
        val square = LinearLayout(requireContext())
        val layoutParams = LinearLayout.LayoutParams(400, 150)
        layoutParams.weight = 1f
        square.layoutParams = layoutParams
        val drawable = GradientDrawable()
        drawable.cornerRadius = cornerRadius
        drawable.setColor(textColor) // Set color with the given textColor parameter
        square.background = drawable

        val textView = TextView(requireContext())
        textView.text = text
        textView.setTextColor(Color.WHITE) // Set text color to white
        textView.gravity = Gravity.CENTER
        square.gravity = Gravity.CENTER
        textView.setPadding(20, 20, 20, 20) // Set padding within the text

        square.addView(textView)
        parentLayout.addView(square)

        // Add margin to the square
        val margins = layoutParams as ViewGroup.MarginLayoutParams
        margins.setMargins(0, 0, 20, 0) // Set bottom margin to 20 pixels

    }


    companion object {
        private const val IMG = "IMG"
        private const val TITLE = "TITLE"
        private const val DESCRIPTION = "DESCRIPTION"
        private const val STATUS = "STATUS"

        fun newInstance(
            imageResId: Int,
            squareTitleList: ArrayList<String>,
            Status: String,
            Descriprion: String
        ): BlankHomeFragment {
            val fragment = BlankHomeFragment()
            val args = Bundle()
            args.putInt(IMG, imageResId)
            args.putStringArrayList(TITLE, squareTitleList)
            args.putString(STATUS, Status)
            args.putString(DESCRIPTION, Descriprion)
            fragment.arguments = args
            return fragment
        }
    }
}