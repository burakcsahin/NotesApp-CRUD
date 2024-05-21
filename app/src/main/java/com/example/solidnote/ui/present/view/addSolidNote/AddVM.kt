package com.example.solidnote.ui.present.view.addSolidNote

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solidnote.ui.domain.entity.solidNote
import com.example.solidnote.ui.domain.usecases.SolidNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddVM @Inject constructor(private val useCase: SolidNoteUseCase):ViewModel() {
    var title by mutableStateOf("")
    var content by mutableStateOf("")

    fun addSolidNote()= viewModelScope.launch {
        useCase.insertSolidNote(solidNote(title = title, content = content))
    }
}