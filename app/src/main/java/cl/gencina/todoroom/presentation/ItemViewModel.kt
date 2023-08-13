package cl.gencina.todoroom.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.gencina.todoroom.data.Repositorio
import cl.gencina.todoroom.data.local.ItemDatabase
import cl.gencina.todoroom.data.local.ItemEntity
import kotlinx.coroutines.launch

class ItemViewModel(application: Application):AndroidViewModel(application) {
    private val repositorio : Repositorio

    init{
        val dao = ItemDatabase. getDatabase(application).getItemDao()
        repositorio = Repositorio(dao)
    }

    fun getAllItem(): LiveData<List<ItemEntity>> = repositorio.getAll()

    fun insertItem(name:String, price: Int, quantity: Int) = viewModelScope.launch {
        val item = ItemEntity(name, price, quantity)
        repositorio.insertItem(item)
    }
}