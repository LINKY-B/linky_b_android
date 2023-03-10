package com.example.linkybproject.homes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentHomeGraduateBinding

class HomeGraudateFragment : Fragment() {
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

        val adapter = mainAppActivity?.let { HomeRecyclerViewAdapter(it) }

        adapter?.datalist =mutableListOf(
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 20, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 23, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 22, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 20, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),

            )

        binding.recyclerviewHomeGraduate.adapter  = adapter
        binding.recyclerviewHomeGraduate.layoutManager = LinearLayoutManager(context)

        return binding.root
    }
}


