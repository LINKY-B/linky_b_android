package com.example.linkybproject.homes

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.linkybproject.databinding.DialogConnectBinding
import com.example.linkybproject.databinding.ItemHomeRecyclerBinding

class ConnectDialog(private val context: Context):HomeConnectTryView {
    private lateinit var binding: DialogConnectBinding
    private val dlg = Dialog(context)

    fun Mydlg(intent: Intent) {
        binding = DialogConnectBinding.inflate(LayoutInflater.from(context))
        val extras = intent.extras
        val data = extras!!["username"]
        binding.dialogConnectUserName.text = data as CharSequence?
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)
        dlg.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        dlg.setCancelable(false)

        binding.btnClose.setOnClickListener {
            dlg.dismiss()
        }

        binding.btnConnectTry.setOnClickListener {
            /* 홈 유저 매칭 시도 api 호출 */
            val homeConnectTryService = HomeConnectTryService()
            homeConnectTryService.setHomeConnectTryView(this)

            val accessToken = context?.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)?.getString("accessToken","");
            if (accessToken != null && accessToken.isNotEmpty()) {
                homeConnectTryService.homeConnectTry(accessToken,2)
            }
            Toast.makeText(context, "연결을 시도하였습니다.", Toast.LENGTH_SHORT).show()
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

    /* 홈 유저 매칭 시도 api 호출 결과 */
    override fun onHomeConnectTrySuccess(homeConnectResponse: HomeConnectResponse) {
        Log.d("홈 유저 매칭 시도", "Success")
    }
    override fun onGetHomeConnectTryFailure() {
        Log.d("홈 유저 매칭 시도", "Failure")
    }
}