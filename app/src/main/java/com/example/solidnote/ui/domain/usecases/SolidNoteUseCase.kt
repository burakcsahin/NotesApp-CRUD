package com.example.solidnote.ui.domain.usecases

data class SolidNoteUseCase (
    val getSolidNotes : GetSolidNotes,
    val insertSolidNote: InsertSolidNote,
    val deleteSolidNote: DeleteSolidNote,
    val updateSolidNote: UpdateSolidNote,
    val getByIdSolidNote: GetByIdSolidNote,
)
