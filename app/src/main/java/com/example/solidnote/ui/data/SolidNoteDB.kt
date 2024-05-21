package com.example.solidnote.ui.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.solidnote.ui.domain.entity.solidNote
import com.example.solidnote.ui.domain.repository.Repository

@Database(entities = [solidNote::class], exportSchema = false, version = 1)
abstract class SolidNoteDB:RoomDatabase() {
    abstract fun noteDao(): Repository
}