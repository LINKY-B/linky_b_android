package com.example.linkybproject.connect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.databinding.ItemMyprofileInterestBinding
import com.example.linkybproject.homes.Interest

class ProfileInterestAdapter : RecyclerView.Adapter<ProfileInterestAdapter.ViewHolder>() {
    var datalist = mutableListOf<Interest>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileInterestAdapter.ViewHolder {
        val binding = ItemMyprofileInterestBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
    }

    inner class ViewHolder(private val binding: ItemMyprofileInterestBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(interest: Interest) {
            binding.textViewItemMyProfileInterest.text = interest.interest
        }
    }
}