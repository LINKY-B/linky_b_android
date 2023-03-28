package com.example.linkybproject.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.common.BlockDialog
import com.example.linkybproject.common.ReportDialog
import com.example.linkybproject.databinding.ActivityChatRoomBinding

class ChatRoomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageViewChatRoomPlus.setOnClickListener {
            val dlg = ChatDialog(this)
            dlg.Mydlg()

            dlg.setOnClickedListener(object : ChatDialog.ButtonClickListener {
                override fun onClicked(myName: String) {
                    if (myName == "report") {
                        val dlgReport = ReportDialog(this@ChatRoomActivity)
                        dlgReport.Mydlg()
                    }
                    else if (myName == "block") {
                        val dlgBlock = BlockDialog(this@ChatRoomActivity)
                        dlgBlock.Mydlg()
                    }
                    else if (myName == "leave") {
                        val dlgLeave = ChatLeaveDialog(this@ChatRoomActivity)
                        dlgLeave.Mydlg()
                    }
                }
            })
        }

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