package com.example.linkybproject.connect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.R

class ConnectRAdapter(var connectList: List<LBUser>): RecyclerView.Adapter<ConnectRAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_connect_to_me, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.userNickName.text = connectList[position].userNickName
        holder.userLikeCount.text = connectList[position].userLikeCount.toString()
        holder.userMajorName.text = connectList[position].userMajorName
        holder.userStudentNum.text = connectList[position].userStudentNum
    }

    override fun getItemCount(): Int {
        return connectList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val userNickName: TextView = itemView.findViewById(R.id.profile_name)
        val userLikeCount: TextView = itemView.findViewById(R.id.profile_like)
        val userMajorName: TextView = itemView.findViewById(R.id.profile_major)
        val userStudentNum: TextView = itemView.findViewById(R.id.profile_classOf)
    }

}