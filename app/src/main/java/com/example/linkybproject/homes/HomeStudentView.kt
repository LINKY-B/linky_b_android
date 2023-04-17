package com.example.linkybproject.homes

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

//홈 유저 매칭시도
interface HomeConnectTryView{
    fun onHomeConnectTrySuccess(homeConnectResponse: HomeConnectResponse)
    fun onGetHomeConnectTryFailure()
}