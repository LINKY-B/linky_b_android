package com.example.linkybproject.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.ActivityConnectFromMeBinding

class ConnectFromMeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityConnectFromMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityConnectFromMeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

        val adapter = ConnectFromRecyclerViewAdapter()
/*

        adapter.setItemClickListener(object : ConnectFromRecyclerViewAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                val intent: Intent = Intent(this@ConnectFromMeActivity, ConnectionProfileActivity::class.java)
                intent.putExtra("Idx", Data[rv.getChildAdapterPosition(v)].item_Idx)


                startActivity(intent)
            }
        })
*/

        adapter.datalist = mutableListOf(
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
        )

        viewBinding.recyclerConnectFrom.adapter = adapter
        viewBinding.recyclerConnectFrom.layoutManager = LinearLayoutManager(this)

    }
}