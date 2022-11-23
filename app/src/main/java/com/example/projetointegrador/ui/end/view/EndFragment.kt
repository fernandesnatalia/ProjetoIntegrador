package com.example.projetointegrador.ui.end.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentEndBinding

class EndFragment : Fragment() {
    private lateinit var binding: FragmentEndBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentEndBinding.inflate(layoutInflater,container,false)

        binding.btnFinish.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_endFragment_to_homeFragment)
        }
        return binding.root
    }
}