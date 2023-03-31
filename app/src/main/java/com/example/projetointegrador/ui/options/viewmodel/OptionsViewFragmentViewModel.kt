package com.example.projetointegrador.ui.options.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetointegrador.domain.model.User
import com.example.projetointegrador.domain.repository.AuthenticatonRepository
import com.example.projetointegrador.domain.singleliveevent.SingleLiveEvent
import com.example.projetointegrador.domain.viewstate.ViewState

class OptionsViewFragmentViewModel: ViewModel() {
    private val repository = AuthenticatonRepository()
    val data = SingleLiveEvent<ViewState<User>>()

    fun logout() = repository.logout()

    fun getName() = repository.getNameUser()

    class OptionsViewFragmentViewModelFactory(): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(OptionsViewFragmentViewModel::class.java)){
                return OptionsViewFragmentViewModel() as T
            }
            throw IllegalArgumentException("unknown viewmodel class")
        }
    }
}