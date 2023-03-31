package com.example.projetointegrador.ui.register.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.model.User
import com.example.projetointegrador.domain.repository.AuthenticatonRepository
import com.example.projetointegrador.domain.singleliveevent.SingleLiveEvent
import com.example.projetointegrador.domain.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel:ViewModel() {
    private val repository = AuthenticatonRepository()
    var data = SingleLiveEvent<ViewState<User>>()

    fun validateData(user: User) {
        viewModelScope.launch {
            try {
                val withContext = withContext(Dispatchers.Default) {
                    if(user.name.isNotEmpty() && user.cpf.isNotEmpty() &&
                        user.email.isNotEmpty() && user.password.isNotEmpty() && user.phone.isNotEmpty()){
                    registerUser(User(user.name, user.cpf, user.phone, user.email,user.password))
                    repository.updateProfile(user.name)
                    }
                }
                withContext.let {
                    data.value = ViewState.success(user)
                }
            } catch (e: Exception) {
                data.value = ViewState.error(null, "${R.string.op_failed}}")
            }
        }
    }

    private fun registerUser(user: User) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                repository.register(
                    user.email,
                    user.password
                ).addOnSuccessListener {
                        data.value = ViewState.success(user)
                }.addOnFailureListener {
                    data.value = ViewState.error(null, "${R.string.op_failed}}")

                }
            }
        }
    }

    class RegisterViewModelFactory(): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(RegisterViewModel::class.java)){
                return RegisterViewModel() as T
            }
            throw IllegalArgumentException("unknown viewmodel class")
        }
    }
}