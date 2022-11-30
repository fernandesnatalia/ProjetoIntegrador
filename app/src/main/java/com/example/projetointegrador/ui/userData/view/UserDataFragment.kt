package com.example.projetointegrador.ui.userData.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegrador.R
import com.example.projetointegrador.data.model.LightPole
import com.example.projetointegrador.databinding.FragmentUserDataBinding
import com.example.projetointegrador.ui.userData.viewmodel.UserDataViewModel

class UserDataFragment : Fragment() {
    private lateinit var binding: FragmentUserDataBinding
    private lateinit var viewModel: UserDataViewModel
    private lateinit var factory: UserDataViewModel.UserDataViewModelFactory
    private lateinit var lightPole: LightPole

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDataBinding.inflate(layoutInflater,container,false)
        factory = UserDataViewModel.UserDataViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(UserDataViewModel::class.java)
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
        lightPole.description = binding.etDescription.text.toString()
        binding.btnCodeLightCode.text = lightPole.code
    }

    private fun received(): LightPole {
        lightPole = arguments?.getParcelable("KEY")!!
        return lightPole
    }

    private fun flow() {
        received()
        registration()
        viewModel.insertToDatabase(lightPole)
        NavHostFragment.findNavController(this).navigate(R.id.action_userDataFragment_to_endFragment)
    }
}