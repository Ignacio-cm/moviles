package com.example.proyectosegundo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.proyectosegundo.models.entity.Content
import com.example.proyectosegundo.repository.ContentRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val contactRepository = ContentRepository(application)

    fun getContents() : LiveData<List<Content>> = liveData {
        val contents = contactRepository.getAllContents()
        emit(contents)
    }
}