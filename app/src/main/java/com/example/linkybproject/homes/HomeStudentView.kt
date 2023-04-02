package com.example.linkybproject.homes

interface HomeStudentView {
    fun onHomeStudentListSuccess(homeStudentList: HomeStudentResponse)
    fun onGetHomeStudentListFailure()
}
