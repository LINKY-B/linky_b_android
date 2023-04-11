package com.example.linkybproject.myprofile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.databinding.ItemMyprofileInterestBinding

class MyProfile1PersonalityRVAdapter(private val interestList: ArrayList<String>) : RecyclerView.Adapter<MyProfile1PersonalityRVAdapter.ViewHolder>() {

    // 실제 개별 데이터를 표현하기 위한 layout 파일과 실제 정보를 담고 있는 data class 를 연결
    inner class ViewHolder(val binding: ItemMyprofileInterestBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myProfile1Interest: String) {
            binding.textViewItemMyProfileInterest.text = myProfile1Interest
        }
    }

    // ViewHolder class 를 실제 객체로 만들어 내는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding : ItemMyprofileInterestBinding = ItemMyprofileInterestBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    // 실제 View 에 보여줄 항목들을 설정하는 함수
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(interestList[position])
    }

    // 데이터 개수가 총 몇 개인지 가져오는 함수
    override fun getItemCount(): Int {
        return interestList.size
    }

}