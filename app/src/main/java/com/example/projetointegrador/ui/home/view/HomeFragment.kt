package com.example.projetointegrador.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.btnProblems.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_homeFragment_to_lightPoleListFragment)
        }

        binding.btnAdministrative.setOnClickListener {
            Toast.makeText(this.context,"Em manutenção", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}