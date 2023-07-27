package com.example.cinema_provider_app.main_Fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema_provider_app.R
import com.example.cinema_provider_app.SlideItem
import com.example.cinema_provider_app.SliderAdapter

class HomeFragment : Fragment() {


    private val scrollHandler = Handler()
    private lateinit var scrollRunnable: Runnable
    private lateinit var sliderRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sliderRecyclerView = view.findViewById(R.id.sliderRecyclerView)
        sliderRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Добавьте следующий код:
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(sliderRecyclerView)

        val slideItems = listOf(
            SlideItem(" Slide 1", "Description 1", R.drawable._54282_admin),
        SlideItem(" Slide 2", "Description 2", R.drawable._54282_admin),
        SlideItem(" Slide 3", "Description 3", R.drawable._54282_admin),
        SlideItem(" Slide 4", "Description 4", R.drawable._54282_admin),
        SlideItem(" Slide 5", "Description 5", R.drawable._54282_admin)
        )
        val sliderAdapter = SliderAdapter(slideItems)
        sliderRecyclerView.adapter = sliderAdapter
        sliderRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = sliderAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                        val snapPosition = layoutManager.findFirstVisibleItemPosition()
                        val snapView = layoutManager.findViewByPosition(snapPosition)
                        val snapDistance = snapView?.left ?: 0
                        recyclerView.smoothScrollBy(snapDistance, 0)
                    }
                }
            })
        }
        scrollRunnable = Runnable {
            val layoutManager = sliderRecyclerView.layoutManager as LinearLayoutManager
            val currentPosition = layoutManager.findFirstVisibleItemPosition()
            val nextPosition = if (currentPosition < sliderAdapter.itemCount - 1) currentPosition + 1 else 0

            sliderRecyclerView.smoothScrollToPosition(nextPosition)
            scrollHandler.postDelayed(scrollRunnable, AUTO_SCROLL_DELAY)
        }

        scrollHandler.postDelayed(scrollRunnable, AUTO_SCROLL_DELAY)

    }

    override fun onDestroy() {
        scrollHandler.removeCallbacks(scrollRunnable)
        super.onDestroy()
    }
    companion object {
        private const val AUTO_SCROLL_DELAY = 10000L // Задержка в миллисекундах (4 секунды)
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
