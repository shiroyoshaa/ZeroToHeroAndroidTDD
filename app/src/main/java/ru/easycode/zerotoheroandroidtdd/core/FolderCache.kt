package ru.easycode.zerotoheroandroidtdd.core

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "folder_table")
data class FolderCache(

    @PrimaryKey val id: Long,
    @ColumnInfo("text_in_folder") val text: String,

)
