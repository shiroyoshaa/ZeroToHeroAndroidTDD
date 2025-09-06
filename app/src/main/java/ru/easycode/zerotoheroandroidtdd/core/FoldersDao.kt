package ru.easycode.zerotoheroandroidtdd.core

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface FoldersDao {

    @Query("SELECT * FROM folder_table")
    suspend fun folders(): List<FolderCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(folder: FolderCache)

    @Query("DELETE FROM folder_table WHERE id = :folderId")
    suspend fun delete(folderId: Long)

}