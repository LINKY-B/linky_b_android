package com.example.linkybproject.Homes

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

    /* 졸업생 리스트 조회 api 호출 결과 */
    override fun onHomeGraduateListSuccess(homeGraduateList: HomeGraduateResponse) {
        Log.d("졸업생 리스트 조회", "Success")
        binding.recyclerviewHomeGraduate.adapter = HomeRecyclerViewAdapter(homeGraduateList.data.graduates)
    }

    override fun onGetHomeGraduateListFailure() {
        Log.d("졸업생 리스트 조회", "Failure")
    }

}


