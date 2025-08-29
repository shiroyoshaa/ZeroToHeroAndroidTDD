package ru.easycode.zerotoheroandroidtdd.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "items_table")
data class ItemCache(
    @PrimaryKey val id: Long,
    @ColumnInfo (name = "text") val text: String,
)
