package ru.easycode.zerotoheroandroidtdd.core

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "items_table")
data class ItemCache(

    @PrimaryKey val id: Long,
    val text: String,
)
