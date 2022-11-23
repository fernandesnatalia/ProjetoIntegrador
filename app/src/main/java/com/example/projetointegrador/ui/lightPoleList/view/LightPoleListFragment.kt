package com.example.projetointegrador.ui.lightPoleList.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentLightPoleListBinding
import com.example.projetointegrador.domain.model.LightPole
import com.example.projetointegrador.ui.const.*

class LightPoleListFragment : Fragment() {
    private lateinit var binding: FragmentLightPoleListBinding
    private lateinit var lightPole: LightPole

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLightPoleListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnFlow()
    }

    private fun btnFlow(){
        binding.btnLightPole1.setOnClickListener {
            lightPole = LightPole(POLECODE1, POlESTREET1, POLENEIG1, CITY)
            val bundle = bundleOf("KEY" to lightPole)
            NavHostFragment.findNavController(this).navigate(R.id.action_lightPoleListFragment_to_confirmationFragment, bundle)
        }
        binding.btnLightPole2.setOnClickListener {
            lightPole = LightPole(POLECODE2, POlESTREET2, POLENEIG2, CITY)
            val bundle = bundleOf("KEY"  to lightPole)
            NavHostFragment.findNavController(this).navigate(R.id.action_lightPoleListFragment_to_confirmationFragment, bundle)
        }
        binding.btnLightPole3.setOnClickListener {
            lightPole = LightPole(POLECODE3, POlESTREET3, POLENEIG3, CITY)
            val bundle = bundleOf("KEY"  to lightPole)
            NavHostFragment.findNavController(this).navigate(R.id.action_lightPoleListFragment_to_confirmationFragment, bundle)
        }
        binding.btnLightPole4.setOnClickListener {
            lightPole = LightPole(POLECODE4, POlESTREET4, POLENEIG4, CITY)
            val bundle = bundleOf("KEY"  to lightPole)
            NavHostFragment.findNavController(this).navigate(R.id.action_lightPoleListFragment_to_confirmationFragment, bundle)
        }
        binding.btnLightPole5.setOnClickListener {
            lightPole = LightPole(POLECODE5, POlESTREET5, POLENEIG5, CITY)
            val bundle = bundleOf("KEY"  to lightPole)
            NavHostFragment.findNavController(this).navigate(R.id.action_lightPoleListFragment_to_confirmationFragment, bundle)
        }
        binding.btnLightPole6.setOnClickListener {
            lightPole = LightPole(POLECODE6, POlESTREET6, POLENEIG6, CITY)
            val bundle = bundleOf("KEY"  to lightPole)
            NavHostFragment.findNavController(this).navigate(R.id.action_lightPoleListFragment_to_confirmationFragment, bundle)
        }
    }
}