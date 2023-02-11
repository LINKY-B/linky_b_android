package com.example.linkybproject.myprofile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.connect.ConnectUserData
import com.example.linkybproject.databinding.ItemBlockingBinding
import com.example.linkybproject.homes.UserData

class ManageBlockingAdapter: RecyclerView.Adapter<ManageBlockingAdapter.ViewHolder>() {
    var datalist = mutableListOf<ConnectUserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBlockingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
    }

    inner class ViewHolder(private val binding: ItemBlockingBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(userData: ConnectUserData){
            binding.profileName.text = userData.username
            binding.profileLike.text = userData.likecount.toString()
            binding.profileMajor.text = userData.major
            binding.profileClassOf.text = userData.classOf.toString()
        }
    }

}