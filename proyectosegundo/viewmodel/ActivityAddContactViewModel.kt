package com.example.proyectosegundo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.proyectosegundo.models.entity.Content
import com.example.proyectosegundo.repository.ContentRepository

class ActivityAddContactViewModel(application: Application) : AndroidViewModel(application) {

    private val contentRepository = ContentRepository(application)
    private val TAG = ActivityAddContactViewModel::class.java.name

    fun insertContent(content: Content) = liveData {
        try {
            contentRepository.insertContent(content)
            emit(true)
        }catch(ex: Exception){
            Log.e(TAG,ex.message,ex)
            emit(false)
        }
    }

    fun getAllContent() : LiveData<List<Content>> = liveData {
        val content = contentRepository.getAllContents()
        emit(content)
    }
}