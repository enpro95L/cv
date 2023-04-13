package com.powersoft.curriculumvitae.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.powersoft.curriculumvitae.databinding.ContactListBinding

import com.powersoft.curriculumvitae.models.Contact

class ContactAdapter (private val contactList: List<Contact>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(val binding: ContactListBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactAdapter.ContactViewHolder {
        return ContactViewHolder(ContactListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ContactAdapter.ContactViewHolder, position: Int) {
        val contact = contactList[position]

        with (holder.binding) {
            with (contact) {
                ivIcon.setImageResource(icon)
                tvTitle.text = title
                tvContent.text = content
            }
        }
    }

    override fun getItemCount(): Int  = contactList.size
}