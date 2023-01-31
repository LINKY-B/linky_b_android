package com.example.linkybproject.myprofile

import android.app.Dialog
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.databinding.DialogLogoutBinding

class LogoutDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogLogoutBinding
    private val dlg = Dialog(context)

    fun Mydlg() {
        binding = DialogLogoutBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)
        dlg.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dlg.setCancelable(false)

        binding.btnClose.setOnClickListener {
            dlg.dismiss()
        }

        binding.btnLogout.setOnClickListener{
/*
            val intent = Intent(this, PrevLoginActivity::class.java)
*/
        }

        dlg.show()
    }

/*
    fun setOnOKClickedListener(listener: (String) -> Unit) {
        this.listener = object: LogoutDialogOnClickListener {
            override fun onClicked(content: String) {
                listener(content)
            }
        }
    }

    interface LogoutDialogOnClickListener {
        fun onClicked(content: String)
    }
*/

}