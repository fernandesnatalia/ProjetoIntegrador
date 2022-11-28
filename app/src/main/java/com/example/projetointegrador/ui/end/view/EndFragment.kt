package com.example.projetointegrador.ui.end.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetointegrador.databinding.FragmentEndBinding
import com.example.projetointegrador.ui.home.view.HomeActivity

class EndFragment : Fragment() {
    private lateinit var binding: FragmentEndBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentEndBinding.inflate(layoutInflater,container,false)

        binding.btnFinish.setOnClickListener {
            val intent = Intent(this.context, HomeActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }
}