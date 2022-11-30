package com.example.projetointegrador.ui.itemList.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetointegrador.R
import com.example.projetointegrador.data.model.LightPole
import com.example.projetointegrador.databinding.FragmentItemListBinding
import com.example.projetointegrador.domain.viewstate.Status
import com.example.projetointegrador.ui.itemList.adapter.ItemPoleListAdapter
import com.example.projetointegrador.ui.itemList.viewmodel.ItemListViewModel

class ItemListFragment : Fragment() {
    private lateinit var binding:  FragmentItemListBinding
    private lateinit var viewModel: ItemListViewModel
    private lateinit var factory:ItemListViewModel.ItemListViewModelFactory
    private val adapter: ItemPoleListAdapter by lazy { ItemPoleListAdapter(arrayListOf(), this::goToDetail) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemListBinding.inflate(layoutInflater, container, false)
        factory = ItemListViewModel.ItemListViewModelFactory()
        viewModel = ViewModelProvider(this,factory)[ItemListViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getList()

        viewModel.list.observe(viewLifecycleOwner, Observer{
            when(it.status){
                Status.EMPTY -> {
                    binding.ivEmptyList.setImageResource(R.drawable.empty_list)
                    binding.ivEmptyList.isVisible = true
                    binding.tvEmptyList.isVisible = true
                    binding.pbLoading.isVisible = false
                }
                Status.SUCCESS -> {
                    binding.rvList.adapter = adapter
                    binding.rvList.layoutManager = LinearLayoutManager(context)
                    adapter.updateList(it.data as MutableList<LightPole>)
                    binding.rvList.isVisible = true
                    binding.pbLoading.isVisible = false
                }
                Status.LOADING -> {
                    binding.pbLoading.isVisible = true
                    binding.rvList.isVisible = false
                }
                Status.ERROR -> {
                    Toast.makeText( context,"${R.string.op_failed}", Toast.LENGTH_LONG).show()
                    binding.pbLoading.isVisible = false
                    binding.rvList.isVisible = false
                }
            }
        })
    }

    fun goToDetail(item: LightPole){
        val bundle = bundleOf("DETAIL" to item)
        NavHostFragment.findNavController(this).navigate(R.id.action_itemListFragment_to_detailFragment,bundle)
    }

}