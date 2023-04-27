package com.example.linkybproject.homes

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.FragmentHomeStudentsBinding
//1단계: View Interface를 상속받는다.
//2단계: 해당 Service를 호출해서 정의하고, setView 함수 호출로 연결해준다.
//3단계: overrideing 한 interface 함수를 통해 들어오는 Response를 가공해 화면해 보여준다. → Adapter 연결도 필요하다면 이 때 해주면 된다.

//1단계: View Interface를 상속받는다.
class HomeStudentFragment : Fragment() , HomeStudentView, HomeProfileView {
    private lateinit var binding: FragmentHomeStudentsBinding

    var mainAppActivity: AppCompatActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AppCompatActivity) {
            mainAppActivity = context
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeStudentsBinding.inflate(inflater, container, false)

        /* 리사이클러뷰 */
        //val adapter = mainAppActivity?.let { HomeRecyclerViewAdapter(it) }
        val homeStudentList: ArrayList<HomeStudentResult> = arrayListOf()

        binding.recyclerviewHomeStudents.adapter = HomeRecyclerViewAdapter(homeStudentList)
        binding.recyclerviewHomeStudents.layoutManager = LinearLayoutManager(context)


        //2단계: 해당 Service를 호출해서 정의하고, setView 함수 호출로 연결해준다.

        /* 재학생 리스트 조회 api 호출 */
        val homeStudentService = HomeStudentService()
        homeStudentService.setHomeStudentView(this)
        val accessToken = context?.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)
            ?.getString("accessToken", "");
        if (accessToken != null && accessToken.isNotEmpty()) {
            homeStudentService.homeStudent(accessToken);
        }

        return binding.root
    }

    /* 재학생 리스트 조회 api 호출 결과 */
    override fun onHomeStudentListSuccess(homeStudentList: HomeStudentResponse) {
        binding.recyclerviewHomeStudents.adapter =
            HomeRecyclerViewAdapter(homeStudentList.data.students)
        Log.d("재학생 리스트 조회", "Success")
    }

    override fun onGetHomeStudentListFailure() {
        Log.d("재학생 리스트 조회", "Failure")
    }


    /* 홈 화면 사용자 프로필 api 호출 결과 */
    override fun onHomeProfileSuccess(homeProfileResponse: HomeProfileResponse) {
        Log.d("홈 화면 사용자 프로필 조회", "Success")
    }

    override fun onGetHomeProfileFailure() {
        Log.d("홈 화면 사용자 프로필 조회", "Failure")
    }
}


