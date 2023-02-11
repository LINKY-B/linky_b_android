package com.example.linkybproject.connect

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.AcceptDialog
import com.example.linkybproject.RefuseDialog
import com.example.linkybproject.databinding.ItemConnectFromBinding

class ConnectFromRecyclerViewAdapter(private val appCompatActivity: AppCompatActivity):RecyclerView.Adapter<ConnectFromRecyclerViewAdapter.ViewHolder>() {

    var datalist = mutableListOf<ConnectUserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectFromRecyclerViewAdapter.ViewHolder {
        val binding = ItemConnectFromBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
    }

    inner class ViewHolder(private val binding: ItemConnectFromBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(userData: ConnectUserData){
            binding.profileName.text = userData.username
            binding.profileLike.text = userData.likecount.toString()
            binding.profileMajor.text = userData.major + "/"
            binding.profileClassOf.text = userData.classOf.toString() + "학번"

            binding.btnYes.setOnClickListener {
                val dlg = AcceptDialog(appCompatActivity)
                dlg.Mydlg()
            }

            binding.btnNo.setOnClickListener {
                val dlg = RefuseDialog(appCompatActivity)
                dlg.Mydlg()
            }

            binding.profileImg.setOnClickListener {
                val intent = Intent(binding.root.context, ConnectionProfileActivity::class.java)
                intent.putExtra("name", userData.username)
                intent.putExtra("like", userData.likecount)
/*
                intent.putExtra("numOfLink", userData.)
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