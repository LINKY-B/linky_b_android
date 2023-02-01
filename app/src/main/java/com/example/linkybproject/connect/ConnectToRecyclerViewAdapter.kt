package com.example.linkybproject.connect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.databinding.ItemConnectToBinding
import com.example.linkybproject.homes.UserData

class ConnectToRecyclerViewAdapter: RecyclerView.Adapter<ConnectToRecyclerViewAdapter.MyViewHolder>() {

    var datalist = mutableListOf<ConnectUserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectToRecyclerViewAdapter.MyViewHolder {
        val binding = ItemConnectToBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position])
    }

    inner class MyViewHolder(private val binding: ItemConnectToBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(userData: ConnectUserData){
            binding.profileName.text = userData.username
            binding.profileLike.text = userData.likecount.toString()
            binding.profileMajor.text = userData.department
        }
    }

}