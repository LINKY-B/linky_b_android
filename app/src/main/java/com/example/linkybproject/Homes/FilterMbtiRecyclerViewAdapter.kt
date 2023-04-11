package com.example.linkybproject.Homes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.databinding.ItemFilterMbtiBinding

class FilterMbtiRecyclerViewAdapter :
    RecyclerView.Adapter<FilterMbtiRecyclerViewAdapter.ViewHolder>(){

    var datalist =
        mutableListOf<Mbti>()//리사이클러뷰에서 사용할 데이터 미리 정의 -> 나중에 MainActivity 등에서 datalist에 실제 데이터 추가

    inner class ViewHolder(private val binding: ItemFilterMbtiBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mbti: Mbti) {
            //binding.dogPhotoImg.=dogData.dog_img
            binding.tvFilterMbti.text = mbti.mbti
        }

    }

    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFilterMbtiBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int = datalist.size

    //recyclerview가 viewholder를 가져와 데이터 연결할때 호출
    //적절한 데이터를 가져와서 그 데이터를 사용하여 뷰홀더의 레이아웃 채움


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
    }

}
