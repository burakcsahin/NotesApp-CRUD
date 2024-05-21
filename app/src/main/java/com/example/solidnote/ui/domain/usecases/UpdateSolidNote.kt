package com.example.solidnote.ui.domain.usecases

import com.example.solidnote.ui.data.RepoImplement
import com.example.solidnote.ui.domain.entity.solidNote
import javax.inject.Inject

class UpdateSolidNote @Inject constructor(private val repo: RepoImplement) {

    suspend operator fun invoke(solidNote: solidNote)= repo.updateNote(solidNote)
}