package com.powersoft.curriculumvitae.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.powersoft.curriculumvitae.fragments.AboutFragment
import com.powersoft.curriculumvitae.fragments.ContactFragment
import com.powersoft.curriculumvitae.fragments.ExperienceFragment
import com.powersoft.curriculumvitae.fragments.HomeFragment

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> AboutFragment()
            2 -> ExperienceFragment()
            else -> ContactFragment()
        }
    }
}