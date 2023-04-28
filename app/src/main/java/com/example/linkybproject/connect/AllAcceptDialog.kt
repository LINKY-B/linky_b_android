package com.example.linkybproject.connect

import android.app.Dialog
import android.content.Intent
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.databinding.DialogAllAcceptBinding

class AllAcceptDialog(private val context: AppCompatActivity) : AllMatchingView {
    private lateinit var binding: DialogAllAcceptBinding
    private val dlg = Dialog(context)
    private var targetUserId = ""

    fun Mydlg(intent: Intent) {
        binding = DialogAllAcceptBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)
        dlg.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dlg.setCancelable(false)

        binding.btnClose.setOnClickListener {
            dlg.dismiss()
        }

/*
        this.targetUserId = (intent.extras!!["userid"] as Int).toString()
*/
        binding.btnAllAcceptance.setOnClickListener {
            val allMatchingService = AllMatchingService()
            allMatchingService.setAllMatchingView(this)

/*
            if (this.targetUserId.isEmpty()) {
                return@setOnClickListener
            }
*/

            val accessToken = context?.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)?.getString("accessToken", "")
            if (accessToken != null && accessToken.isNotEmpty()) {
                Log.d("Test","allmatching")
                allMatchingService.matchingAll(accessToken, userGetMatched = this.targetUserId)
            }

            Toast.makeText(context, "모든 연결을 수락하였습니다.", Toast.LENGTH_SHORT).show()
            dlg.dismiss()
        }

        dlg.show()
    }

    interface ButtonClickListener {
        fun onClicked(myName: String)
    }

    private lateinit var onClickedListener: ButtonClickListener

    fun setOnClickedListener(listener: ButtonClickListener) {
        onClickedListener = listener
    }

    override fun onAllMatchingSuccess(matchingAll: AllMatchingResponse) {
        Log.d("Test", "Success")
    }

    override fun onAllMatchingFailure() {
        Log.d("Test", "Fail")
    }

}