package com.example.proyecto1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.proyecto1.models.Content
import com.example.proyecto1.repository.ContentRepository


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val contactRepository = ContentRepository(application)

    fun getContents() : LiveData<List<Content>> = contactRepository.getAllContentLiveData()
}