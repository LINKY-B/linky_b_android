package com.example.linkybproject.auth

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.example.linkybproject.R
import com.example.linkybproject.auth.signup.SignupActivity4

class PersonalDialog (context: Context) {
    private lateinit var onClickListener: OnDialogClickListener
    private val dialog = Dialog(context)

    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }

    fun quitInitViews(){
        // 뒤로가기 버튼, 빈 화면 터치를 통해 dialog가 사라지지 않도록
        dialog.setContentView(R.layout.activity_personal_dialog)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.show()


        // 선택지
        val p1grey : TextView = dialog.findViewById(R.id.personal_1_grey)
        val p1green : TextView = dialog.findViewById(R.id.personal_1_green)
        p1grey.setOnClickListener {
            onClickListener.onClicked(true)
            p1grey.visibility = View.INVISIBLE
            p1green.visibility = View.VISIBLE
        }
        p1green.setOnClickListener {
            onClickListener.onClicked(true)
            p1grey.visibility = View.VISIBLE
            p1green.visibility = View.INVISIBLE
        }
        val p2grey : TextView = dialog.findViewById(R.id.personal_2_grey)
        val p2green : TextView = dialog.findViewById(R.id.personal_2_green)
        p2grey.setOnClickListener {
            onClickListener.onClicked(true)
            p2grey.visibility = View.INVISIBLE
            p2green.visibility = View.VISIBLE
        }
        p2green.setOnClickListener {
            onClickListener.onClicked(true)
            p2grey.visibility = View.VISIBLE
            p2green.visibility = View.INVISIBLE
        }


        // 적용하기 버튼 누르면 닫힘.
        val applyBtn : Button = dialog.findViewById(R.id.btn_personal_apply)
        applyBtn.setOnClickListener{
            onClickListener.onClicked(true)
            val intent = Intent(dialog.context, SignupActivity4::class.java)
            intent.putExtra("p1", "다정한")
            dialog.context.startActivity(intent)
            dialog.dismiss()
        }

        // OK Button 클릭에 대한 Callback 처리. 이 부분은 상황에 따라 자유롭게!
//        dialog.leave_btn.setOnClickListener {
//            onClickListener.onClicked(true)
//            dialog.dismiss()
//        }


    }

    fun logoutInitViews(){
        // 뒤로가기 버튼, 빈 화면 터치를 통해 dialog가 사라지지 않도록
        dialog.setContentView(R.layout.dialog_logout)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.show()

        // OK Button 클릭에 대한 Callback 처리. 이 부분은 상황에 따라 자유롭게!
//        dialog.logout_cancel_btn.setOnClickListener {
//            onClickListener.onClicked(false)
//            dialog.dismiss()
//        }
//        dialog.logout_btn.setOnClickListener {
//            onClickListener.onClicked(true)
//            dialog.dismiss()
//        }

    }


    interface OnDialogClickListener
    {
        fun onClicked(flag: Boolean)
    }

}