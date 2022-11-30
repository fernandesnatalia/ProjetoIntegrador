package com.example.projetointegrador.ui.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentLoginBinding
import com.example.projetointegrador.domain.model.User
import com.example.projetointegrador.domain.viewstate.Status
import com.example.projetointegrador.ui.login.viewmodel.LoginViewModel
import com.example.projetointegrador.utilities.EMAIL
import com.example.projetointegrador.utilities.PASSWORD
import com.example.projetointegrador.utilities.REQUIRED

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var factory:LoginViewModel.LoginViewModelFactory
    private var user = User()

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

        binding.btnLogin.setOnClickListener {
            validate()
            viewModel.login(this.user)
        }

        viewModel.data.observe(viewLifecycleOwner, Observer{
            when(it.status){
                Status.SUCCESS -> {
                    val bundle = bundleOf("USER" to user)
                    NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_optionsViewFragment, bundle)
                }
                Status.ERROR -> {
                    Toast.makeText(context,"${R.string.op_failed}}", Toast.LENGTH_LONG).show()
                }
                else -> {}
            }
        })
    }

    private fun validate(){
        if (binding.etEmail.text.isNullOrEmpty() && binding.etPassword.text.isNullOrEmpty()) {
            binding.etEmail.error = REQUIRED
            binding.etPassword.error = REQUIRED
        } else {
            binding.etEmail.error = REQUIRED
            binding.etPassword.error = REQUIRED
            this.user = User(email = EMAIL, password = PASSWORD)
        }
    }

    private fun goToRegister(){
        NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_registerFragment)
    }
}