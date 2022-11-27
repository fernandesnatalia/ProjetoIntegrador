package com.example.projetointegrador.ui.login.viewmodel

import androidx.lifecycle.*
import com.example.projetointegrador.domain.model.User
import com.example.projetointegrador.domain.repository.AuthenticatonRepository
import com.example.projetointegrador.domain.singleliveevent.SingleLiveEvent
import com.example.projetointegrador.domain.viewstate.ViewState
import com.example.projetointegrador.utilities.REQUIRED
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel: ViewModel() {
    private val repository = AuthenticatonRepository()
    var data = SingleLiveEvent<ViewState<User>>()

    fun validate(user:User){
        when {
            user.email.isEmpty() -> REQUIRED
            user.password.isEmpty() -> REQUIRED
            else -> login(user)
        }
    }

    fun login(user:User){
        try{
            repository.login(user.email,user.password
            ).addOnSuccessListener {
                data.value = ViewState.success(user)
            }.addOnFailureListener {
                data.value = ViewState.error(null, it.message)
            }
        }catch(e:Exception){
            data.value = ViewState.error(null, e.message)
        }
    }

    class LoginViewModelFactory(): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(LoginViewModel::class.java)){
                return LoginViewModel() as T
            }
            throw IllegalArgumentException("unknown viewmodel class")
        }
    }
}