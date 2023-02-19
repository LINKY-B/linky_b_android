package com.example.linkybproject.connect

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.AcceptDialog
import com.example.linkybproject.InterestData
import com.example.linkybproject.RefuseDialog
import com.example.linkybproject.databinding.ItemConnectToMeBinding
import com.example.linkybproject.homes.HomeInterestRecyclerAdapter

class ConnectToRecyclerViewAdapter(private val appCompatActivity: AppCompatActivity): RecyclerView.Adapter<ConnectToRecyclerViewAdapter.MyViewHolder>() {

    var datalist = mutableListOf<ConnectToUserData>()
/*
    lateinit var items: ArrayList<InterestData>

    fun build(i: ArrayList<InterestData>): ConnectToRecyclerViewAdapter {
        items = i
        return this
    }
*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectToRecyclerViewAdapter.MyViewHolder {
        val binding = ItemConnectToMeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position])
/*
        holder.bind2(items[position])
*/
    }

    inner class MyViewHolder(private val binding: ItemConnectToMeBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(userData: ConnectToUserData){
            binding.profileName.text = userData.username
            binding.profileLike.text = userData.likecount.toString()
            binding.profileMajor.text = userData.major + "/"
            binding.profileClassOf.text = userData.classOf.toString() + "학번"

            binding.interestRecyclerview.apply {
                var innerRecyclerAdapter = HomeInterestRecyclerAdapter();
                innerRecyclerAdapter.datalist = userData.interests.toMutableList();
                adapter = innerRecyclerAdapter;
                layoutManager = LinearLayoutManager(binding.interestRecyclerview.context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
            }

            binding.btnYes.setOnClickListener {
                val dlg = AcceptDialog(appCompatActivity)
                dlg.Mydlg()
            }

            binding.btnNo.setOnClickListener {
                val dlg = RefuseDialog(appCompatActivity)
                dlg.Mydlg()
            }

            binding.profileImg.setOnClickListener {
                val intent = Intent(binding.root.context, ConnectToProfileActivity::class.java)
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
                val intent = Intent(binding.root.context, ConnectToProfileActivity::class.java)
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