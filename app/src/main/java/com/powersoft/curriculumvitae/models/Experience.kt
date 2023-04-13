package com.powersoft.curriculumvitae.models

import androidx.annotation.DrawableRes

data class Experience(
    @DrawableRes val icon: Int,
    val companyName: String,
    val title: String,
    val workDuration: String
) : java.io.Serializable
