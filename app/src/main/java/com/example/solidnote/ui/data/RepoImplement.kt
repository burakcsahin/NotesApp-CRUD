package com.example.solidnote.ui.data

import com.example.solidnote.ui.domain.entity.solidNote
import com.example.solidnote.ui.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepoImplement @Inject constructor(private val dao:Repository):Repository {
    override suspend fun insertNote(note: solidNote) = dao.insertNote(note = note)

    override suspend fun updateNote(note: solidNote) = dao.updateNote(note = note)

    override suspend fun deleteNote(note: solidNote) = dao.deleteNote(note = note)

    override fun getNotes(): Flow<List<solidNote>> = dao.getNotes()

    override suspend fun getByIdNote(id: Int): solidNote = dao.getByIdNote(id)

}