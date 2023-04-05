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
