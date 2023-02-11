package com.example.linkybproject.connect

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.databinding.ItemConnectToBinding

class ConnectToRecyclerViewAdapter(private val appCompatActivity: AppCompatActivity): RecyclerView.Adapter<ConnectToRecyclerViewAdapter.MyViewHolder>() {

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
            binding.profileMajor.text = userData.major + "/"
            binding.profileClassOf.text = userData.classOf.toString() + "학번"

            binding.btnConnectDelete.setOnClickListener {
                val dlg = DeleteDialog(appCompatActivity)
                dlg.Mydlg()
            }

            binding.profileImg.setOnClickListener {
                val intent = Intent(binding.root.context, ConnectionProfileActivity::class.java)
                intent.putExtra("name", userData.username)
                intent.putExtra("like", userData.likecount)
/*
                intent.putExtra("numOfLink", )
*/
                intent.putExtra("major", userData.major)
                intent.putExtra("classOf", userData.classOf)
                intent.putExtra("age", userData.age)
                intent.putExtra("gender", userData.gender)
                intent.putExtra("mbti", userData.mbti)
                intent.run { binding.root.context.startActivity(this) }
            }

            binding.profileName.setOnClickListener {
                val intent = Intent(binding.root.context, ConnectionProfileActivity::class.java)
                intent.putExtra("name", binding.profileName.text)
                intent.putExtra("like", binding.profileLike.text)
                /*
                intent.putExtra("numOfLink", )
*/
                intent.putExtra("major", binding.profileMajor.text)
                intent.putExtra("classOf", binding.profileClassOf.text)
                intent.putExtra("age", userData.age)
                intent.putExtra("gender", userData.gender)
                intent.putExtra("mbti", userData.mbti)
                intent.run { binding.root.context.startActivity(this) }
            }
        }
    }
}