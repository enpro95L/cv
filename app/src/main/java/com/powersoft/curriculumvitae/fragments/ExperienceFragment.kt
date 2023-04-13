package com.powersoft.curriculumvitae.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.powersoft.curriculumvitae.AddExperienceActivity
import com.powersoft.curriculumvitae.R
import com.powersoft.curriculumvitae.adapters.ExperienceAdapter
import com.powersoft.curriculumvitae.databinding.FragmentExperienceBinding
import com.powersoft.curriculumvitae.models.Experience
import com.powersoft.curriculumvitae.repositories.ExperienceRepo

class ExperienceFragment : Fragment() {

    private lateinit var binding: FragmentExperienceBinding
    private lateinit var experienceList: ArrayList<Experience>
    private lateinit var adapter: ExperienceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExperienceBinding.bind(
            inflater.inflate(
                R.layout.fragment_experience,
                container,
                false
            )
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        experienceList = ArrayList(ExperienceRepo.getData())

        adapter = ExperienceAdapter(experienceList)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        val contract =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == AppCompatActivity.RESULT_OK) {
                    val exp = it.data?.getSerializableExtra("experience") as Experience
                    experienceList.add(exp)
                    adapter.notifyItemChanged(experienceList.size)
                } else if (it.resultCode == AppCompatActivity.RESULT_CANCELED) {
                    Toast.makeText(requireActivity(), "Cancelled by User", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        binding.fabAdd.setOnClickListener {
            contract.launch(Intent(requireActivity(), AddExperienceActivity::class.java))
        }
    }
}