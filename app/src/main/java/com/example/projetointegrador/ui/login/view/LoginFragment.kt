package com.example.projetointegrador.ui.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentLoginBinding
import com.example.projetointegrador.domain.model.User
import com.example.projetointegrador.domain.viewstate.Status
import com.example.projetointegrador.ui.login.viewmodel.LoginViewModel
import com.example.projetointegrador.utilities.EMAIL
import com.example.projetointegrador.utilities.NAME
import com.example.projetointegrador.utilities.PASSWORD
import com.example.projetointegrador.utilities.REQUIRED

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var factory:LoginViewModel.LoginViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        factory = LoginViewModel.LoginViewModelFactory()
        viewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvRegister.setOnClickListener{
            goToRegister()
        }

        viewModel.data.observe(viewLifecycleOwner, Observer{
            when(it.status){
                Status.SUCCESS -> {
                    val user = validate()
                    if (user != null) {
                        viewModel.login(user)
                        val bundle = bundleOf("USER" to user)
                        NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_optionsViewFragment, bundle)
                    }
                }
                Status.ERROR -> {
                    Toast.makeText(context,"${R.string.op_failed}}", Toast.LENGTH_LONG).show()
                }
                else -> {}
            }
        })
    }

    private fun validate(): User? {
        if (binding.etEmail.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()) {
            return User(email = EMAIL, password = PASSWORD)
        } else {
            binding.etEmail.error = REQUIRED
            binding.etPassword.error = REQUIRED
            return null
        }
    }

    private fun goToRegister(){
        NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_registerFragment)
    }
}