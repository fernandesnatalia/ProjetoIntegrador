package com.example.projetointegrador.ui.userData.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegrador.R
import com.example.projetointegrador.data.model.LightPole
import com.example.projetointegrador.databinding.FragmentUserDataBinding
import com.example.projetointegrador.domain.model.User

class UserDataFragment : Fragment() {
    private lateinit var binding: FragmentUserDataBinding
    private lateinit var lightPole: LightPole

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

    private fun registration(): User{
        val name = binding.etUsername.text.toString()
        val email = binding.etEmail.text.toString()
        lightPole.description = binding.etDescription.text.toString()
        return User(name, email)
    }

    private fun received(): LightPole {
        this.lightPole = arguments?.getParcelable("KEY")!!
        return lightPole
    }

    private fun flow() {
        val data = received()
        val user = registration()

        data.code = binding.btnCodeLightCode.text.toString()

        val bundle = bundleOf("lightpole" to data, "user" to user)
        NavHostFragment.findNavController(this).navigate(R.id.action_userDataFragment_to_endFragment, bundle)
    }
}