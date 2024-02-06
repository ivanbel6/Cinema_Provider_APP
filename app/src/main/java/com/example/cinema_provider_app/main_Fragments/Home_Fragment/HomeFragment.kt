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
import com.example.cinema_provider_app.main_Fragments.BlankHomeFragment
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
    private lateinit var thirdTypeRecyclerView: RecyclerView
    private lateinit var fourthTypeRecyclerView: RecyclerView
    private lateinit var fifthTypeRecyclerView: RecyclerView
    private lateinit var sixthTypeRecyclerView: RecyclerView
    private lateinit var sevenTypeRecyclerView: RecyclerView
    private lateinit var eighthTypeRecyclerView: RecyclerView
    private lateinit var ninthTypeRecyclerView: RecyclerView
    private lateinit var tenthTypeRecyclerView: RecyclerView
    private lateinit var eleventhTypeRecyclerView: RecyclerView
    private lateinit var customRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
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

        val snapHelper1: SnapHelper = PagerSnapHelper()
        snapHelper1.attachToRecyclerView(sliderRecyclerView)

        val slideItems = listOf(
            SlideItem(
                "Оценки: Кинопоиск - 7.1 , IMDb - 6,3",
                "Жанр: комедия, боевик",
                R.drawable.slider_1_3
            ),
            SlideItem(
                "Оценки: Кинопоиск - 5.7 , IMDb - 7.2",
                "Жанр: фэнтези, мелодрама, мюзикл",
                R.drawable.slider_1_mermid_123123123123_jpg
            ),
            SlideItem("Рейтинг ожидания: 90%", "Жанр: боевик", R.drawable.slider_1_4_final),
            SlideItem(
                "Оценки: Кинопоиск - 6.6 , IMDb - 6.8",
                "Жанр: боевик, приключения",
                R.drawable.slider_1_indiona_fina_
            ),
            SlideItem(
                "Оценки: Кинопоиск - 6.5 , IMDb - 6.9",
                "Жанр: приключения, фантастика, боевик",
                R.drawable.slider_1_flash_final_3
            )
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
        val secondSlideItem = listOf(
            FirstDataType(R.drawable.d_11),
            FirstDataType(R.drawable.d_8),
            FirstDataType(R.drawable.d_3),
            FirstDataType(R.drawable.d_4),
            FirstDataType(R.drawable.d_5),
            FirstDataType(R.drawable.d_6),
            FirstDataType(R.drawable.d_7),
            FirstDataType(R.drawable.d_2),
            FirstDataType(R.drawable.d_9),
            FirstDataType(R.drawable.d_10),
            FirstDataType(R.drawable.__1)
        )
        firstTypeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val firstTypeAdapter = FirstTypeAdapter(secondSlideItem, this)
        firstTypeRecyclerView.adapter = firstTypeAdapter
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(firstTypeRecyclerView)




        secondTypeRecyclerView = view.findViewById(R.id.first_type_recycleView_2)
        val secondTypeSlideItem = listOf(
            FirstDataType(R.drawable.f_1),
            FirstDataType(R.drawable.f_2),
            FirstDataType(R.drawable.f_3),
            FirstDataType(R.drawable.f_4),
            FirstDataType(R.drawable.f_5),
            FirstDataType(R.drawable.f_6),
            FirstDataType(R.drawable.f_7),
            FirstDataType(R.drawable.f_8),
            FirstDataType(R.drawable.f_9),
            FirstDataType(R.drawable.f_10),
            FirstDataType(R.drawable.f_11)
        )
        secondTypeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val secondTypeAdapter = FirstTypeAdapter(secondTypeSlideItem, this)
        secondTypeRecyclerView.adapter = secondTypeAdapter
        val snapHelper2: SnapHelper = LinearSnapHelper()
        snapHelper2.attachToRecyclerView(secondTypeRecyclerView)



        thirdTypeRecyclerView = view.findViewById(R.id.first_type_recycleView_3)
        val thirdTypeSlideItem = listOf(
            FirstDataType(R.drawable.a_1),
            FirstDataType(R.drawable.a_2),
            FirstDataType(R.drawable.a_3),
            FirstDataType(R.drawable.a_4),
            FirstDataType(R.drawable.a_5),
            FirstDataType(R.drawable.a_6),
            FirstDataType(R.drawable.a_7),
            FirstDataType(R.drawable.a_8),
            FirstDataType(R.drawable.a_9),
            FirstDataType(R.drawable.a_10),
            FirstDataType(R.drawable.a_11)
        )
        thirdTypeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val secondTypeAdapter3 = FirstTypeAdapter(thirdTypeSlideItem, this)
        thirdTypeRecyclerView.adapter = secondTypeAdapter3
        val snapHelper3: SnapHelper = LinearSnapHelper()
        snapHelper3.attachToRecyclerView(thirdTypeRecyclerView)

        fourthTypeRecyclerView = view.findViewById(R.id.first_type_recycleView_4)
        val fourthTypeSlideItem = listOf(
            FirstDataType(R.drawable.h_1),
            FirstDataType(R.drawable.h_2),
            FirstDataType(R.drawable.h_3),
            FirstDataType(R.drawable.h_4),
            FirstDataType(R.drawable.h_5),
            FirstDataType(R.drawable.h_6),
            FirstDataType(R.drawable.h_7),
            FirstDataType(R.drawable.h_8),
            FirstDataType(R.drawable.h_9),
            FirstDataType(R.drawable.h_11)
        )
        fourthTypeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val secondTypeAdapter4 = FirstTypeAdapter(fourthTypeSlideItem, this)
        fourthTypeRecyclerView.adapter = secondTypeAdapter4
        val snapHelper4: SnapHelper = LinearSnapHelper()
        snapHelper4.attachToRecyclerView(fourthTypeRecyclerView)




        fifthTypeRecyclerView = view.findViewById(R.id.first_type_recycleView_5)
        val fiveTypeSlideItem = listOf(
            FirstDataType(R.drawable.s_1),
            FirstDataType(R.drawable.s_2),
            FirstDataType(R.drawable.s_3),
            FirstDataType(R.drawable.s_4),
            FirstDataType(R.drawable.s_5),
            FirstDataType(R.drawable.s_6),
            FirstDataType(R.drawable.s_7),
            FirstDataType(R.drawable.s_8),
            FirstDataType(R.drawable.s_9),
            FirstDataType(R.drawable.s_10),
            FirstDataType(R.drawable.s_11)
        )
        fifthTypeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val secondTypeAdapter5 = FirstTypeAdapter(fiveTypeSlideItem, this)
        fifthTypeRecyclerView.adapter = secondTypeAdapter5
        val snapHelper5: SnapHelper = LinearSnapHelper()
        snapHelper5.attachToRecyclerView(fifthTypeRecyclerView)


        sixthTypeRecyclerView = view.findViewById(R.id.first_type_recycleView_6)
        val sixthTypeSlideItem = listOf(
            FirstDataType(R.drawable.cartoon_1),
            FirstDataType(R.drawable.cartoon_2),
            FirstDataType(R.drawable.cartoon_3),
            FirstDataType(R.drawable.cartoon_3),
            FirstDataType(R.drawable.cartoon_4),
            FirstDataType(R.drawable.cartoon_5),
            FirstDataType(R.drawable.cartoon_6),
            FirstDataType(R.drawable.cartoon_7),
            FirstDataType(R.drawable.cartoon_8),
            FirstDataType(R.drawable.cartoon_9),
            FirstDataType(R.drawable.cartoon_10),
            FirstDataType(R.drawable.cartoon_11)
        )
        sixthTypeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val secondTypeAdapter6 = FirstTypeAdapter(sixthTypeSlideItem, this)
        sixthTypeRecyclerView.adapter = secondTypeAdapter6
        val snapHelper6: SnapHelper = LinearSnapHelper()
        snapHelper6.attachToRecyclerView(sixthTypeRecyclerView)


        sevenTypeRecyclerView = view.findViewById(R.id.first_type_recycleView_7)
        val sevenTypeSlideItem = listOf(
            FirstDataType(R.drawable.adventure_1),
            FirstDataType(R.drawable.adventure_2),
            FirstDataType(R.drawable.adventure_3),
            FirstDataType(R.drawable.adventure_3),
            FirstDataType(R.drawable.adventure_4),
            FirstDataType(R.drawable.adventure_5),
            FirstDataType(R.drawable.adventure_6),
            FirstDataType(R.drawable.adventure_7),
            FirstDataType(R.drawable.adventure_8),
            FirstDataType(R.drawable.adventure_9),
            FirstDataType(R.drawable.adventure_10),
            FirstDataType(R.drawable.adventure_11)
        )
        sevenTypeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val secondTypeAdapter7 = FirstTypeAdapter(sevenTypeSlideItem, this)
        sevenTypeRecyclerView.adapter = secondTypeAdapter7
        val snapHelper7: SnapHelper = LinearSnapHelper()
        snapHelper7.attachToRecyclerView(sevenTypeRecyclerView)



        eighthTypeRecyclerView = view.findViewById(R.id.first_type_recycleView_8)
        val eightTypeSlideItem = listOf(
            FirstDataType(R.drawable.anim_1),
            FirstDataType(R.drawable.anim_2),
            FirstDataType(R.drawable.anim_3),
            FirstDataType(R.drawable.anim_4),
            FirstDataType(R.drawable.anim_5),
            FirstDataType(R.drawable.anim_6),
            FirstDataType(R.drawable.anim_7),
            FirstDataType(R.drawable.anim_8),
            FirstDataType(R.drawable.anim_9),
            FirstDataType(R.drawable.anim_10),
            FirstDataType(R.drawable.anim_11)
        )
        eighthTypeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val secondTypeAdapter8 = FirstTypeAdapter(eightTypeSlideItem, this)
        eighthTypeRecyclerView.adapter = secondTypeAdapter8
        val snapHelper8: SnapHelper = LinearSnapHelper()
        snapHelper8.attachToRecyclerView(eighthTypeRecyclerView)




        ninthTypeRecyclerView = view.findViewById(R.id.first_type_recycleView_9)
        val ninthTypeSlideItem = listOf(
            FirstDataType(R.drawable.detect_1),
            FirstDataType(R.drawable.detect_2),
            FirstDataType(R.drawable.detect_3),
            FirstDataType(R.drawable.detect_4),
            FirstDataType(R.drawable.detect_5),
            FirstDataType(R.drawable.detect_6),
            FirstDataType(R.drawable.detect_7),
            FirstDataType(R.drawable.detect_8),
            FirstDataType(R.drawable.detect_9),
            FirstDataType(R.drawable.detect_10),
            FirstDataType(R.drawable.detect_11),
        )
        ninthTypeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val secondTypeAdapter9 = FirstTypeAdapter(ninthTypeSlideItem, this)
        ninthTypeRecyclerView.adapter = secondTypeAdapter9
        val snapHelper9: SnapHelper = LinearSnapHelper()
        snapHelper9.attachToRecyclerView(ninthTypeRecyclerView)


        tenthTypeRecyclerView = view.findViewById(R.id.first_type_recycleView_10)
        val tenthTypeSlideItem = listOf(
            FirstDataType(R.drawable.family_1),
            FirstDataType(R.drawable.family_2),
            FirstDataType(R.drawable.family_3),
            FirstDataType(R.drawable.family_4),
            FirstDataType(R.drawable.family_5),
            FirstDataType(R.drawable.family_6),
            FirstDataType(R.drawable.family_7),
            FirstDataType(R.drawable.family_8),
            FirstDataType(R.drawable.family_9),
            FirstDataType(R.drawable.family_10),
            FirstDataType(R.drawable.family_11),
        )
        tenthTypeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val secondTypeAdapter10 = FirstTypeAdapter(tenthTypeSlideItem, this)
        tenthTypeRecyclerView.adapter = secondTypeAdapter10
        val snapHelper10: SnapHelper = LinearSnapHelper()
        snapHelper10.attachToRecyclerView(tenthTypeRecyclerView)



        eleventhTypeRecyclerView = view.findViewById(R.id.first_type_recycleView_11)
        val eleventhTypeSlideItem = listOf(
            FirstDataType(R.drawable.historic_1),
            FirstDataType(R.drawable.historic_2),
            FirstDataType(R.drawable.historic_3),
            FirstDataType(R.drawable.historic_4),
            FirstDataType(R.drawable.historic_5),
            FirstDataType(R.drawable.historic_6),
            FirstDataType(R.drawable.historic_7),
            FirstDataType(R.drawable.historic_8),
            FirstDataType(R.drawable.historic_9),
            FirstDataType(R.drawable.historic_10),
            FirstDataType(R.drawable.historic_11),
        )
        eleventhTypeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val secondTypeAdapter11 = FirstTypeAdapter(eleventhTypeSlideItem, this)
        eleventhTypeRecyclerView.adapter = secondTypeAdapter11
        val snapHelper11: SnapHelper = LinearSnapHelper()
        snapHelper11.attachToRecyclerView(eleventhTypeRecyclerView)


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
                R.drawable.pirates,
                "Пираты Карибского моря",
                "Сюжет повествует о капитан Джек Воробей и его приключениях , где переплетаются множество легенд , мифов и реальных историй о коряблях и морях",
                "8.1",
                "фэнтези, боевик, комедия, приключения"
            ),
            CustomDataClass(
                R.drawable.lord_of_the_rings,
                "Властелин колец",
                "Сюжет трилогии следует за хоббитом Фродо Бэггинсом, который идёт в поход вместе с Братством Кольца с целью уничтожения Кольца Всевластия.",
                "8.8",
                "фэнтези, приключения, драма, боевик"
            ),
            CustomDataClass(
                R.drawable.fast_and_furious_final,
                "Форсаж",
                "Франшиза стоящаяся во многом на гонках , криминале и великом разнообразие преимиальных машин , где главным персонажем является Доминик Торетто",
                "8.2",
                "боевик, триллер, преступление"
            ),
            CustomDataClass(
                R.drawable.bg_game,
                "Игра престолов",
                "Действие сериала происходит на вымышленных континентах Вестерос и Эссос и повествует о борьбе за власть между благородными семьями за власть.",
                "8.9",
                "Фентези , Романтика , Триллер"
            ),

            CustomDataClass(
                R.drawable.avatar,
                "Игра престолов",
                "Сюжет повествет о Джейке Салли - морпехе , который принимает решение стать аватаром и изменить свою жизнь на другой планете.",
                "8.5",
                "приключения, драма, боевик, фантастика"
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

    fun placeHolder(adapterPosition: Int, view: View) {
        val fatherId = (view.parent.parent.parent as View).id
        val fatherIdName = resources.getResourceEntryName(fatherId)
        when (fatherIdName) {
            "frameLayout_11" -> {
                when (adapterPosition) {
                    0 -> {
                        showFragment(
                            R.drawable.historic_7,
                            arrayListOf("Drama", "Horror", "Historic"),
                            "Вышел",
                            "Описание"
                        )
                    }

                    1 -> {
                        Toast.makeText(
                            requireContext(),
                            "Драмма -> 1",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    2 -> {
                        Toast.makeText(
                            requireContext(),
                            "Драмма -> 2",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    3 -> {
                        Toast.makeText(
                            requireContext(),
                            "Драмма -> 3",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    4 -> {
                        Toast.makeText(
                            requireContext(),
                            "Драмма -> 4",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    5 -> {
                        Toast.makeText(
                            requireContext(),
                            "Драмма -> 5",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    6 -> {
                        Toast.makeText(
                            requireContext(),
                            "Драмма -> 6",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    7 -> {
                        Toast.makeText(
                            requireContext(),
                            "Драмма -> 7",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    8 -> {
                        Toast.makeText(
                            requireContext(),
                            "Драмма -> 8",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    9 -> {
                        Toast.makeText(
                            requireContext(),
                            "Драмма -> 9",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    10 -> {
                        Toast.makeText(
                            requireContext(),
                            "Драмма -> 10",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    11 -> {
                        Toast.makeText(
                            requireContext(),
                            "Драмма -> 11",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }

            "frameLayout_22" -> {
                when (adapterPosition) {
                    0 -> {
                        Toast.makeText(
                            requireContext(),
                            "Боевик -> 0",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    1 -> {
                        Toast.makeText(
                            requireContext(),
                            "Боевик -> 1",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    2 -> {
                        Toast.makeText(
                            requireContext(),
                            "Боевик -> 2",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    3 -> {
                        Toast.makeText(
                            requireContext(),
                            "Боевик -> 3",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    4 -> {
                        Toast.makeText(
                            requireContext(),
                            "Боевик -> 4",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    5 -> {
                        Toast.makeText(
                            requireContext(),
                            "Боевик -> 5",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    6 -> {
                        Toast.makeText(
                            requireContext(),
                            "Боевик -> 6",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    7 -> {
                        Toast.makeText(
                            requireContext(),
                            "Боевик -> 7",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    8 -> {
                        Toast.makeText(
                            requireContext(),
                            "Боевик -> 8",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    9 -> {
                        Toast.makeText(
                            requireContext(),
                            "Боевик -> 9",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    10 -> {
                        Toast.makeText(
                            requireContext(),
                            "Боевик -> 10",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    11 -> {
                        Toast.makeText(
                            requireContext(),
                            "Боевик -> 11",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            "frameLayout" -> {
                when (adapterPosition) {
                    0 -> {
                        Toast.makeText(
                            requireContext(),
                            "Комедия -> 0",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    1 -> {
                        Toast.makeText(
                            requireContext(),
                            "Комедия -> 1",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    2 -> {
                        Toast.makeText(
                            requireContext(),
                            "Комедия -> 2",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    3 -> {
                        Toast.makeText(
                            requireContext(),
                            "Комедия -> 3",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    4 -> {
                        Toast.makeText(
                            requireContext(),
                            "Комедия -> 4",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    5 -> {
                        Toast.makeText(
                            requireContext(),
                            "Комедия -> 5",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    6 -> {
                        Toast.makeText(
                            requireContext(),
                            "Комедия -> 6",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    7 -> {
                        Toast.makeText(
                            requireContext(),
                            "Комедия -> 7",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    8 -> {
                        Toast.makeText(
                            requireContext(),
                            "Комедия -> 8",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    9 -> {
                        Toast.makeText(
                            requireContext(),
                            "Комедия -> 9",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    10 -> {
                        Toast.makeText(
                            requireContext(),
                            "Комедия -> 10",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    11 -> {
                        Toast.makeText(
                            requireContext(),
                            "Комедия -> 11",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            "frameLayout_2" -> {
                when (adapterPosition) {
                    0 -> {
                        Toast.makeText(
                            requireContext(),
                            "Ужасы -> 0",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    1 -> {
                        Toast.makeText(
                            requireContext(),
                            "Ужасы -> 1",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    2 -> {
                        Toast.makeText(
                            requireContext(),
                            "Ужасы -> 2",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    3 -> {
                        Toast.makeText(
                            requireContext(),
                            "Ужасы -> 3",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    4 -> {
                        Toast.makeText(
                            requireContext(),
                            "Ужасы -> 4",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    5 -> {
                        Toast.makeText(
                            requireContext(),
                            "Ужасы -> 5",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    6 -> {
                        Toast.makeText(
                            requireContext(),
                            "Ужасы -> 6",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    7 -> {
                        Toast.makeText(
                            requireContext(),
                            "Ужасы -> 7",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    8 -> {
                        Toast.makeText(
                            requireContext(),
                            "Ужасы -> 8",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    9 -> {
                        Toast.makeText(
                            requireContext(),
                            "Ужасы -> 9",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    10 -> {
                        Toast.makeText(
                            requireContext(),
                            "Ужасы -> 10",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    11 -> {
                        Toast.makeText(
                            requireContext(),
                            "Ужасы -> 11",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            "frameLayout_3" -> {
                when (adapterPosition) {
                    0 -> {
                        Toast.makeText(
                            requireContext(),
                            "Научная фантастика -> 0",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    1 -> {
                        Toast.makeText(
                            requireContext(),
                            "Научная фантастика -> 1",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    2 -> {
                        Toast.makeText(
                            requireContext(),
                            "Научная фантастика -> 2",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    3 -> {
                        Toast.makeText(
                            requireContext(),
                            "Научная фантастика -> 3",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    4 -> {
                        Toast.makeText(
                            requireContext(),
                            "Научная фантастика -> 4",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    5 -> {
                        Toast.makeText(
                            requireContext(),
                            "Научная фантастика -> 5",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    6 -> {
                        Toast.makeText(
                            requireContext(),
                            "Научная фантастика -> 6",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    7 -> {
                        Toast.makeText(
                            requireContext(),
                            "Научная фантастика -> 7",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    8 -> {
                        Toast.makeText(
                            requireContext(),
                            "Научная фантастика -> 8",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    9 -> {
                        Toast.makeText(
                            requireContext(),
                            "Научная фантастика -> 9",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    10 -> {
                        Toast.makeText(
                            requireContext(),
                            "Научная фантастика -> 10",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    11 -> {
                        Toast.makeText(
                            requireContext(),
                            "Научная фантастика -> 11",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            "frameLayout_4" -> {
                when (adapterPosition) {
                    0 -> {
                        Toast.makeText(
                            requireContext(),
                            "Мультфильмы -> 0",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    1 -> {
                        Toast.makeText(
                            requireContext(),
                            "Мультфильмы -> 1",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    2 -> {
                        Toast.makeText(
                            requireContext(),
                            "Мультфильмы -> 2",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    3 -> {
                        Toast.makeText(
                            requireContext(),
                            "Мультфильмы -> 3",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    4 -> {
                        Toast.makeText(
                            requireContext(),
                            "Мультфильмы -> 4",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    5 -> {
                        Toast.makeText(
                            requireContext(),
                            "Мультфильмы -> 5",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    6 -> {
                        Toast.makeText(
                            requireContext(),
                            "Мультфильмы -> 6",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    7 -> {
                        Toast.makeText(
                            requireContext(),
                            "Мультфильмы -> 7",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    8 -> {
                        Toast.makeText(
                            requireContext(),
                            "Мультфильмы -> 8",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    9 -> {
                        Toast.makeText(
                            requireContext(),
                            "Мультфильмы -> 9",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    10 -> {
                        Toast.makeText(
                            requireContext(),
                            "Мультфильмы -> 10",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    11 -> {
                        Toast.makeText(
                            requireContext(),
                            "Мультфильмы -> 11",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            "frameLayout_5" -> {
                when (adapterPosition) {
                    0 -> {
                        Toast.makeText(
                            requireContext(),
                            "Приключения -> 0",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    1 -> {
                        Toast.makeText(
                            requireContext(),
                            "Приключения -> 1",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    2 -> {
                        Toast.makeText(
                            requireContext(),
                            "Приключения -> 2",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    3 -> {
                        Toast.makeText(
                            requireContext(),
                            "Приключения -> 3",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    4 -> {
                        Toast.makeText(
                            requireContext(),
                            "Приключения -> 4",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    5 -> {
                        Toast.makeText(
                            requireContext(),
                            "Приключения -> 5",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    6 -> {
                        Toast.makeText(
                            requireContext(),
                            "Приключения -> 6",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    7 -> {
                        Toast.makeText(
                            requireContext(),
                            "Приключения -> 7",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    8 -> {
                        Toast.makeText(
                            requireContext(),
                            "Приключения -> 8",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    9 -> {
                        Toast.makeText(
                            requireContext(),
                            "Приключения -> 9",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    10 -> {
                        Toast.makeText(
                            requireContext(),
                            "Приключения -> 10",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    11 -> {
                        Toast.makeText(
                            requireContext(),
                            "Приключения -> 11",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            "frameLayout_6" -> {
                when (adapterPosition) {
                    0 -> {
                        Toast.makeText(
                            requireContext(),
                            "Аниме -> 0",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    1 -> {
                        Toast.makeText(
                            requireContext(),
                            "Аниме -> 1",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    2 -> {
                        Toast.makeText(
                            requireContext(),
                            "Аниме -> 2",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    3 -> {
                        Toast.makeText(
                            requireContext(),
                            "Аниме -> 3",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    4 -> {
                        Toast.makeText(
                            requireContext(),
                            "Аниме -> 4",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    5 -> {
                        Toast.makeText(
                            requireContext(),
                            "Аниме -> 5",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    6 -> {
                        Toast.makeText(
                            requireContext(),
                            "Аниме -> 6",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    7 -> {
                        Toast.makeText(
                            requireContext(),
                            "Аниме -> 7",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    8 -> {
                        Toast.makeText(
                            requireContext(),
                            "Аниме -> 8",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    9 -> {
                        Toast.makeText(
                            requireContext(),
                            "Аниме -> 9",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    10 -> {
                        Toast.makeText(
                            requireContext(),
                            "Аниме -> 10",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    11 -> {
                        Toast.makeText(
                            requireContext(),
                            "Аниме -> 11",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            "frameLayout_7" -> {
                when (adapterPosition) {
                    0 -> {
                        Toast.makeText(
                            requireContext(),
                            "Детектив 1 -> 0",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    1 -> {
                        Toast.makeText(
                            requireContext(),
                            "Детектив 1 -> 1",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    2 -> {
                        Toast.makeText(
                            requireContext(),
                            "Детектив 1 -> 2",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    3 -> {
                        Toast.makeText(
                            requireContext(),
                            "Детектив 1 -> 3",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    4 -> {
                        Toast.makeText(
                            requireContext(),
                            "Детектив 1 -> 4",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    5 -> {
                        Toast.makeText(
                            requireContext(),
                            "Детектив 1 -> 5",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    6 -> {
                        Toast.makeText(
                            requireContext(),
                            "Детектив 1 -> 6",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    7 -> {
                        Toast.makeText(
                            requireContext(),
                            "Детектив 1 -> 7",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    8 -> {
                        Toast.makeText(
                            requireContext(),
                            "Детектив 1 -> 8",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    9 -> {
                        Toast.makeText(
                            requireContext(),
                            "Детектив 1 -> 9",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    10 -> {
                        Toast.makeText(
                            requireContext(),
                            "Детектив 1 -> 10",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    11 -> {
                        Toast.makeText(
                            requireContext(),
                            "Детектив 1 -> 11",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            "frameLayout_8" -> {
                when (adapterPosition) {
                    0 -> {
                        Toast.makeText(
                            requireContext(),
                            "Семейное -> 0",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    1 -> {
                        Toast.makeText(
                            requireContext(),
                            "Семейное -> 1",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    2 -> {
                        Toast.makeText(
                            requireContext(),
                            "Семейное -> 2",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    3 -> {
                        Toast.makeText(
                            requireContext(),
                            "Семейное -> 3",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    4 -> {
                        Toast.makeText(
                            requireContext(),
                            "Семейное -> 4",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    5 -> {
                        Toast.makeText(
                            requireContext(),
                            "Семейное -> 5",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    6 -> {
                        Toast.makeText(
                            requireContext(),
                            "Семейное -> 6",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    7 -> {
                        Toast.makeText(
                            requireContext(),
                            "Семейное -> 7",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    8 -> {
                        Toast.makeText(
                            requireContext(),
                            "Семейное -> 8",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    9 -> {
                        Toast.makeText(
                            requireContext(),
                            "Семейное -> 9",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    10 -> {
                        Toast.makeText(
                            requireContext(),
                            "Семейное -> 10",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    11 -> {
                        Toast.makeText(
                            requireContext(),
                            "Семейное -> 11",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            "frameLayout_9" -> {
                when (adapterPosition) {
                    0 -> {
                        Toast.makeText(
                            requireContext(),
                            "Историческое -> 0",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    1 -> {
                        Toast.makeText(
                            requireContext(),
                            "Историческое -> 1",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    2 -> {
                        Toast.makeText(
                            requireContext(),
                            "Историческое -> 2",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    3 -> {
                        Toast.makeText(
                            requireContext(),
                            "Историческое -> 3",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    4 -> {
                        Toast.makeText(
                            requireContext(),
                            "Историческое -> 4",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    5 -> {
                        Toast.makeText(
                            requireContext(),
                            "Историческое -> 5",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    6 -> {
                        Toast.makeText(
                            requireContext(),
                            "Историческое -> 6",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    7 -> {
                        Toast.makeText(
                            requireContext(),
                            "Историческое -> 7",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    8 -> {
                        Toast.makeText(
                            requireContext(),
                            "Историческое -> 8",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    9 -> {
                        Toast.makeText(
                            requireContext(),
                            "Историческое -> 9",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    10 -> {
                        Toast.makeText(
                            requireContext(),
                            "Историческое -> 10",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    11 -> {
                        Toast.makeText(
                            requireContext(),
                            "Историческое -> 11",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

        }

    }

    private fun showFragment(
        cardImage: Int,
        str: ArrayList<String>,
        Status: String,
        Description: String
    ) {
        val fragment = BlankHomeFragment.newInstance(cardImage, str, Status, Description)
        changeFragment(fragment)
    }

    private fun changeFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.Main_Space_To_Fragment, fragment)
            .commit()
    }


    companion object {
        private const val AUTO_SCROLL_DELAY = 10000L // Задержка в миллисекундах (4 секунды)

        @JvmStatic
        fun newInstance() = HomeFragment()


    }
}
