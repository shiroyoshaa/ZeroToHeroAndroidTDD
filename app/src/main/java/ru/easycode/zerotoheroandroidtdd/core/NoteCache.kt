package ru.easycode.zerotoheroandroidtdd.core

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table")
data class NoteCache(

    @PrimaryKey val id: Long,
    @ColumnInfo("text_in_note") val text: String,
    @ColumnInfo(name = "folderId")val folderId: Long,

    )
