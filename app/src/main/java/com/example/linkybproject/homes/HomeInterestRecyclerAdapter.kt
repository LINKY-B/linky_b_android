package com.example.linkybproject.homes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.databinding.ItemConnectInterestBinding
import com.example.linkybproject.databinding.ItemHomeConnectRequestBinding


class HomeInterestRecyclerAdapter: RecyclerView.Adapter<HomeInterestRecyclerAdapter.ViewHolder>() {

    var datalist = mutableListOf<String>()//리사이클러뷰에서 사용할 데이터 미리 정의 -> 나중에 MainActivity 등에서 datalist에 실제 데이터 추가

    inner class ViewHolder(private val binding: ItemConnectInterestBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(interest: String){
            //binding.dogPhotoImg.=dogData.dog_img
            binding.textViewItemMyProfileInterest.text=interest//.interest

        }
    }

    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=
            ItemConnectInterestBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    //recyclerview가 viewholder를 가져와 데이터 연결할때 호출
    //적절한 데이터를 가져와서 그 데이터를 사용하여 뷰홀더의 레이아웃 채움



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
//        holder.bind(            UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
    }

}
