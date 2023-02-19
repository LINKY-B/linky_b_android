package com.example.linkybproject.connect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.databinding.ItemMyprofilePersonalBinding

class ProfileCharacterAdapter: RecyclerView.Adapter<ProfileCharacterAdapter.ViewHolder>() {
    var datalist = mutableListOf<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = com.example.linkybproject.databinding.ItemMyprofilePersonalBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
    }

    inner class ViewHolder(private val binding: ItemMyprofilePersonalBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            binding.textViewItemMyProfilePersonal.text = character.character
        }
    }

}