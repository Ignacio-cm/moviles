package com.example.proyectosegundo.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectosegundo.R
import com.example.proyectosegundo.adapter.ContentAdapter
import com.example.proyectosegundo.viewmodel.ActivityAddContactViewModel

class ActivityAddContact : AppCompatActivity() {

    private val activityAddContactView: ActivityAddContactViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_info)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerContent)
        recyclerView.layoutManager = LinearLayoutManager(this)

        activityAddContactView.getAllContent().observe(this) { contents ->
            val contentAdapter = ContentAdapter(contents)
            recyclerView.adapter = contentAdapter
            contentAdapter.notifyDataSetChanged()
        }
    }
}

