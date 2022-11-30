package com.example.projetointegrador.ui.options.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentOptionsViewBinding
import com.example.projetointegrador.ui.options.viewmodel.OptionsViewFragmentViewModel

class OptionsViewFragment : Fragment() {
    private lateinit var binding: FragmentOptionsViewBinding
    private lateinit var viewModel: OptionsViewFragmentViewModel
    private lateinit var factory: OptionsViewFragmentViewModel.OptionsViewFragmentViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOptionsViewBinding.inflate(layoutInflater, container, false)
        factory = OptionsViewFragmentViewModel.OptionsViewFragmentViewModelFactory()
        viewModel = ViewModelProvider(this, factory)[OptionsViewFragmentViewModel::class.java]
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getName()
        buttonsFlow()
    }

    private fun buttonsFlow(){
        binding.btnNewClaim.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_optionsViewFragment_to_lightPoleListFragment)
        }
        binding.btnList.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_optionsViewFragment_to_itemListFragment)
        }
        binding.tvLogOut.setOnClickListener {
            viewModel.logout()
            NavHostFragment.findNavController(this).navigate(R.id.action_optionsViewFragment_to_homeActivity)
        }
    }
    private fun getName():String{
        val name = viewModel.getName()
        val hello = R.string.hello
        val insertion =  binding.btnUserName.text

        return hello.toString() + name + insertion.toString()
    }
}