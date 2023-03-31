package com.example.projetointegrador.ui.userData.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetointegrador.R
import com.example.projetointegrador.data.datasource.local.AppApplication
import com.example.projetointegrador.data.model.LightPole
import com.example.projetointegrador.domain.repository.Repository
import com.example.projetointegrador.domain.singleliveevent.SingleLiveEvent
import com.example.projetointegrador.domain.viewstate.ViewState

class UserDataViewModel: ViewModel() {
    var item = SingleLiveEvent<ViewState<LightPole>>()
    private val dao = AppApplication.getdatabase().InfoDao()
    private val repository = Repository(dao)

    fun insertToDatabase(lightPole: LightPole){
        item.value = ViewState.loading(null)
        try{
            repository.insertIntoDatabase(lightPole)
            item.value = ViewState.success(lightPole)
        }catch (e: Exception){
            item.value = ViewState.error(null, "${R.string.op_failed}")
        }
    }

    class UserDataViewModelFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserDataViewModel::class.java)) {
                return UserDataViewModel() as T
            }
            throw IllegalArgumentException("unknown viewmodel class")
        }
    }
}