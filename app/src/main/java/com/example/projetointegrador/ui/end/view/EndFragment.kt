package com.example.projetointegrador.ui.end.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetointegrador.databinding.FragmentEndBinding

class EndFragment : Fragment() {
    private lateinit var binding: FragmentEndBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentEndBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}