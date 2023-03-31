package com.example.projetointegrador.ui.itemList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegrador.data.model.LightPole
import com.example.projetointegrador.databinding.LightpoleItemBinding

class ItemPoleListAdapter (
    private var list: List<LightPole>,
    private val clickDetail: (lightPole: LightPole) -> Unit
    ) : RecyclerView.Adapter<ItemPoleListAdapter.ViewHolder>(){

        class ViewHolder(val binding: LightpoleItemBinding) : RecyclerView.ViewHolder(binding.root) {
            fun showInfo(lightPole: LightPole){
                binding.tvCodeOfItem.text = lightPole.code
                binding.tvStreetOfItem.text = lightPole.street
                binding.tvNeigOfItem.text = lightPole.neighborhood
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = LightpoleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = list[position]
            holder.showInfo(item)
            holder.binding.item.setOnClickListener{
                clickDetail(item)
            }
        }

        override fun getItemCount() = list.size

        fun updateList(newList:MutableList<LightPole>){
            list = newList
            notifyDataSetChanged()
        }
}
