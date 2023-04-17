package com.example.linkybproject.homes


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.databinding.ItemHomeRecyclerBinding

class HomeRecyclerViewAdapter(private var homeStudentList: List<HomeStudentResult>) : RecyclerView.Adapter<HomeRecyclerViewAdapter.MyViewHolder>() {


    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=ItemHomeRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    // 실제 각 뷰 홀더에 데이터를 연결해주는 함수
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(homeStudentList[position]) }

    override fun getItemCount(): Int = homeStudentList.size


    // 리사이클러뷰에 들어갈 뷰 홀더, 그리고 그 뷰 홀더에 들어갈 아이템들을 지정
    class MyViewHolder(private val binding: ItemHomeRecyclerBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(homeStudentResult: HomeStudentResult){
            //binding.dogPhotoImg.=dogData.dog_img
            binding.profileName.text=homeStudentResult.username
            binding.tvHomeLikenumber.text= homeStudentResult.likecount.toString()
            binding.tvHomeDepartment.text=homeStudentResult.department
            binding.tvHomeStudentnum.text = homeStudentResult.studentnum.toString()

            binding.ibItemConnect.setOnClickListener {
                val dlg = ConnectDialog(binding.root.context)
                var intent = Intent()
                intent.putExtra("username",homeStudentResult.username)
                dlg.Mydlg(intent)
            }

            // interest 리사이클러뷰 어댑터 가져오기
            binding.recyclerviewHomeMainItem.apply {
                var innerRecyclerAdapter = HomeInterestRecyclerAdapter();
                innerRecyclerAdapter.datalist = homeStudentResult.interest.toMutableList();
                adapter = innerRecyclerAdapter;
                layoutManager = LinearLayoutManager(binding.recyclerviewHomeMainItem.context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
            }

            binding.profileImg.setOnClickListener {
                val intent = Intent(binding.root.context, HomeUserInformationActivity::class.java)
                itemView.context.startActivity(intent)
            }


            binding.profileName.setOnClickListener {
                val intent = Intent(binding.root.context, HomeUserInformationActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }

    }
}

