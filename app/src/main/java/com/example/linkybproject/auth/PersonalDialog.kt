package com.example.linkybproject.auth

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.MainActivity
import com.example.linkybproject.R

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

        // 적용하기 버튼 누르면 닫힘.
        val applyBtn : Button = dialog.findViewById(R.id.btn_personal_apply)
        applyBtn.setOnClickListener{
            onClickListener.onClicked(true)
            dialog.dismiss()
        }

        // activity와 연결하기
        val personalList = ArrayList<Personal>()
        // 이 list 값들이 선택한 값들이 되어야 함 (list 값 수정하기)
        personalList.add(Personal(0, "외향적"))
        personalList.add(Personal(1, "내향적"))
        personalList.add(Personal(2, "이성적"))
        personalList.add(Personal(3, "감성적"))
        personalList.add(Personal(4, "사교적"))
        personalList.add(Personal(5, "계획적"))
        personalList.add(Personal(6, "자유분방"))
        personalList.add(Personal(7, "독립적"))
        personalList.add(Personal(8, "주도적"))

        val personalAdapter = SignupPersonalRVAdapter(personalList)
        val recyclerViewPersonal : RecyclerView = dialog.findViewById(R.id.recyclerView_personalDialog)
        recyclerViewPersonal.layoutManager = GridLayoutManager(dialog.context, 2, GridLayoutManager.HORIZONTAL, false)
        personalAdapter.setPersonalItemClickListener(object : SignupPersonalRVAdapter.PersonalItemClickListener{
            override fun onItemClick(personal: Personal) {
                // 클릭했을 때 무엇을 할 지 내용 작성
                Toast.makeText(dialog.context, "클릭", Toast.LENGTH_SHORT).show()
            }
        })
        recyclerViewPersonal.adapter = personalAdapter

        // 우선 클릭시 listitem layout 바꾸는 거 해보기 . 이게 되어야 진행됨.
        // 안되면 걍 하나하나 뷰 짜기. 빠르게 !
        // 그리고 다이얼로그에서 눌러서 signupactivity4로 값 보내서 받고, 성격 view에 띄워야 함.(이건 recyclerView로 해야겠지) + 회원가입 시에 보낼 준비


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