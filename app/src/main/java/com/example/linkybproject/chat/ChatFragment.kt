package com.example.linkybproject.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private lateinit var binding : FragmentChatBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentChatBinding.inflate(layoutInflater)

        // 더미데이터
        val chatRoomList : ArrayList<ChatRoom> = arrayListOf()
        chatRoomList.add(ChatRoom(1, 1, "사과", "시각디자인학과", "20", "img1", "hello", "2021-02-25T16:10:45.8306309"))
        chatRoomList.add(ChatRoom(2, 2, "에어팟", "컴퓨터학과", "21", "img1", "hello", "2021-02-25T16:10:45.8306309"))
        chatRoomList.add(ChatRoom(3, 3, "해커", "식품영양학과", "19", "img1", "hello", "2021-02-25T16:10:45.8306309"))
        chatRoomList.add(ChatRoom(4, 4, "안드로이드", "음악학과", "20", "img1", "hello", "2021-02-25T16:10:45.8306309"))
        chatRoomList.add(ChatRoom(5, 5, "브리", "체육학과", "20", "img1", "hello", "2021-02-25T16:10:45.8306309"))
        chatRoomList.add(ChatRoom(1, 1, "나르치스", "사회학과", "21", "img1", "hello", "2021-02-25T16:10:45.8306309"))
        chatRoomList.add(ChatRoom(2, 2, "골드문트", "물리학과", "22", "img1", "hello", "2021-02-25T16:10:45.8306309"))
        chatRoomList.add(ChatRoom(3, 3, "토마토", "전기공학과", "23", "img1", "hello", "2021-02-25T16:10:45.8306309"))
        chatRoomList.add(ChatRoom(4, 4, "몬스터", "법학과", "17", "img1", "hello", "2021-02-25T16:10:45.8306309"))
        chatRoomList.add(ChatRoom(5, 5, "웬즈데이", "의학과", "15", "img1", "hello", "2021-02-25T16:10:45.8306309"))

        // 리사이클러뷰
        binding.recyclerViewChat.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewChat.setHasFixedSize(true)
        binding.recyclerViewChat.adapter = ChatRoomListRAdapter(chatRoomList)

        return binding.root
    }

}