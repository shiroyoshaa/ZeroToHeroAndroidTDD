package ru.easycode.zerotoheroandroidtdd.core

import android.content.Context
import androidx.room.Room

class Core(context: Context) {
    val db = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        "app_data_base"
    ).build()

    fun foldersDao() = db.foldersDao()
    fun notesDao() = db.notesDao()
}