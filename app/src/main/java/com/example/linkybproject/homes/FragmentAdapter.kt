package com.example.linkybproject.homes

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_PAGES = 2

class FragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeStudentFragment()
            1 -> HomeGraudateFragment()
            else -> HomeStudentFragment()
        }
    }
}