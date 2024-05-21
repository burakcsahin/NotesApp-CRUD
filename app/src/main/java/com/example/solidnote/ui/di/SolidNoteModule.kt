package com.example.solidnote.ui.di

import android.content.Context
import androidx.room.Room
import com.example.solidnote.ui.data.RepoImplement
import com.example.solidnote.ui.data.SolidNoteDB
import com.example.solidnote.ui.domain.usecases.DeleteSolidNote
import com.example.solidnote.ui.domain.usecases.GetByIdSolidNote
import com.example.solidnote.ui.domain.usecases.GetSolidNotes
import com.example.solidnote.ui.domain.usecases.InsertSolidNote
import com.example.solidnote.ui.domain.usecases.SolidNoteUseCase
import com.example.solidnote.ui.domain.usecases.UpdateSolidNote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SolidNoteModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context):SolidNoteDB= Room.databaseBuilder(
        context = context,
        klass = SolidNoteDB::class.java,
        name = "SolidNoteDB"
    ).build()

    @Provides
    fun provideDao(dao:SolidNoteDB)=dao.noteDao()

    @Provides
    fun provideSolidNoteUseCase(repo:RepoImplement)=SolidNoteUseCase(
        getSolidNotes = GetSolidNotes(repo),
        getByIdSolidNote = GetByIdSolidNote(repo),
        deleteSolidNote = DeleteSolidNote(repo),
        updateSolidNote = UpdateSolidNote(repo),
        insertSolidNote = InsertSolidNote(repo)
    )
}