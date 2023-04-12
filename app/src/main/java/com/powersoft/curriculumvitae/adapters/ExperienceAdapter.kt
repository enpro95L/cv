package com.powersoft.curriculumvitae.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.powersoft.curriculumvitae.databinding.ItemExperienceBinding
import com.powersoft.curriculumvitae.models.Experience

class ExperienceAdapter(private val experienceList: ArrayList<Experience>): RecyclerView.Adapter<ExperienceAdapter.Holder>() {

    inner class Holder(val binding: ItemExperienceBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemExperienceBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.imgLogo.setImageResource(experienceList[position].icon)
        holder.binding.tvCompanyName.text = experienceList[position].companyName
        holder.binding.tvTitle.text = experienceList[position].title
        holder.binding.tvWorkDuration.text = experienceList[position].workDuration
    }

    override fun getItemCount() = experienceList.size
}