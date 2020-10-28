package com.example.proyecto1.views

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.proyecto1.R
import com.example.proyecto1.models.Content
import com.example.proyecto1.viewmodel.ActivityAddContactViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contact.*


class ActivityAddContact : AppCompatActivity() {

    private val activityAddContactViewModel: ActivityAddContactViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val buttonSave = findViewById<FloatingActionButton>(R.id.fabAccept)
        buttonSave.setOnClickListener {
            val name = findViewById<TextView>(R.id.textview_name).text.toString()
            val tel = findViewById<TextView>(R.id.textview_tel).text.toString()
            val number = findViewById<TextView>(R.id.textview_number).text.toString().toInt()
            val suit = findViewById<TextView>(R.id.textview_Suit).text.toString()

            val content = Content(
                name = name,
                tel = tel,
                number = number,
                suit = suit
            )

            activityAddContactViewModel.insertContent(content)
        }
        
    }

}

