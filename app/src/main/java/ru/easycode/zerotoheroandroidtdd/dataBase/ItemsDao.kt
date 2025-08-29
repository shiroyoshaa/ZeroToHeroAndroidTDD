package ru.easycode.zerotoheroandroidtdd.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ItemsDao {

    @Query("SELECT * FROM ITEMS_TABLE")
    fun list(): List<ItemCache>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add(item: ItemCache)

    @Query("SELECT * FROM items_table WHERE id = :id")
    fun item(id: Long): ItemCache

    @Query("DELETE FROM items_table WHERE id = :id")
    fun delete(id: Long)
}