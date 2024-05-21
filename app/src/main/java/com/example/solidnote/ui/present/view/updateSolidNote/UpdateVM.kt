package com.example.solidnote.ui.present.view.updateSolidNote

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solidnote.ui.domain.entity.solidNote
import com.example.solidnote.ui.domain.usecases.SolidNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateVM @Inject constructor(
    private val useCase : SolidNoteUseCase,
    private val savedStateHandle : SavedStateHandle
):ViewModel() {
    var title by mutableStateOf("")
    var content by mutableStateOf("")

    val id = savedStateHandle.get<Int>(key = "id")

    init {
        viewModelScope.launch {
            val nota = id?.let { useCase.getByIdSolidNote(it) }
            if (nota != null) {
                content = nota.content
                title = nota.title
            }


        }
    }

    fun updateNota()=viewModelScope.launch {
        useCase.updateSolidNote(solidNote(id!!, title, content = content))

    }
}