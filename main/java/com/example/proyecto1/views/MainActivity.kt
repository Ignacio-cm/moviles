package com.example.proyecto1.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.TextView
//import com.example.proyecto1.views.ActivityAddContact
import com.example.proyecto1.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contact.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioHeart.setOnCheckedChangeListener(changeradio)
        radioSpade.setOnCheckedChangeListener(changeradio)
        radioClub.setOnCheckedChangeListener(changeradio)
        radioDiamond.setOnCheckedChangeListener(changeradio)

        textview_name.text = findViewById<TextView>(R.id.TextNombre).text
        textview_tel.text = findViewById<TextView>(R.id.TextTelefono).text
        textview_number.text = findViewById<TextView>(R.id.textNumeroSuerte).text

        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAccept)
        fabAdd.setOnClickListener {
            val intent = Intent(this, ActivityAddContact::class.java)
            startActivity(intent)
        }




    }
    private val changeradio = CompoundButton.OnCheckedChangeListener { button, checked ->
        var texto = ""

        if (radioSpade.isChecked) {
            texto += "Espadas\n"
        }

        else if (radioClub.isChecked) {
            texto += "Treboles\n";
        }

        else if (radioDiamond.isChecked) {
            texto += "Diamantes\n";
        }

        else if (radioHeart.isChecked) {
            texto += "Corazones\n";
        }

        textview_Suit.text = texto
    }
}