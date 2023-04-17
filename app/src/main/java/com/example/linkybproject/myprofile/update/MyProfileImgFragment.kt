package com.example.linkybproject.myprofile.update

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.linkybproject.auth.signup.ProfileImagesService
import com.example.linkybproject.auth.signup.ProfileImagesView
import com.example.linkybproject.common.MainActivity
import com.example.linkybproject.databinding.FragmentMyprofile2Binding
import com.example.linkybproject.databinding.FragmentMyprofileImgBinding
import com.example.linkybproject.myprofile.MyProfile2Fragment
import com.example.linkybproject.myprofile.SetUpActivity

class MyProfileImgFragment : Fragment(), ProfileImagesView {
    private lateinit var binding: FragmentMyprofileImgBinding

    private lateinit var mainActivity: MainActivity

    private lateinit var profileImg : String
    private var profileImages : ArrayList<String> = arrayListOf()

    private lateinit var birth: String
    private lateinit var nickName: String
    private lateinit var introduction: String
    private lateinit var major: String
    private lateinit var studentNum: String
    private lateinit var age: String
    private lateinit var gender: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMyprofileImgBinding.inflate(inflater, container, false)

        binding.imageViewImg1Green.visibility = View.INVISIBLE
        binding.imageViewImg2Green.visibility = View.INVISIBLE
        binding.imageViewImg3Green.visibility = View.INVISIBLE
        binding.imageViewImg4Green.visibility = View.INVISIBLE
        binding.imageViewImg5Green.visibility = View.INVISIBLE
        binding.imageViewImg6Green.visibility = View.INVISIBLE
        binding.imageViewImg7Green.visibility = View.INVISIBLE
        binding.imageViewImg8Green.visibility = View.INVISIBLE


        getProfileImages()

        arguments?.let {
            birth = it.getString("birth").toString()
            profileImg = it.getString("profileImg").toString()
            nickName = it.getString("nickName").toString()
            introduction = it.getString("introduction").toString()
            major = it.getString("major").toString()
            studentNum = it.getString("studentNum").toString()
            age = it.getString("age").toString()
            gender = it.getString("gender").toString()
            Log.d("birth", birth)
            Log.d("profileImg", profileImg)
            Log.d("nickName", nickName)
            Log.d("introduction", introduction)
            Log.d("major", major)
            Log.d("studentNum", studentNum)
            Log.d("age", age)
            Log.d("gender", gender)
        }

        binding.textViewProfileImgUpdate.setOnClickListener {
            mainActivity.myprofile3Tomyprofile2(MyProfile2Fragment(), birth, profileImg, nickName, introduction, major, studentNum, age, gender)
        }

        binding.imageViewImg1.setOnClickListener {
            profileImg = profileImages[7]
            if (binding.imageViewImg1Green.visibility == View.INVISIBLE) {
                if (binding.imageViewImg2Green.visibility == View.VISIBLE) {
                    binding.imageViewImg2Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg3Green.visibility == View.VISIBLE) {
                    binding.imageViewImg3Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg4Green.visibility == View.VISIBLE) {
                    binding.imageViewImg4Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg5Green.visibility == View.VISIBLE) {
                    binding.imageViewImg5Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg6Green.visibility == View.VISIBLE) {
                    binding.imageViewImg6Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg7Green.visibility == View.VISIBLE) {
                    binding.imageViewImg7Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg8Green.visibility == View.VISIBLE) {
                    binding.imageViewImg8Grey.visibility = android.view.View.VISIBLE
                }
                binding.imageViewImg1Green.visibility = View.VISIBLE
                binding.imageViewImg2Green.visibility = View.INVISIBLE
                binding.imageViewImg3Green.visibility = View.INVISIBLE
                binding.imageViewImg4Green.visibility = View.INVISIBLE
                binding.imageViewImg5Green.visibility = View.INVISIBLE
                binding.imageViewImg6Green.visibility = View.INVISIBLE
                binding.imageViewImg7Green.visibility = View.INVISIBLE
                binding.imageViewImg8Green.visibility = View.INVISIBLE
                binding.imageViewImg1Grey.visibility = View.INVISIBLE
            } else if (binding.imageViewImg1Green.visibility == View.VISIBLE){
                binding.imageViewImg1Green.visibility = View.INVISIBLE
                binding.imageViewImg1Grey.visibility = View.VISIBLE
                binding.imageViewImg2Grey.visibility = View.VISIBLE
                binding.imageViewImg3Grey.visibility = View.VISIBLE
                binding.imageViewImg4Grey.visibility = View.VISIBLE
                binding.imageViewImg5Grey.visibility = View.VISIBLE
                binding.imageViewImg6Grey.visibility = View.VISIBLE
                binding.imageViewImg7Grey.visibility = View.VISIBLE
                binding.imageViewImg8Grey.visibility = View.VISIBLE
            }
            checkOptions()
        }

        binding.imageViewImg2.setOnClickListener {
            profileImg = profileImages[4]
            if (binding.imageViewImg2Green.visibility == View.INVISIBLE) {
                if (binding.imageViewImg1Green.visibility == View.VISIBLE) {
                    binding.imageViewImg1Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg3Green.visibility == View.VISIBLE) {
                    binding.imageViewImg3Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg4Green.visibility == View.VISIBLE) {
                    binding.imageViewImg4Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg5Green.visibility == View.VISIBLE) {
                    binding.imageViewImg5Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg6Green.visibility == View.VISIBLE) {
                    binding.imageViewImg6Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg7Green.visibility == View.VISIBLE) {
                    binding.imageViewImg7Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg8Green.visibility == View.VISIBLE) {
                    binding.imageViewImg8Grey.visibility = android.view.View.VISIBLE
                }
                binding.imageViewImg2Green.visibility = View.VISIBLE
                binding.imageViewImg1Green.visibility = View.INVISIBLE
                binding.imageViewImg3Green.visibility = View.INVISIBLE
                binding.imageViewImg4Green.visibility = View.INVISIBLE
                binding.imageViewImg5Green.visibility = View.INVISIBLE
                binding.imageViewImg6Green.visibility = View.INVISIBLE
                binding.imageViewImg7Green.visibility = View.INVISIBLE
                binding.imageViewImg8Green.visibility = View.INVISIBLE
                binding.imageViewImg2Grey.visibility = View.INVISIBLE
            } else if (binding.imageViewImg2Green.visibility == View.VISIBLE){
                binding.imageViewImg2Green.visibility = View.INVISIBLE
                binding.imageViewImg2Grey.visibility = View.VISIBLE
                binding.imageViewImg1Grey.visibility = View.VISIBLE
                binding.imageViewImg3Grey.visibility = View.VISIBLE
                binding.imageViewImg4Grey.visibility = View.VISIBLE
                binding.imageViewImg5Grey.visibility = View.VISIBLE
                binding.imageViewImg6Grey.visibility = View.VISIBLE
                binding.imageViewImg7Grey.visibility = View.VISIBLE
                binding.imageViewImg8Grey.visibility = View.VISIBLE
            }
            checkOptions()
        }

        binding.imageViewImg3.setOnClickListener {
            profileImg = profileImages[0]
            if (binding.imageViewImg3Green.visibility == View.INVISIBLE) {
                if (binding.imageViewImg1Green.visibility == View.VISIBLE) {
                    binding.imageViewImg1Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg2Green.visibility == View.VISIBLE) {
                    binding.imageViewImg2Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg4Green.visibility == View.VISIBLE) {
                    binding.imageViewImg4Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg5Green.visibility == View.VISIBLE) {
                    binding.imageViewImg5Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg6Green.visibility == View.VISIBLE) {
                    binding.imageViewImg6Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg7Green.visibility == View.VISIBLE) {
                    binding.imageViewImg7Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg8Green.visibility == View.VISIBLE) {
                    binding.imageViewImg8Grey.visibility = android.view.View.VISIBLE
                }
                binding.imageViewImg3Green.visibility = View.VISIBLE
                binding.imageViewImg1Green.visibility = View.INVISIBLE
                binding.imageViewImg2Green.visibility = View.INVISIBLE
                binding.imageViewImg4Green.visibility = View.INVISIBLE
                binding.imageViewImg5Green.visibility = View.INVISIBLE
                binding.imageViewImg6Green.visibility = View.INVISIBLE
                binding.imageViewImg7Green.visibility = View.INVISIBLE
                binding.imageViewImg8Green.visibility = View.INVISIBLE
                binding.imageViewImg3Grey.visibility = View.INVISIBLE
            } else if (binding.imageViewImg3Green.visibility == View.VISIBLE){
                binding.imageViewImg3Green.visibility = View.INVISIBLE
                binding.imageViewImg3Grey.visibility = View.VISIBLE
                binding.imageViewImg2Grey.visibility = View.VISIBLE
                binding.imageViewImg1Grey.visibility = View.VISIBLE
                binding.imageViewImg4Grey.visibility = View.VISIBLE
                binding.imageViewImg5Grey.visibility = View.VISIBLE
                binding.imageViewImg6Grey.visibility = View.VISIBLE
                binding.imageViewImg7Grey.visibility = View.VISIBLE
                binding.imageViewImg8Grey.visibility = View.VISIBLE
            }
            checkOptions()
        }

        binding.imageViewImg4.setOnClickListener {
            profileImg = profileImages[3]
            if (binding.imageViewImg4Green.visibility == View.INVISIBLE) {
                if (binding.imageViewImg2Green.visibility == View.VISIBLE) {
                    binding.imageViewImg2Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg3Green.visibility == View.VISIBLE) {
                    binding.imageViewImg3Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg1Green.visibility == View.VISIBLE) {
                    binding.imageViewImg1Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg5Green.visibility == View.VISIBLE) {
                    binding.imageViewImg5Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg6Green.visibility == View.VISIBLE) {
                    binding.imageViewImg6Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg7Green.visibility == View.VISIBLE) {
                    binding.imageViewImg7Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg8Green.visibility == View.VISIBLE) {
                    binding.imageViewImg8Grey.visibility = android.view.View.VISIBLE
                }
                binding.imageViewImg4Green.visibility = View.VISIBLE
                binding.imageViewImg2Green.visibility = View.INVISIBLE
                binding.imageViewImg3Green.visibility = View.INVISIBLE
                binding.imageViewImg1Green.visibility = View.INVISIBLE
                binding.imageViewImg5Green.visibility = View.INVISIBLE
                binding.imageViewImg6Green.visibility = View.INVISIBLE
                binding.imageViewImg7Green.visibility = View.INVISIBLE
                binding.imageViewImg8Green.visibility = View.INVISIBLE
                binding.imageViewImg4Grey.visibility = View.INVISIBLE
            } else if (binding.imageViewImg4Green.visibility == View.VISIBLE){
                binding.imageViewImg4Green.visibility = View.INVISIBLE
                binding.imageViewImg4Grey.visibility = View.VISIBLE
                binding.imageViewImg2Grey.visibility = View.VISIBLE
                binding.imageViewImg3Grey.visibility = View.VISIBLE
                binding.imageViewImg1Grey.visibility = View.VISIBLE
                binding.imageViewImg5Grey.visibility = View.VISIBLE
                binding.imageViewImg6Grey.visibility = View.VISIBLE
                binding.imageViewImg7Grey.visibility = View.VISIBLE
                binding.imageViewImg8Grey.visibility = View.VISIBLE
            }
            checkOptions()
        }

        binding.imageViewImg5.setOnClickListener {
            profileImg = profileImages[1]
            if (binding.imageViewImg5Green.visibility == View.INVISIBLE) {
                if (binding.imageViewImg2Green.visibility == View.VISIBLE) {
                    binding.imageViewImg2Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg3Green.visibility == View.VISIBLE) {
                    binding.imageViewImg3Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg4Green.visibility == View.VISIBLE) {
                    binding.imageViewImg4Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg1Green.visibility == View.VISIBLE) {
                    binding.imageViewImg1Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg6Green.visibility == View.VISIBLE) {
                    binding.imageViewImg6Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg7Green.visibility == View.VISIBLE) {
                    binding.imageViewImg7Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg8Green.visibility == View.VISIBLE) {
                    binding.imageViewImg8Grey.visibility = android.view.View.VISIBLE
                }
                binding.imageViewImg5Green.visibility = View.VISIBLE
                binding.imageViewImg2Green.visibility = View.INVISIBLE
                binding.imageViewImg3Green.visibility = View.INVISIBLE
                binding.imageViewImg4Green.visibility = View.INVISIBLE
                binding.imageViewImg1Green.visibility = View.INVISIBLE
                binding.imageViewImg6Green.visibility = View.INVISIBLE
                binding.imageViewImg7Green.visibility = View.INVISIBLE
                binding.imageViewImg8Green.visibility = View.INVISIBLE
                binding.imageViewImg5Grey.visibility = View.INVISIBLE
            } else if (binding.imageViewImg5Green.visibility == View.VISIBLE){
                binding.imageViewImg5Green.visibility = View.INVISIBLE
                binding.imageViewImg5Grey.visibility = View.VISIBLE
                binding.imageViewImg2Grey.visibility = View.VISIBLE
                binding.imageViewImg3Grey.visibility = View.VISIBLE
                binding.imageViewImg4Grey.visibility = View.VISIBLE
                binding.imageViewImg1Grey.visibility = View.VISIBLE
                binding.imageViewImg6Grey.visibility = View.VISIBLE
                binding.imageViewImg7Grey.visibility = View.VISIBLE
                binding.imageViewImg8Grey.visibility = View.VISIBLE
            }
            checkOptions()
        }

        binding.imageViewImg6.setOnClickListener {
            profileImg = profileImages[2]
            if (binding.imageViewImg6Green.visibility == View.INVISIBLE) {
                if (binding.imageViewImg2Green.visibility == View.VISIBLE) {
                    binding.imageViewImg2Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg3Green.visibility == View.VISIBLE) {
                    binding.imageViewImg3Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg4Green.visibility == View.VISIBLE) {
                    binding.imageViewImg4Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg5Green.visibility == View.VISIBLE) {
                    binding.imageViewImg5Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg1Green.visibility == View.VISIBLE) {
                    binding.imageViewImg1Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg7Green.visibility == View.VISIBLE) {
                    binding.imageViewImg7Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg8Green.visibility == View.VISIBLE) {
                    binding.imageViewImg8Grey.visibility = android.view.View.VISIBLE
                }
                binding.imageViewImg6Green.visibility = View.VISIBLE
                binding.imageViewImg2Green.visibility = View.INVISIBLE
                binding.imageViewImg3Green.visibility = View.INVISIBLE
                binding.imageViewImg4Green.visibility = View.INVISIBLE
                binding.imageViewImg5Green.visibility = View.INVISIBLE
                binding.imageViewImg1Green.visibility = View.INVISIBLE
                binding.imageViewImg7Green.visibility = View.INVISIBLE
                binding.imageViewImg8Green.visibility = View.INVISIBLE
                binding.imageViewImg6Grey.visibility = View.INVISIBLE
            } else if (binding.imageViewImg6Green.visibility == View.VISIBLE){
                binding.imageViewImg6Green.visibility = View.INVISIBLE
                binding.imageViewImg6Grey.visibility = View.VISIBLE
                binding.imageViewImg2Grey.visibility = View.VISIBLE
                binding.imageViewImg3Grey.visibility = View.VISIBLE
                binding.imageViewImg4Grey.visibility = View.VISIBLE
                binding.imageViewImg5Grey.visibility = View.VISIBLE
                binding.imageViewImg1Grey.visibility = View.VISIBLE
                binding.imageViewImg7Grey.visibility = View.VISIBLE
                binding.imageViewImg8Grey.visibility = View.VISIBLE
            }
            checkOptions()
        }

        binding.imageViewImg7.setOnClickListener {
            profileImg = profileImages[5]
            if (binding.imageViewImg7Green.visibility == View.INVISIBLE) {
                if (binding.imageViewImg2Green.visibility == View.VISIBLE) {
                    binding.imageViewImg2Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg3Green.visibility == View.VISIBLE) {
                    binding.imageViewImg3Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg4Green.visibility == View.VISIBLE) {
                    binding.imageViewImg4Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg5Green.visibility == View.VISIBLE) {
                    binding.imageViewImg5Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg6Green.visibility == View.VISIBLE) {
                    binding.imageViewImg6Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg1Green.visibility == View.VISIBLE) {
                    binding.imageViewImg1Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg8Green.visibility == View.VISIBLE) {
                    binding.imageViewImg8Grey.visibility = android.view.View.VISIBLE
                }
                binding.imageViewImg7Green.visibility = View.VISIBLE
                binding.imageViewImg2Green.visibility = View.INVISIBLE
                binding.imageViewImg3Green.visibility = View.INVISIBLE
                binding.imageViewImg4Green.visibility = View.INVISIBLE
                binding.imageViewImg5Green.visibility = View.INVISIBLE
                binding.imageViewImg6Green.visibility = View.INVISIBLE
                binding.imageViewImg1Green.visibility = View.INVISIBLE
                binding.imageViewImg8Green.visibility = View.INVISIBLE
                binding.imageViewImg7Grey.visibility = View.INVISIBLE
            } else if (binding.imageViewImg7Green.visibility == View.VISIBLE){
                binding.imageViewImg7Green.visibility = View.INVISIBLE
                binding.imageViewImg7Grey.visibility = View.VISIBLE
                binding.imageViewImg2Grey.visibility = View.VISIBLE
                binding.imageViewImg3Grey.visibility = View.VISIBLE
                binding.imageViewImg4Grey.visibility = View.VISIBLE
                binding.imageViewImg5Grey.visibility = View.VISIBLE
                binding.imageViewImg6Grey.visibility = View.VISIBLE
                binding.imageViewImg1Grey.visibility = View.VISIBLE
                binding.imageViewImg8Grey.visibility = View.VISIBLE
            }
            checkOptions()
        }

        binding.imageViewImg8.setOnClickListener {
            profileImg = profileImages[6]
            if (binding.imageViewImg8Green.visibility == View.INVISIBLE) {
                if (binding.imageViewImg2Green.visibility == View.VISIBLE) {
                    binding.imageViewImg2Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg3Green.visibility == View.VISIBLE) {
                    binding.imageViewImg3Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg4Green.visibility == View.VISIBLE) {
                    binding.imageViewImg4Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg5Green.visibility == View.VISIBLE) {
                    binding.imageViewImg5Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg6Green.visibility == View.VISIBLE) {
                    binding.imageViewImg6Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg7Green.visibility == View.VISIBLE) {
                    binding.imageViewImg7Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewImg1Green.visibility == View.VISIBLE) {
                    binding.imageViewImg1Grey.visibility = android.view.View.VISIBLE
                }
                binding.imageViewImg8Green.visibility = View.VISIBLE
                binding.imageViewImg2Green.visibility = View.INVISIBLE
                binding.imageViewImg3Green.visibility = View.INVISIBLE
                binding.imageViewImg4Green.visibility = View.INVISIBLE
                binding.imageViewImg5Green.visibility = View.INVISIBLE
                binding.imageViewImg6Green.visibility = View.INVISIBLE
                binding.imageViewImg7Green.visibility = View.INVISIBLE
                binding.imageViewImg1Green.visibility = View.INVISIBLE
                binding.imageViewImg8Grey.visibility = View.INVISIBLE
            } else if (binding.imageViewImg8Green.visibility == View.VISIBLE){
                binding.imageViewImg8Green.visibility = View.INVISIBLE
                binding.imageViewImg8Grey.visibility = View.VISIBLE
                binding.imageViewImg2Grey.visibility = View.VISIBLE
                binding.imageViewImg3Grey.visibility = View.VISIBLE
                binding.imageViewImg4Grey.visibility = View.VISIBLE
                binding.imageViewImg5Grey.visibility = View.VISIBLE
                binding.imageViewImg6Grey.visibility = View.VISIBLE
                binding.imageViewImg7Grey.visibility = View.VISIBLE
                binding.imageViewImg1Grey.visibility = View.VISIBLE
            }
            checkOptions()
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    private fun checkOptions() {

    }

    // 프로필 이미지 받아오기
    private fun getProfileImages() {
        val profileImagesService = ProfileImagesService()
        profileImagesService.setProfileImagesView(this)
        profileImagesService.getProfileImages()
    }
    override fun onProfileImagesSuccess(data: ArrayList<String>) {
        Toast.makeText(mainActivity, "프로필 이미지 목록 조회에 성공했습니다.", Toast.LENGTH_SHORT).show()
        profileImages = data
        Log.d("PROFILE_IMAGES", profileImages.toString())
    }
    override fun onProfileImagesFailure() {
        Toast.makeText(mainActivity, "프로필 이미지 목록 조회에 실패했습니다.", Toast.LENGTH_SHORT).show()
    }
}