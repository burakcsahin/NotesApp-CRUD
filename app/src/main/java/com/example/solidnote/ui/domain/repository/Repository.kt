package com.example.solidnote.ui.domain.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.solidnote.ui.domain.entity.solidNote
import kotlinx.coroutines.flow.Flow


@Dao
interface Repository {

    @Insert
    suspend fun insertNote(note: solidNote)

    @Update
    suspend fun updateNote(note: solidNote)

    @Delete
    suspend fun deleteNote(note: solidNote)

    @Query("select * from solidNote")
    fun getNotes(): Flow<List<solidNote>>

    @Query("select * from solidNote where id=:id")
    suspend fun getByIdNote(id:Int):solidNote
}