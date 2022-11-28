package com.example.projetointegrador.ui.userData.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentUserDataBinding
import com.example.projetointegrador.domain.model.LightPole
import com.example.projetointegrador.domain.model.User
import com.example.projetointegrador.ui.home.view.HomeActivity

class UserDataFragment : Fragment() {
    private lateinit var binding: FragmentUserDataBinding
    private lateinit var lightPole: LightPole
    private lateinit var user: User
    private lateinit var description: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDataBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSendUserData.setOnClickListener{
            flow()
        }
        binding.btnCancelUserData.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_userDataFragment_to_homeActivity)
        }
    }

    private fun registration(){
        val name = binding.etUsername.text.toString()
        val email = binding.etEmail.text.toString()
        this.description = binding.etDescription.text.toString()
        this.user = User(name, email)
    }

    private fun received(){
        this.lightPole = arguments?.getParcelable("KEY")!!
        binding.btnCodeLightCode.text = lightPole.code
    }

    private fun flow() {
        received()
        registration()
        val bundle = bundleOf("description" to description, "lightpole" to lightPole, "user" to user)
        NavHostFragment.findNavController(this).navigate(R.id.action_userDataFragment_to_endFragment, bundle)
    }
}