package com.example.linkybproject.auth.signup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.auth.Personal
import com.example.linkybproject.databinding.ItemMyprofilePersonal2Binding

class SignupPersonalRVAdapter(private val personalList: ArrayList<Personal>) : RecyclerView.Adapter<SignupPersonalRVAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemMyprofilePersonal2Binding): RecyclerView.ViewHolder(binding.root) {

        fun bind(personal: Personal) {
            binding.textViewItemMyProfile2Personal.text = personal.keyWord
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemMyprofilePersonal2Binding = ItemMyprofilePersonal2Binding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(personalList[position])
        holder.itemView.setOnClickListener {
            pItemClickListener.onItemClick(personalList[position]) }
    }

    override fun getItemCount(): Int {
        return personalList.size
    }


    // 각각의 item을 클릭했을 때 이벤트 정의
    interface PersonalItemClickListener {
        fun onItemClick(personal: Personal)
    }

    private lateinit var pItemClickListener: PersonalItemClickListener

    fun setPersonalItemClickListener(itemClickListener: PersonalItemClickListener) {
        pItemClickListener = itemClickListener
    }
}