package com.example.projetointegrador.ui.options.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentOptionsViewBinding

class OptionsViewFragment : Fragment() {
    private lateinit var binding: FragmentOptionsViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOptionsViewBinding.inflate(layoutInflater,container,false)

        binding.btnNewClaim.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_optionsViewFragment_to_lightPoleListFragment)
        }
        binding.btnList.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_optionsViewFragment_to_itemListFragment)
        }
        binding.tvLogOut.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_optionsViewFragment_to_homeActivity)
        }
        return binding.root
    }

}