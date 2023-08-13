package cl.gencina.todoroom.data

import androidx.lifecycle.LiveData
import cl.gencina.todoroom.data.local.ItemDao
import cl.gencina.todoroom.data.local.ItemEntity

class Repositorio(private val itemDao: ItemDao) {
    fun getAll(): LiveData<List<ItemEntity>> = itemDao.getAll()

    suspend fun insertItem(item:ItemEntity){
        itemDao.insert(item)
    }

}