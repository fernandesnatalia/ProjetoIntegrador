package com.example.projetointegrador.ui.itemList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegrador.databinding.LightpoleItemBinding
import com.example.projetointegrador.domain.model.LightPole

class LightPoleListAdapter (
    private var items: List<LightPole>,
    private val clickDetail: (item:LightPole) -> Unit
) :
    RecyclerView.Adapter<LightPoleListAdapter.ViewHolder>(){

    class ViewHolder(val binding: LightpoleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun showInfo(item:LightPole){
            binding.tvCodeOfItem.text = item.code
            binding.tvStreetOfItem.text = item.street
            binding.tvNeigOfItem.text = item.neighborhood
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LightpoleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.showInfo(item)

        holder.binding.item.setOnClickListener{
            clickDetail(item)
        }
    }

    override fun getItemCount() = items.size

    fun updateList(newList:MutableList<LightPole>){
        items = newList
        notifyDataSetChanged()
    }
}