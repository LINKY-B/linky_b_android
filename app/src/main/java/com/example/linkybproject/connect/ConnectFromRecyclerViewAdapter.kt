package com.example.linkybproject.connect

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.databinding.ItemConnectFromBinding
import com.example.linkybproject.homes.UserData

class ConnectFromRecyclerViewAdapter:RecyclerView.Adapter<ConnectFromRecyclerViewAdapter.ViewHolder>() {

    var datas = mutableListOf<ConnectUserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectFromRecyclerViewAdapter.ViewHolder {
        val binding = ItemConnectFromBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(private val binding: ItemConnectFromBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(userData: ConnectUserData){
            binding.profileName.text = userData.username
            binding.profileLike.text = userData.likecount.toString()
            binding.profileMajor.text = userData.information

/*
            binding.profileImg.setOnClickListener {
                val intent = Intent(context, ConnectionProfileActivity::class.java)
                start
            }
*/
        }
    }

}