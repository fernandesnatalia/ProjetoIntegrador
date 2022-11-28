package com.example.projetointegrador.ui.register.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.projetointegrador.domain.model.User
import com.example.projetointegrador.domain.repository.AuthenticatonRepository
import com.example.projetointegrador.domain.singleliveevent.SingleLiveEvent
import com.example.projetointegrador.domain.viewstate.ViewState
import com.example.projetointegrador.utilities.*
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
                    registerUser(User(name = NAME, cpf = CPF, phone = PHONE, email = EMAIL, password = PASSWORD))
                    }
                }
                withContext.let {
                    data.value = ViewState.success(user)
                }
            } catch (e: Exception) {
                data.value = ViewState.error(null, e.message)
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
                    repository.updateProfile(user.name)?.addOnSuccessListener {
                        data.value = ViewState.success(user)
                    }

                }.addOnFailureListener {
                    data.value = ViewState.error(null, it.message)

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