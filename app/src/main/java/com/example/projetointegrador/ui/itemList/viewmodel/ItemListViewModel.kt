package com.example.projetointegrador.ui.itemList.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.projetointegrador.data.datasource.local.database.AppApplication
import com.example.projetointegrador.domain.model.LightPole
import com.example.projetointegrador.domain.repository.Repository
import com.example.projetointegrador.domain.singleliveevent.SingleLiveEvent
import com.example.projetointegrador.domain.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ItemListViewModel(): ViewModel() {
    val item = SingleLiveEvent<ViewState<List<LightPole>>>()
    private val dao = AppApplication.getdatabase().InfoDao()
    private val repository = Repository(dao)

    fun getList() {
        viewModelScope.launch {
            item.value = ViewState.loading(null)
            try {
                val withContext = withContext(Dispatchers.Default) {
                    val response = repository.getList()
                    ViewState.success(response)
                }
                withContext.let {
                    item.value = ViewState.success(it.data)
                }
            } catch (e: Exception) {
                item.value = ViewState.error(null, e.message)
            }
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