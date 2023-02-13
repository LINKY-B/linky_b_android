package com.example.linkybproject.homes


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.connect.ConnectionProfileActivity
import com.example.linkybproject.databinding.ItemHomeConnectRequestBinding
import com.example.linkybproject.databinding.ItemHomeRecyclerBinding

class HomeRecyclerViewAdapter(private val appCompatActivity: AppCompatActivity): RecyclerView.Adapter<HomeRecyclerViewAdapter.MyViewHolder>() {

    var datalist = mutableListOf<UserData>()//리사이클러뷰에서 사용할 데이터 미리 정의 -> 나중에 MainActivity 등에서 datalist에 실제 데이터 추가

    inner class MyViewHolder(private val binding: ItemHomeRecyclerBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(userData: UserData){
            //binding.dogPhotoImg.=dogData.dog_img
            binding.profileName.text=userData.username
            binding.tvHomeLikenumber.text= userData.likecount.toString()
            binding.tvHomeDepartment.text=userData.department

            binding.ibItemConnect.setOnClickListener {
                val dlg = ConnectDialog(appCompatActivity)
                dlg.Mydlg()
            }

/*
            binding.profileImg.setOnClickListener {
                val intent = Intent(binding.root.context, HomeUserInformationActivity::class.java)
                binding.root.context.startActivity(intent)
            }

            binding.profileName.setOnClickListener {
                val intent = Intent(binding.root.context, HomeUserInformationActivity::class.java)
                intent.run { binding.root.context.startActivity(this) }
            }
*/
        }
    }


    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=ItemHomeRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size


    //recyclerview가 viewholder를 가져와 데이터 연결할때 호출
    //적절한 데이터를 가져와서 그 데이터를 사용하여 뷰홀더의 레이아웃 채움
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position])

/*
        // ViewHolder를 클릭했을 때 이벤트 정의
        holder.itemView.setOnClickListener {
            // 위에서 만든 Interface의 onItemClick을 실행
            // 실제 이 함수 내용 정의는 Activity나 Fragment에서 이뤄짐
            mItemClickListener.onItemClick(datalist[position])
        }
*/
    }

/*
    // 인터페이스 정의
    interface MyItemClickListener {
        // 이 함수를 만들어야한다고 알려줌
        fun onItemClick(userData: UserData)
    }

    // 위의 Interface를 Adapter 내부에서 사용하기 위한 변수
   // 즉 이 변수 값으로 Interface를 상속받은 Class가 들어감
   // 일반적으로 RecyclerView를 만드는 Activity나 Fragment, 혹은 자체적으로 만든 객체
    private lateinit var mItemClickListener: MyItemClickListener

    // 위에서 만든 변수에 값을 집어넣는 함수
   // 값을 집어넣기 위해 MyItemClickListener 타입을 가지는 변수를 필요로 함
   // Adapter 내부가 아니라 RecyclerView가 들어가는 Activity나 Fragment에서 호출함

    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        // 변수에 가져온 값 할당
        mItemClickListener = itemClickListener
    }
*/

}

