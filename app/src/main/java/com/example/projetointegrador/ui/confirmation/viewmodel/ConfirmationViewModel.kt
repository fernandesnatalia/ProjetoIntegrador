package com.example.projetointegrador.ui.confirmation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetointegrador.data.datasource.local.AppApplication
import com.example.projetointegrador.data.model.LightPole
import com.example.projetointegrador.domain.repository.Repository
import com.example.projetointegrador.domain.singleliveevent.SingleLiveEvent
import com.example.projetointegrador.domain.viewstate.ViewState

class ConfirmationViewModel(): ViewModel() {
    var item = SingleLiveEvent<ViewState<LightPole>>()
    private val dao = AppApplication.getdatabase().InfoDao()
    private val repository = Repository(dao)

    fun insertToDatabase(lightPole: LightPole){
        item.value = ViewState.loading(null)
        try{
            repository.insertIntoDatabase(lightPole)
            item.value = ViewState.success(lightPole)
        }catch (e: Exception){
            item.value = ViewState.error(null, e.message)
        }
    }

    class ConfirmationViewModelFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ConfirmationViewModel::class.java)) {
                return ConfirmationViewModel() as T
            }
            throw IllegalArgumentException("unknown viewmodel class")
        }
    }
}