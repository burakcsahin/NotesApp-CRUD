package com.example.solidnote.ui.domain.usecases

import com.example.solidnote.ui.data.RepoImplement
import javax.inject.Inject

class GetSolidNotes @Inject constructor(private val repo: RepoImplement) {
    operator fun invoke()=repo.getNotes()
}