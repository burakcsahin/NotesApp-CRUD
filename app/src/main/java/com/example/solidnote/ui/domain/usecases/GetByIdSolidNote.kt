package com.example.solidnote.ui.domain.usecases

import com.example.solidnote.ui.data.RepoImplement
import javax.inject.Inject

class GetByIdSolidNote @Inject constructor(private val repo: RepoImplement) {

    suspend operator fun invoke(id:Int) = repo.getByIdNote(id)
}