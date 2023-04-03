package com.example.linkybproject.myprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.linkybproject.databinding.ActivitySetUpBinding
import com.example.linkybproject.onBoarding.PrevLoginActivity

class SetUpActivity : AppCompatActivity(), AlarmView, ActiveView {
    private lateinit var viewBinding: ActivitySetUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySetUpBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val alarmService = AlarmService()
        alarmService.setAlarmView(this)

        val activeService = ActiveService()
        activeService.setActiveView(this)

        viewBinding.btnBack.setOnClickListener {
            finish()
        }

        viewBinding.reportManagement.setOnClickListener {
            val intent = Intent(this, ManageBlockingActivity::class.java)
            startActivity(intent)
        }

        viewBinding.btnSetUpPasswordChange.setOnClickListener {
            val intent = Intent(this, ChangePasswordActivity::class.java)
            startActivity(intent)
        }

        viewBinding.btnSetUpLogout.setOnClickListener {
            val dlg = LogoutDialog(this)
            dlg.Mydlg()

            dlg.setOnClickedListener(object : LogoutDialog.ButtonClickListener {
                override fun onClicked(myName: String) {
                    if (myName == "logout") {
                        Toast.makeText(this@SetUpActivity, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@SetUpActivity, PrevLoginActivity::class.java)
                        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
                    }
                }
            })
        }

        viewBinding.btnSetUpMemberLeave.setOnClickListener {
            val intent = Intent(this, MemberLeaveActivity::class.java)
            startActivity(intent)
        }

        viewBinding.setUpSwitch1.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                Log.d("Test","check")
                activeService.turnOnTheInfo( "Bearer " + "")
            } else {
                Log.d("Test","uncheck")
                activeService.turnOffTheInfo( "Bearer " + "")
            }
        }

        viewBinding.setUpSwitch2.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                Log.d("Test","check")
                alarmService.turnOnTheNotice( "Bearer " + "")
            } else{
                Log.d("Test","uncheck")
                alarmService.turnOffTheNotice( "Bearer " + "")
            }
        }
    }

    override fun onAlarmSuccess(turnOnTheNotice: AlarmResponse) {
        Log.d("Test", "Success")
    }

    override fun onAlarmFailure() {
        Log.d("Test", "Fail")
    }

    override fun onActiveSuccess(turnOnTheInfo: ActiveResponse) {
        Log.d("Test", "Success")
    }

    override fun onActiveFailure() {
        Log.d("Test", "Fail")
    }

}