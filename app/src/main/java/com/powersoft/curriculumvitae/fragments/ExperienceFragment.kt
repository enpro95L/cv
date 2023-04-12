package com.powersoft.curriculumvitae.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.powersoft.curriculumvitae.R
import com.powersoft.curriculumvitae.adapters.ExperienceAdapter
import com.powersoft.curriculumvitae.databinding.FragmentExperienceBinding
import com.powersoft.curriculumvitae.models.Experience

class ExperienceFragment: Fragment(){

    private lateinit var binding: FragmentExperienceBinding
    private lateinit var experienceList: ArrayList<Experience>
    private lateinit var adapter: ExperienceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExperienceBinding.bind(inflater.inflate(R.layout.fragment_experience, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        experienceList = ArrayList()
        experienceList.add(Experience(R.drawable.beacon, "BeaconFire Inc.", "Senior Mobile Developer - Android", "Feb 2023 - Present"))
        experienceList.add(Experience(R.drawable.paylocity, "Paylocity", "Principal Mobile Developer", "Aug 2022 - Feb 2023"))
        experienceList.add(Experience(R.drawable.kforce, "Kforce", "Senior Android Developer", "Jul 2019 - Aug 2021"))
        experienceList.add(Experience(R.drawable.google, "Google Inc.", "Software Engineer", "Apr 2016 - Jan 2019"))

        adapter = ExperienceAdapter(experienceList)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        binding.fabAdd.setOnClickListener{
            experienceList.add(Experience(R.drawable.addison, "Addison Group", "Mobile Application Developer", "Feb 2023 - Present"))
            adapter.notifyItemChanged(experienceList.size)
        }
    }
}