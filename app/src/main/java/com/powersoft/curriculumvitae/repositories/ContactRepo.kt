package com.powersoft.curriculumvitae.repositories

import com.powersoft.curriculumvitae.R
import com.powersoft.curriculumvitae.models.Contact

class ContactRepo {
    companion object {
        fun getData(): List<Contact>{
            return listOf(
                Contact(R.drawable.linkedin, "LinkedIn Profile", "linkedin.com/in/derrick-siayor-1a266410b"),
                Contact(R.drawable.ic_phone, "Phone", "+1 641 233 9811"),
                Contact(R.drawable.ic_location, "Address", "Fairfield, IA, USA"),
                Contact(R.drawable.ic_email, "Email", "derrickkorku1@gmail.com"),
            )
        }
    }
}