package com.example.proyectosegundo.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.observe
import com.example.proyectosegundo.R
import com.example.proyectosegundo.models.entity.Content
import com.example.proyectosegundo.viewmodel.ActivityAddContactViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {


    private lateinit var textName : TextView
    private lateinit var texttel : TextView
    private lateinit var textnumber : TextView
    private lateinit var checkwild : CheckBox
    private lateinit var checkpoker : CheckBox
    private lateinit var checktriple : CheckBox
    private lateinit var checkpair : CheckBox
    private lateinit var checkflush : CheckBox
    private lateinit var radioClub : RadioButton
    private lateinit var radioDiamond : RadioButton
    private lateinit var radioSpade : RadioButton
    private lateinit var radioHeart : RadioButton
    private val activityAddViewModel: ActivityAddContactViewModel by viewModels()
    private var bet = ""
    private var suite = ""




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fabAdd = findViewById<FloatingActionButton>(R.id.fabDB)
        fabAdd.setOnClickListener{
            val intent = Intent(this, ActivityAddContact::class.java)
            startActivity(intent)
        }

        textName = findViewById(R.id.TextNombre)
        textnumber = findViewById(R.id.TextNumber)
        texttel = findViewById(R.id.TextTelefono)

        checkflush = findViewById(R.id.checkFlush)
        checkpoker = findViewById(R.id.checkPoker)
        checkpair = findViewById(R.id.checkPair)
        checktriple = findViewById(R.id.checkTriple)
        checkwild = findViewById(R.id.checkWildcard)

        radioClub = findViewById(R.id.radioClub)
        radioDiamond = findViewById(R.id.radioDiamond)
        radioHeart = findViewById(R.id.radioHeart)
        radioSpade = findViewById(R.id.radioSpade)

        val fabActionDialog = findViewById<FloatingActionButton>(R.id.fabDisplay)
        fabActionDialog.setOnClickListener(fabClick)

        val  buttonSave = findViewById<Button>(R.id.buttonSave)
        buttonSave.setOnClickListener(addClick)



    }

    val fabClick = View.OnClickListener { fab ->
        getInfo()

        var msj = "Nombre\n"  + textName.text.toString() + "\nTeléfono\n" + texttel.text.toString() +  "\nNúmero de la suerte\n" + textnumber.text.toString() +  "\nApuesta\n" +
                bet +  "\nTipo de carta" + suite
        val alertDialog = AlertDialog.Builder(fab.context)
            .setTitle("information")
            .setMessage(msj)
            .setPositiveButton("Ok", null)
            .create()
        alertDialog.show()
    }


    val addClick = View.OnClickListener { btn ->
        getInfo()
        val name = textName.text.toString()
        val telefono = texttel.text.toString()
        val number = textnumber.toString()
        val apuesta = bet
        val tipo = suite

        val content = Content(
            name = name,
            tel = telefono,
            number = number,
            bet = apuesta,
            suit = tipo
        )

        activityAddViewModel.insertContent(content).observe(
            this,{ succesful ->
                if (succesful){
                    Toast.makeText(this,"Apuesta guardada", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"Error al guardar", Toast.LENGTH_LONG).show()
                }
            }
        )
    }


    private fun getInfo() {
        bet = ""
        suite = ""
        if (radioHeart.isChecked) {
            suite = "Corazones"
        }
        if (radioDiamond.isChecked) {
            suite = "Diamantes"
        }
        if (radioClub.isChecked) {
            suite = "Treboles"
        }

        if (radioSpade.isChecked) {
            suite = "Espadas"
        }
        if (checkwild.isChecked) {
            bet += "\nWildcard"
        }
        if (checkflush.isChecked) {
            bet += "\nFlush"
        }
        if (checkpair.isChecked) {
            bet += "\nPar/Alta"
        }
        if (checkpoker.isChecked) {
            bet += "\nPoker/Full"
        }
        if (checktriple.isChecked) {
            bet += "\nTriple/Doble Par"
        }

    }
}