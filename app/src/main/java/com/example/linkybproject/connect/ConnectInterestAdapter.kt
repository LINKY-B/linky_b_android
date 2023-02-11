package com.example.linkybproject.connect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.InterestData
import com.example.linkybproject.databinding.ItemConnectInterestBinding

class ConnectInterestAdapter : RecyclerView.Adapter<ConnectInterestAdapter.ViewHolder>() {
    var datalist = mutableListOf<InterestData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectInterestAdapter.ViewHolder {
        val binding = ItemConnectInterestBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
    }

    inner class ViewHolder(private val binding: ItemConnectInterestBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(interest: InterestData) {
            binding.textViewItemMyProfileInterest.text = interest.interest
        }
    }
}