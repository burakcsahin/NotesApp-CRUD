package com.example.solidnote.ui.present.view.homeScreen

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solidnote.SolidNoteApp
import com.example.solidnote.ui.domain.entity.solidNote
import com.example.solidnote.ui.domain.usecases.SolidNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(private val useCase: SolidNoteUseCase) :ViewModel() {
    val notes = useCase.getSolidNotes()

    fun deleteSolidNote(note : solidNote)=viewModelScope.launch {
        useCase.deleteSolidNote(note)
    }
}