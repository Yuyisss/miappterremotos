package com.example.miappterremotos

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.miappterremotos.databinding.EqListItemBinding

class EqAdapter : ListAdapter<Terremoto, EqAdapter.EqViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Terremoto>() {
        override fun areItemsTheSame(oldItem: Terremoto, newItem: Terremoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Terremoto, newItem: Terremoto): Boolean {
            return oldItem == newItem
        }
    }

    lateinit var onItemClickListener: (Terremoto) -> Unit
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EqAdapter.EqViewHolder {
        val binding = EqListItemBinding.inflate(LayoutInflater.from(parent.context))
        return EqViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EqAdapter.EqViewHolder, position: Int) {
        val eq = getItem(position)
        holder.bind(eq)
    }

    inner class EqViewHolder(private val binding: EqListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(eq: Terremoto) {
            binding.eqMagnitudeText.text = eq.magnitude.toString()
            binding.eqPlaceText.text = eq.place
            binding.root.setOnClickListener {
                if (::onItemClickListener.isInitialized){
                    onItemClickListener(eq)
                }else{
                    Log.e("EqAdapter","onItemClickListiener not inicialized")
                }
            }
        }
    }
}
