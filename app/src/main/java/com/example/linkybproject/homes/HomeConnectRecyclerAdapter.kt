package com.example.linkybproject.homes

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.common.AcceptDialog
import com.example.linkybproject.common.RefuseDialog
import com.example.linkybproject.databinding.ItemHomeConnectRequestBinding


class HomeConnectRecyclerAdapter(private val appCompatActivity: AppCompatActivity): RecyclerView.Adapter<HomeConnectRecyclerAdapter.ViewHolder>() {

    var datalist = mutableListOf<UserData>()//리사이클러뷰에서 사용할 데이터 미리 정의 -> 나중에 MainActivity 등에서 datalist에 실제 데이터 추가

    inner class ViewHolder(private val binding: ItemHomeConnectRequestBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userData: UserData) {
            //binding.dogPhotoImg.=dogData.dog_img
            binding.textviewHomeItemNickname.text = userData.username
            binding.textviewHomeItemCount.text = userData.likecount.toString()
            binding.textviewHomeItemDepartment.text = userData.department
            binding.textviewHomeItemClassNumber.text = userData.studentnum.toString()


            binding.recyclerviewHomeItem.apply {
                var ad = HomeInterestRecyclerAdapter();
                ad.datalist = userData.interests.toMutableList();
                adapter = ad;
                layoutManager = LinearLayoutManager(binding.recyclerviewHomeItem.context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)

            }

            binding.ibHomeItemDelete.setOnClickListener {
                val dlg = RefuseDialog(appCompatActivity)
                dlg.Mydlg()
            }

            binding.btnHomeItemAccept.setOnClickListener {
                val dlg = AcceptDialog(appCompatActivity)
                dlg.Mydlg()
            }

            binding.imageviewHomeItemProfileimg.setOnClickListener {
                val intent = Intent(binding.root.context, HomeUserInformationActivity::class.java)
                binding.root.context.startActivity(intent)
            }

            binding.textviewHomeItemNickname.setOnClickListener {
                val intent = Intent(binding.root.context, HomeUserInformationActivity::class.java)
                intent.run { binding.root.context.startActivity(this) }
            }

        }

    }

    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeConnectRecyclerAdapter.ViewHolder {
        val binding = ItemHomeConnectRequestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int = datalist.size

    //recyclerview가 viewholder를 가져와 데이터 연결할때 호출
    //적절한 데이터를 가져와서 그 데이터를 사용하여 뷰홀더의 레이아웃 채움


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
//        holder.bind(            UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
    }

}


