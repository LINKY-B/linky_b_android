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
import com.example.linkybproject.connect.ConnectRAdapter
import com.example.linkybproject.connect.LBUser
import com.example.linkybproject.databinding.FragmentHomeStudentsBinding
//1단계: View Interface를 상속받는다.
//2단계: 해당 Service를 호출해서 정의하고, setView 함수 호출로 연결해준다.
//3단계: overrideing 한 interface 함수를 통해 들어오는 Response를 가공해 화면해 보여준다. → Adapter 연결도 필요하다면 이 때 해주면 된다.

//1단계: View Interface를 상속받는다.
class HomeStudentFragment : Fragment() , HomeStudentView{
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

//        adapter?.datalist = mutableListOf(
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

        binding.recyclerviewHomeStudents.adapter = HomeRecyclerViewAdapter(homeStudentList)
        binding.recyclerviewHomeStudents.layoutManager = LinearLayoutManager(context)

//2단계: 해당 Service를 호출해서 정의하고, setView 함수 호출로 연결해준다.

        /* 재학생 리스트 조회 api 호출 */
        val homeStudentService = HomeStudentService()
        homeStudentService.setHomeStudentView(this)
        homeStudentService.homeStudent("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBY2Nlc3NUb2tlbiIsIm1lbWJlcklkIjoiMiIsImF1dGhvcml0aWVzIjoiVVNFUiIsInR5cGUiOiJCZWFyZXIiLCJleHAiOjE2ODA0MjQwNzd9.jhNb5DmfhCl5goQpfKcVGvXHWiEXaiYchrlMQk-vOTL4GoH2Mcztbk8iMKmhT2ldwqxZnSScx8iAxYW_bmYR8A")
        return binding.root
    }

    /* 재학생 리스트 조회 api 호출 결과 */
    override fun onHomeStudentListSuccess(homeStudentList: HomeStudentResponse) {
        Log.d("ConnectToMe", "Success")
        binding.recyclerviewHomeStudents.adapter = HomeRecyclerViewAdapter(homeStudentList.result)

    }

    override fun onGetHomeStudentListFailure() {
        Log.d("ConnectToMe", "Failure")
    }
}


/*
        // 위에서 만든 setMyItemClickListener를 이용해 Interface를 상속받아 객체를 만들고
        // 이 객체를 Adapter로 보냄
        adapter.setMyItemClickListener(object :
            HomeRecyclerViewAdapter.MyItemClickListener {
            // 아이템 클릭시 이벤트 정의
            override fun onItemClick(userData: UserData) {
                // 클릭했을 때 무엇을 할 지 내용 작성

                // Dialog만들기
                val mDialogView =
                    LayoutInflater.from(context).inflate(R.layout.dialog_connect, null)
                val mBuilder = AlertDialog.Builder(context)
                    .setView(mDialogView)

                val mAlertDialog = mBuilder.show()

                val okButton = mDialogView.findViewById<Button>(R.id.btn_connect_try)
                okButton.setOnClickListener {
                    Toast.makeText(context, "연결을 시도하였습니다.", Toast.LENGTH_SHORT).show()
                    mAlertDialog.dismiss()
                }
            }
        })
*/

