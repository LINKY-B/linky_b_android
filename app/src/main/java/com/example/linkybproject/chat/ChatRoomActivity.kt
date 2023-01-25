package com.example.linkybproject.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.MainActivity
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivityChatRoomBinding

class ChatRoomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 인텐트 정보 받기
        val bundle = intent.extras
        if (bundle != null) {
            val chatRoom = bundle.getSerializable("chatRoom") as ChatRoom
            binding.textViewChatRoomProfile.text = chatRoom.userNickname
            binding.textViewChatRoomProfileInfo.text = chatRoom.userMajorName + " / " + chatRoom.userStudentNum + "학번"
            binding.chatRoomContent.text = chatRoom.lastConversationContents
        }

        // 이벤트 리스너
        binding.imageViewChatRoomBack.setOnClickListener {
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            finish()
        }
    }
}