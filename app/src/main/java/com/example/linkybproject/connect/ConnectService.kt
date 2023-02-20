package com.example.linkybproject.connect

import android.util.Log
import com.example.linkybproject.getRetrofit
import javax.security.auth.callback.Callback

class ConnectService {
    private lateinit var matchingListView: MatchingListView

    fun setMatchingListView(matchingListView: MatchingListView) {
        this.matchingListView = matchingListView
    }

    fun matchingList(authorization: String) {
        val matchingListService = getRetrofit().create(MatchingListInterface::class.java)

/*
        matchingListService.showMatchingList(authorization).enqueue(object : Callback<MatchingListResponse>) {

        }
*/
    }
}