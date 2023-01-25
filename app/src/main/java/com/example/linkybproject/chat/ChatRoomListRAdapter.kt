package com.example.linkybproject.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.R

class ChatRoomListRAdapter(var chatRoomList: List<ChatRoom>): RecyclerView.Adapter<ChatRoomListRAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_list, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chatRoomList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.userNickname.text = chatRoomList[position].userNickname
        holder.userMajorName.text = chatRoomList[position].userMajorName + " / "
        holder.userStudentNum.text = chatRoomList[position].userStudentNum + "학번"
        holder.lastConversationContents.text = chatRoomList[position].lastConversationContents
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userNickname: TextView = itemView.findViewById(R.id.textView_item_chat_name)
        val userMajorName: TextView = itemView.findViewById(R.id.textView_item_chat_major)
        val userStudentNum: TextView = itemView.findViewById(R.id.textView_item_chat_sid)
        val lastConversationContents: TextView = itemView.findViewById(R.id.textView_item_chat_last_conversation)
    }
}