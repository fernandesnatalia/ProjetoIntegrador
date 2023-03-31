package com.example.projetointegrador.ui.itemList.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetointegrador.data.datasource.local.AppApplication
import com.example.projetointegrador.data.model.LightPole
import com.example.projetointegrador.domain.repository.Repository
import com.example.projetointegrador.domain.singleliveevent.SingleLiveEvent
import com.example.projetointegrador.domain.viewstate.ViewState

class ItemListViewModel(): ViewModel() {
    val list = SingleLiveEvent<ViewState<List<LightPole>>>()
    private val dao = AppApplication.getdatabase().InfoDao()
    private val repository = Repository(dao)

    fun getList(): ViewState<List<LightPole>> {
        return try{
            val list = repository.getList()
            if(list.isEmpty()){
                ViewState.empty(list)
            }else{
                ViewState.success(list)
            }
        }catch (e:Exception){
            ViewState.error(null, e.message)
        }
    }

    class ItemListViewModelFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ItemListViewModel::class.java)) {
                return ItemListViewModel() as T
            }
            throw IllegalArgumentException("unknown viewmodel class")
        }
    }
}