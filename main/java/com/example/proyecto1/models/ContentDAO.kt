package com.example.proyecto1.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
abstract class ContentDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insertContent(content: Content): Long

    @Query("SELECT * FROM Content")
    abstract fun getAllContent() : LiveData<List<Content>>

    @Query("SELECT * FROM Content")
    abstract suspend fun getAllContentSync() : List<Content>

    @Query("SELECT * FROM Content WHERE id IN (:ids)")
    abstract suspend fun getAllContentByIds(ids: List<Long>): List<Content>

}