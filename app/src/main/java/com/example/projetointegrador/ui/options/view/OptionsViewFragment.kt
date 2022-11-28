package com.example.projetointegrador.ui.options.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentOptionsViewBinding
import com.example.projetointegrador.ui.home.view.HomeActivity

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
            val intent = Intent(this.context, HomeActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

}