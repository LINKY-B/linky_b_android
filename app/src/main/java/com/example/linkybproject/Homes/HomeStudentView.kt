package com.example.linkybproject.Homes

//재학생
interface HomeStudentView {
    fun onHomeStudentListSuccess(homeStudentList: HomeStudentResponse)
    fun onGetHomeStudentListFailure()
}

//졸업생
interface HomeGraduateView {
    fun onHomeGraduateListSuccess(homeGraduateList: HomeGraduateResponse)
    fun onGetHomeGraduateListFailure()
}

//홈 화면 프로필 조회
interface HomeProfileView {
    fun onHomeProfileSuccess(homeProfileResponse: HomeProfileResponse)
    fun onGetHomeProfileFailure()
}
