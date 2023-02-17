package com.example.linkybproject.homes

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.linkybproject.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment:Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomeRecyclerViewAdapter
    var mainAppActivity: AppCompatActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AppCompatActivity) {
            mainAppActivity = context
        }
    }

    //val mDatas = mutableListOf<UserData>()

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2


    private val tabTextList = listOf<String>("재학생", "졸업생")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.tvHomeRefuse.setOnClickListener {
            val dlg = AllRefuseDialog(binding.root.context as AppCompatActivity)
            dlg.Mydlg()
        }

        binding.viewpager2Home.adapter = FragmentAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewpager2Home) { tab, position ->
            tab.text = tabTextList[position]
        }.attach()


        val adapter = mainAppActivity?.let { HomeConnectRecyclerAdapter(it) }

        val adapter2 = HomeInterestRecyclerAdapter()

        adapter?.datalist = mutableListOf(
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            )
        binding.rvHomeNewConnect.adapter = adapter
        binding.rvHomeNewConnect.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


        //필터 넘어가는 버튼
        val btn: ImageButton = binding.ibtnHomeFilter
        btn.setOnClickListener {
            val intent = Intent(activity,FilterActivity::class.java)
            startActivity(intent)
        }



        binding.scrollviewHome.run {
            header = binding.clHomeTab
            stickListener = { _ ->
                Log.d("LOGGER_TAG", "stickListener")
            }
            freeListener = { _ ->
                Log.d("LOGGER_TAG", "freeListener")
            }
            return binding.root


        }
    }
}



