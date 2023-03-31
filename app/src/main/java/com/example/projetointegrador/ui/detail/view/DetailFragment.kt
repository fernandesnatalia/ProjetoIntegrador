package com.example.projetointegrador.ui.detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projetointegrador.R
import com.example.projetointegrador.data.model.LightPole
import com.example.projetointegrador.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        receivedData()
        return binding.root
    }
    private fun receivedData(){
        val lightPole = arguments?.getParcelable<LightPole>("KEY" )
        if(lightPole != null) {
            view(lightPole)
        }else{
            Toast.makeText(this.context, "${R.string.op_failed}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun view(lightPole: LightPole){
        binding.btnCodeLightCode.text = lightPole.code
        binding.btnCodeLightCity.text = lightPole.city
        binding.btnCodeLightStreet.text = lightPole.street
        binding.btnbtnCodeLightNeighborhood.text = lightPole.neighborhood
        binding.btnDescription.text = lightPole.description
    }
}