package com.example.projetointegrador.ui.confirmation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentConfirmationBinding
import com.example.projetointegrador.domain.model.LightPole
import com.example.projetointegrador.ui.const.*

class ConfirmationFragment : Fragment() {
    private lateinit var binding: FragmentConfirmationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfirmationBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        receivedData()
    }

    private fun receivedData(){
        val lightPole = arguments?.getParcelable<LightPole>("KEY" )
        if(lightPole != null) {
            confirmationView(lightPole)
            poleLightView(lightPole)
        }else{
            Toast.makeText(this.context,"Escapei", Toast.LENGTH_SHORT).show()
        }
    }

    private fun poleLightView(lightPole: LightPole){
        binding.btnCodeLightCode.text = lightPole.code
        binding.btnCodeLightStreet.text = lightPole.street
        binding.btnCodeLightCity.text = lightPole.city
        binding.btnbtnCodeLightNeighborhood.text = lightPole.neighborhood
    }

    private fun confirmationView(lightPole: LightPole){
        binding.btnYes.setOnClickListener{
            val bundle = bundleOf("KEY"  to lightPole)
            NavHostFragment.findNavController(this).navigate(R.id.action_confirmationFragment_to_userDataFragment, bundle)
        }
        binding.btnNo.setOnClickListener{
            NavHostFragment.findNavController(this).navigate(R.id.action_confirmationFragment_to_lightPoleListFragment)
        }
    }
}