package com.example.linkybproject.homes

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.FragmentHomeGraduateBinding

class HomeGraudateFragment : Fragment(), HomeGraduateView {
    private lateinit var binding: FragmentHomeGraduateBinding
    var mainAppActivity: AppCompatActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AppCompatActivity) {
            mainAppActivity = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeGraduateBinding.inflate(inflater,container,false)

        val homeStudentList: ArrayList<HomeStudentResult> = arrayListOf()
        //val adapter = mainAppActivity?.let { HomeRecyclerViewAdapter(it) }

//        adapter?.datalist =mutableListOf(
//            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 20, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
//            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
//            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 23, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
//            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
//            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 22, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
//            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
//            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 20, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
//            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
//            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
//
//            )



        binding.recyclerviewHomeGraduate.adapter  = HomeRecyclerViewAdapter(homeStudentList)
        binding.recyclerviewHomeGraduate.layoutManager = LinearLayoutManager(context)


        //2단계: 해당 Service를 호출해서 정의하고, setView 함수 호출로 연결해준다.

        /* 졸업생 리스트 조회 api 호출 */
        val homeGraduateService = HomeGraduateService()
        homeGraduateService.setHomeGraduateView(this)
        val accessToken = context?.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)?.getString("accessToken","");
        if (accessToken != null && accessToken.isNotEmpty()) {
            homeGraduateService.homeGraduate(accessToken);
        }
    return binding.root
    }

    override fun onHomeGraduateListSuccess(homeGraduateList: HomeGraduateResponse) {
        Log.d("getGraduateList", "Success")
        binding.recyclerviewHomeGraduate.adapter = HomeRecyclerViewAdapter(homeGraduateList.data.graduates)
    }

    override fun onGetHomeGraduateListFailure() {
        TODO("Not yet implemented")
    }

    /* 졸업생 리스트 조회 api 호출 결과 */

}


