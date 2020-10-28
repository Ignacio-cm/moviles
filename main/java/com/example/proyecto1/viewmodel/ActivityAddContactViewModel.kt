package com.example.proyecto1.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.proyecto1.models.Content
import com.example.proyecto1.repository.ContentRepository
import kotlinx.coroutines.launch

class ActivityAddContactViewModel(application: Application) : AndroidViewModel(application) {
    private val contentRepository = ContentRepository(application)
    private val TAG = ActivityAddContactViewModel::class.java.name
    private val insertLiveData = MutableLiveData<Boolean>()

    fun insertContent(content: Content) = viewModelScope.launch {
        try {
            insertLiveData.postValue(true)
        } catch (ex: Exception) {
            Log.e(TAG, ex.message, ex)
            insertLiveData.postValue(false)
        }
    }

    fun notifyInsertContent() : LiveData<Boolean> = insertLiveData

    fun getAllContent() : LiveData<List<Content>> = liveData {
        emit(contentRepository.getAllContents())
    }
}