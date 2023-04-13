package com.powersoft.curriculumvitae.repositories

import com.powersoft.curriculumvitae.R
import com.powersoft.curriculumvitae.models.Experience

class ExperienceRepo {
    companion object {
        fun getData(): List<Experience> {
            return listOf(
                Experience(R.drawable.beacon, "BeaconFire Inc.", "Senior Mobile Developer - Android", "Feb 2023 - Present"),
                Experience(R.drawable.paylocity, "Paylocity", "Principal Mobile Developer", "Aug 2022 - Feb 2023"),
                Experience(R.drawable.kforce, "Kforce", "Senior Android Developer", "Jul 2019 - Aug 2021"),
                Experience(R.drawable.google, "Google Inc.", "Software Engineer", "Apr 2016 - Jan 2019")
            )
        }
    }
}