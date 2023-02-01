package com.example.linkybproject.connect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.databinding.ItemConnectFromBinding

class ConnectFromRecyclerViewAdapter:RecyclerView.Adapter<ConnectFromRecyclerViewAdapter.ViewHolder>() {

    var datalist = mutableListOf<ConnectUserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectFromRecyclerViewAdapter.ViewHolder {
        val binding = ItemConnectFromBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
        // (1) 리스트 내 항목 클릭 시 onClick() 호출
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(datalist[position])
        }
    }
    // (2) 리스너 인터페이스
    interface OnItemClickListener {
        fun onClick(userData: ConnectUserData)
    }
    // (3) 외부에서 클릭 시 이벤트 설정
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    // (4) setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener : OnItemClickListener

    inner class ViewHolder(private val binding: ItemConnectFromBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(userData: ConnectUserData){
            binding.profileName.text = userData.username
            binding.profileLike.text = userData.likecount.toString()
            binding.profileMajor.text = userData.information

/*
            binding.profileImg.setOnClickListener {
                Intent(context, ConnectionProfileActivity::class.java).run { context.startActivity(this) }
            }
*/
        }
    }

}