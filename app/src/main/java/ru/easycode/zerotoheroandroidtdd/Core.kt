package ru.easycode.zerotoheroandroidtdd

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

class Core(private val context: Context) {
    val dataBase = Room.databaseBuilder(
        context,
        ItemsDataBase::class.java,
        "items_table"
    ).build()
    fun dao() = dataBase.itemsDao()
}