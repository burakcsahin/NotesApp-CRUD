package com.example.solidnote.ui.domain.usecases

import com.example.solidnote.ui.data.RepoImplement
import com.example.solidnote.ui.domain.entity.solidNote

class InsertSolidNote constructor(private val repo: RepoImplement) {
    suspend operator fun invoke(solidNote: solidNote)=repo.insertNote(solidNote)
}