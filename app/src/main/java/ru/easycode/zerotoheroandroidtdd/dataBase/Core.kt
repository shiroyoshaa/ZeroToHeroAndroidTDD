package ru.easycode.zerotoheroandroidtdd.dataBase

import android.content.Context
import androidx.room.Room

class Core(private val context: Context) {

    val db = Room.databaseBuilder(
        context,
        ItemsDataBase::class.java,
        "item_database"
    ).build()

    fun dao() = db.itemsDao()
}