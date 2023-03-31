package com.example.projetointegrador.ui.register.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentRegisterBinding
import com.example.projetointegrador.domain.model.User
import com.example.projetointegrador.ui.register.viewmodel.RegisterViewModel

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: RegisterViewModel
    private lateinit var factory: RegisterViewModel.RegisterViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        factory = RegisterViewModel.RegisterViewModelFactory()
        viewModel = ViewModelProvider(this,factory).get(RegisterViewModel::class.java)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        register()
    }

    private fun getData():User{
        return User(name = binding.etUsername.text.toString(),
            cpf = binding.etCPFNumber.text.toString(),
            phone = binding.etPhoneNumber.text.toString(),
            email = binding.etEmail.text.toString(),
            password = binding.etPassword.text.toString()
        )
    }
    private fun register() {
        val user = getData()
        viewModel.validateData(user)
        binding.btnRegister.setOnClickListener {
            val bundle = bundleOf("USER" to user)
            NavHostFragment.findNavController(this).navigate(R.id.action_registerFragment_to_optionsViewFragment, bundle)
        }
    }
}