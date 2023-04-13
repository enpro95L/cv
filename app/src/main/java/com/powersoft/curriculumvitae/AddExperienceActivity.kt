package com.powersoft.curriculumvitae

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.powersoft.curriculumvitae.databinding.ActivityAddExperienceBinding
import com.powersoft.curriculumvitae.models.Experience

class AddExperienceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddExperienceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddExperienceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBack.setOnClickListener { super.onBackPressed() }

        binding.btnAddExperience.setOnClickListener {
            if (!validate()) return@setOnClickListener

            val companyName = binding.etCompany.text.toString()
            val title = binding.etTitle.text.toString()
            val workDuration = binding.etWorkDuration.text.toString()

            val experience = Experience(R.drawable.addison, companyName, title, workDuration)

            val intent = Intent()
            intent.putExtra("experience", experience)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    private fun validate(): Boolean {
        if (binding.etCompany.text.isEmpty()) {
            binding.etCompany.error = "Company Name is required!!"
            binding.etCompany.requestFocus()
            return false
        } else if (binding.etTitle.text.isEmpty()) {
            binding.etTitle.error = "Position/Title is required!!"
            binding.etTitle.requestFocus()
            return false
        } else if (binding.etWorkDuration.text.isEmpty()) {
            binding.etWorkDuration.error = "Work Duration is required!!"
            binding.etWorkDuration.requestFocus()
            return false
        }
        return true
    }
}