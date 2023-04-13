package com.example.linkybproject.myprofile

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.RectF
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.caverock.androidsvg.PreserveAspectRatio
import com.caverock.androidsvg.SVG
import com.caverock.androidsvg.SVGParseException
import com.example.linkybproject.common.MainActivity
import com.example.linkybproject.databinding.FragmentMyprofile1Binding
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.io.InputStream
import kotlin.math.min
import kotlin.math.roundToInt

class MyProfile1Fragment : Fragment(), MyProfileView {
    private lateinit var binding: FragmentMyprofile1Binding
    private lateinit var mainActivity : MainActivity

    // fragment2 로 가져갈 것 우선 이렇게만.
    private lateinit var profileImg: String
    private lateinit var nickName: String
    private lateinit var introduction: String
    private lateinit var major: String
    private lateinit var studentNum: String
    private lateinit var age: String
    private lateinit var gender: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMyprofile1Binding.inflate(inflater, container, false)

        /* 현재 사용자 정보 상세 조회 api */
        val profileService = MyProfileService()
        profileService.setMyProfileView(this)
        profileService.getUser(requireContext().getSharedPreferences("auth", Context.MODE_PRIVATE).getString("accessToken", "")!!)


        /* 이벤트 리스너 */
        binding.imageViewMyProfileSettings.setOnClickListener {
            val intent = Intent(activity, SetUpActivity::class.java)
            startActivity(intent)
        }

        binding.imageViewMyProfileEdit.setOnClickListener {
            mainActivity.myprofile1Tomyprofile2(MyProfile2Fragment(), profileImg, nickName, introduction, major, studentNum, age, gender)
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }


    // profileImg 렌더링
    fun urlToSvgBitmap(url: String, context: MyProfile1Fragment): Bitmap? {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(url)
            .build()

        return try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                response.body?.byteStream()?.use { inputStream ->
                    convertSvgToBitmap(inputStream, context)
                }

            }
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
    fun convertSvgToBitmap(inputStream: InputStream, context: MyProfile1Fragment): Bitmap? {
        return try {
            val svg = SVG.getFromInputStream(inputStream)
            val heightDp = 74f // Change this to your desired height in dp
            val widthDp = 74f // Change this to your desired width in dp
            val heightPx = dpToPx(context, heightDp)
            val widthPx = dpToPx(context, widthDp)

            svg.documentPreserveAspectRatio = PreserveAspectRatio.LETTERBOX

            val bitmap = Bitmap.createBitmap(widthPx, heightPx, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)

            // Calculate the scale factor and translation to center the SVG image inside the bitmap
            val scaleFactor = min(widthPx / svg.documentWidth, heightPx / svg.documentHeight)
            val dx = (widthPx - svg.documentWidth * scaleFactor) / 2f
            val dy = (heightPx - svg.documentHeight * scaleFactor) / 2f

            canvas.translate(dx, dy)
            canvas.scale(scaleFactor, scaleFactor)
            svg.renderToCanvas(canvas)
            bitmap
        } catch (e: SVGParseException) {
            e.printStackTrace()
            null
        }
    }
    fun dpToPx(context: MyProfile1Fragment, dp: Float): Int {
        val density = context.resources.displayMetrics.density
        return (dp * density).roundToInt()
    }

    override fun onGetUserSuccess(result: MyProfileResponse) {
        Log.d("onGetUserSuccess", "Success")
        Log.d("RESULT.DATA", result.data.toString())

        val iv = binding.imageViewMyProfileProfileimage
        profileImg = result.data.userProfileImg

        GlobalScope.launch(Dispatchers.IO) {
            val bitmap = urlToSvgBitmap(profileImg, this@MyProfile1Fragment)
            // Use the Bitmap on the UI thread, for example, setting it to an ImageView
            launch(Dispatchers.Main) {
                iv.setImageBitmap(bitmap)
            }
        }

        binding.textViewMyProfileNickname.text = result.data.userNickName
        binding.textViewMyProfileBeanCount.text = result.data.userLikeCount.toString()
        binding.textViewMyProfileIntro.text = result.data.userSelfIntroduction
        binding.textViewMyProfileGreen2.text = result.data.userMatchingCount.toString() + "명과 링크 중입니다."
        binding.textViewMyProfileMajorDetail.text = result.data.userMajorName
        binding.textViewMyProfileNoDetail.text = result.data.userStudentNum

        binding.textViewMyProfileAgeDetail.text = (2023 - result.data.userBirth.substring(0,4).toInt()).toString()
        binding.textViewMyProfileGenderDetail.text = result.data.userSex
        binding.textViewMyProfileMbtiDetail.text = result.data.userMBTI

        val personalityList: ArrayList<String> = result.data.userPersonality as ArrayList<String>
        val myProfile1PersonalityRVAdapter = MyProfile1PersonalityRVAdapter(personalityList)
        binding.recyclerViewMyProfilePersonal.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewMyProfilePersonal.adapter = myProfile1PersonalityRVAdapter

        val interestList: ArrayList<String> = result.data.userInterest as ArrayList<String>
        val myProfile1InterestRVAdapter = MyProfile1InterestRVAdapter(interestList)
        binding.recyclerViewMyProfileInterest.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewMyProfileInterest.adapter = myProfile1InterestRVAdapter

        nickName = result.data.userNickName
        introduction = result.data.userSelfIntroduction
        major = result.data.userMajorName
        studentNum = result.data.userStudentNum
        age = (2023 - result.data.userBirth.substring(0,4).toInt()).toString()
        gender = result.data.userSex

    }

    override fun onGetUserFailure() {
        Log.d("onGetUserFailure", "Failure")
    }
}