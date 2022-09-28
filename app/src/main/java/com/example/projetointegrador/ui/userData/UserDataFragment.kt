package com.example.projetointegrador.ui.userData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetointegrador.databinding.FragmentUserDataBinding

class UserDataFragment : Fragment() {
    private lateinit var binding: FragmentUserDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDataBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}