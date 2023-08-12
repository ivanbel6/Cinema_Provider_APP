package com.example.cinema_provider_app.main_Fragments.Home_Fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.cinema_provider_app.R
import com.example.cinema_provider_app.main_Fragments.Home_Fragment.Adapters.CustomRecycleAdapter
import com.example.cinema_provider_app.main_Fragments.Home_Fragment.Adapters.FirstTypeAdapter
import com.example.cinema_provider_app.main_Fragments.Home_Fragment.Adapters.SliderAdapter
import com.example.cinema_provider_app.main_Fragments.Home_Fragment.Data_Classes.CustomDataClass
import com.example.cinema_provider_app.main_Fragments.Home_Fragment.Data_Classes.FirstDataType
import com.example.cinema_provider_app.main_Fragments.Home_Fragment.Data_Classes.SlideItem


class HomeFragment : Fragment() {


    private val scrollHandler = Handler()
    private lateinit var scrollRunnable: Runnable
    private lateinit var sliderRecyclerView: RecyclerView

    private lateinit var firstTypeRecyclerView: RecyclerView
    private lateinit var secondTypeRecyclerView: RecyclerView
    private lateinit var customRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //FIRST SLIDER ON THE TOP
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        sliderRecyclerView = view.findViewById(R.id.sliderRecyclerView)
        sliderRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(sliderRecyclerView)

        val slideItems = listOf(
            SlideItem(" Slide 1", "Description 1", R.drawable.slider_1_3),
            SlideItem(" Slide 2", "Description 2", R.drawable.slider_1_mermid_jpg),
            SlideItem(" Slide 3", "Description 3", R.drawable.slider_1_4_final),
            SlideItem(" Slide 4", "Description 4", R.drawable.slider_1_1_final),
            SlideItem(" Slide 4", "Description 4", R.drawable.slider_1_fflash)
        )
        val sliderAdapter = SliderAdapter(slideItems)
        sliderRecyclerView.adapter = sliderAdapter
        scrollRunnable = Runnable {
            val layoutManager = sliderRecyclerView.layoutManager as LinearLayoutManager
            val currentPosition = layoutManager.findFirstVisibleItemPosition()
            val nextPosition =
                if (currentPosition < sliderAdapter.itemCount - 1) currentPosition + 1 else 0
            sliderRecyclerView.smoothScrollToPosition(nextPosition)
            scrollHandler.postDelayed(scrollRunnable, AUTO_SCROLL_DELAY)
        }

        scrollHandler.postDelayed(scrollRunnable, AUTO_SCROLL_DELAY)
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //SECOND TYPE SLIDER's
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        firstTypeRecyclerView = view.findViewById(R.id.first_type_recycleView)
        val secondSlideItem = listOf<FirstDataType>(
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin)
        )
        firstTypeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val firstTypeAdapter = FirstTypeAdapter(secondSlideItem)
        firstTypeRecyclerView.adapter = firstTypeAdapter
        val snappHelper: SnapHelper = LinearSnapHelper()
        snappHelper.attachToRecyclerView(firstTypeRecyclerView)




        secondTypeRecyclerView = view.findViewById(R.id.first_type_recycleView_2)
        val secondTypeSlideItem = listOf<FirstDataType>(
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin),
            FirstDataType(R.drawable._54282_admin)
        )
        secondTypeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val secondTypeAdapter = FirstTypeAdapter(secondTypeSlideItem)
        secondTypeRecyclerView.adapter = secondTypeAdapter
        val snappHelperr: SnapHelper = LinearSnapHelper()
        snappHelperr.attachToRecyclerView(secondTypeRecyclerView)

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //CUSTOM TYPE SLIDER's
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        customRecyclerView = view.findViewById(R.id.CustomRecycleView)
        customRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val customList = listOf(
            CustomDataClass(
                R.drawable.bg_game,
                "Игра престолов",
                "Действие сериала происходит на вымышленных континентах Вестерос и Эссос и повествует о борьбе за власть между благородными семьями, борющимися за контроль над Железным троном Семи Королевств.",
                "8.9",
                "Фентези , Романтика , Триллер"
            ),


            )
        val customAdapter = CustomRecycleAdapter(customList, this)
        customRecyclerView.adapter = customAdapter
        val customSnapHelper: SnapHelper = PagerSnapHelper()
        customSnapHelper.attachToRecyclerView(customRecyclerView)


    }

    override fun onDestroy() {
        scrollHandler.removeCallbacks(scrollRunnable)
        super.onDestroy()
    }

    fun placeHolder(key: String) {
        if (key == "icon1") {
            Toast.makeText(activity, key, Toast.LENGTH_SHORT).show();
        }
        if (key == "icon2") {
            Toast.makeText(activity, key, Toast.LENGTH_SHORT).show();
        }

    }


    companion object {
        private const val AUTO_SCROLL_DELAY = 10000L // Задержка в миллисекундах (4 секунды)

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
