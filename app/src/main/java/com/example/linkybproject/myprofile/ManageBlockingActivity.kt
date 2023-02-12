package com.example.linkybproject.myprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.ActivityManageBlockingBinding
import com.example.linkybproject.homes.UserData

class ManageBlockingActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityManageBlockingBinding
    lateinit var adapter: ManageBlockingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityManageBlockingBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

        viewBinding.btnAllUnblocking.setOnClickListener {
            val dlg = UnblockDialog(this)
            dlg.Mydlg()
        }

        adapter = ManageBlockingAdapter()

        viewBinding.listBlocking.adapter = adapter
        adapter.notifyDataSetChanged()

    }

}