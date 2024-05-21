package com.example.solidnote.ui.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "solidNote")
data class solidNote(
    @PrimaryKey(autoGenerate = true) val id:Int=0,
    val title:String="",
    val content:String=""
)