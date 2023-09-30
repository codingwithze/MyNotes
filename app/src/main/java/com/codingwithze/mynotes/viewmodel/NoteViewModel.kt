package com.codingwithze.mynotes.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.codingwithze.mynotes.database.Note
import com.codingwithze.mynotes.repository.NoteRepository

class NoteViewModel(application: Application): ViewModel() {
    private val mNoteRepository : NoteRepository = NoteRepository(application)

    fun insert(note: Note){
        mNoteRepository.insert(note)
    }

    fun update(note: Note){
        mNoteRepository.update(note)
    }

    fun delete(note: Note){
        mNoteRepository.delete(note)
    }

    fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNote()
}