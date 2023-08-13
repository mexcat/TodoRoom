package cl.gencina.todoroom.data.local

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: ItemEntity)

    @Query("SELECT * FROM item_table ORDER by id ASC")
    fun getAll(): LiveData<List<ItemEntity>>

    @Delete
    fun delete(item:ItemEntity)

    @Delete
    fun deleteList(items: List<ItemEntity>)
}