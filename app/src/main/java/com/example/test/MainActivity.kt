package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var checkWild : CheckBox
    private lateinit var checkFull : CheckBox
    private lateinit var checkHalf : CheckBox
    private lateinit var checkCouple : CheckBox
    private lateinit var checkRoyal : CheckBox
    private lateinit var radioHearts : RadioButton
    private lateinit var radioDiamonds : RadioButton
    private lateinit var radioClubs : RadioButton
    private lateinit var radioSpades : RadioButton
    private lateinit var textnombre: TextView
    private lateinit var texttelefono: TextView
    private lateinit var textnumero: TextView

    private lateinit var textinfo: TextView
    private lateinit var textType: TextView
    private lateinit var textHand: TextView
    private lateinit var textFinal: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkWild = findViewById(R.id.checkWildcard)
        checkFull = findViewById(R.id.checkPoker)
        checkHalf = findViewById(R.id.checkTriple)
        checkCouple = findViewById(R.id.checkPair)
        checkRoyal = findViewById(R.id.checkFlush)
        radioHearts = findViewById(R.id.radioHeart)
        radioDiamonds = findViewById(R.id.radioDiamond)
        radioClubs = findViewById(R.id.radioClub)
        radioSpades = findViewById(R.id.radioSpade)
        textnombre = findViewById(R.id.TextNombre)
        texttelefono = findViewById(R.id.TextTelefono)
        textnumero = findViewById(R.id.TextNumber)



        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val animalAdapter = CardAdapter(createBet())
        val fabActionDialog = findViewById<FloatingActionButton>(R.id.AcceptButton)
        fabActionDialog.setOnClickListener(CheckmarkClick)


        checkWild.setOnCheckedChangeListener(changeChecked)
        checkFull.setOnCheckedChangeListener(changeChecked)
        checkHalf.setOnCheckedChangeListener(changeChecked)
        checkCouple.setOnCheckedChangeListener(changeChecked)
        checkRoyal.setOnCheckedChangeListener(changeChecked)
        radioHearts.setOnCheckedChangeListener(radioChecked)
        radioDiamonds.setOnCheckedChangeListener(radioChecked)
        radioClubs.setOnCheckedChangeListener(radioChecked)
        radioSpades.setOnCheckedChangeListener(radioChecked)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = animalAdapter

        animalAdapter.notifyDataSetChanged()
    }


    private val radioChecked = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
//        var texto = ""
//        if(radioHeart.isChecked){
//            texto = "Tipo de carta: Corazones\n"
//        }
//        if(radioDiamond.isChecked){
//            texto = "Tipo de carta: Diamantes\n"
//        }
//        if(radioClub.isChecked){
//            texto = "Tipo de carta: Tréboles\n"
//        }
//        if(radioSpade.isChecked){
//            texto = "Tipo de carta: Espadas\n"
//        }
//        textType.text = texto

    }


    private val CheckmarkClick = View.OnClickListener { fab ->



        val alertDialog = AlertDialog.Builder(fab.context)
            .setTitle("Confirmar")
            .setMessage("Confirma que vas a apostar lo que seleccionaste")
            .setPositiveButton("Si", null)
            .setNegativeButton("No", null)
            .create()

        alertDialog.show()
    }



    fun createBet(): List<Apuesta> {
        val apuesta = mutableListOf<Apuesta>()

        apuesta.add(
            Apuesta(
                R.drawable.ic_joker,
                "Wildcard",
                "Garantizado si hay un Joker en la mano"
            )
        )

        apuesta.add(
            Apuesta(
                R.drawable.ic_cards,
                "Póquer/Llena",
                "4 o 5 oportunidades en la mano"

            )
        )

        apuesta.add(
            Apuesta(
                R.drawable.ic_3cards,
                "Triple/Doble par",
                "Posible pero no probable"
            )
        )

        apuesta.add(
            Apuesta(
                R.drawable.ic_pair,
                "Par/Alta",
                "Poca chance de acertar"
            )
        )

        apuesta.add(
            Apuesta(
                R.drawable.ic_luck,
                "Escalera",
                "Buena suerte :)"
            )
        )



        return apuesta
    }
    private val changeChecked = CompoundButton.OnCheckedChangeListener {button , checked ->
//        var texto = ""
//        if (checkWild.isChecked){
//            texto += "Wildcard\n" }
//        if (checkFull.isChecked){
//            texto += "Póker/Full House\n"}
//        if (checkHalf.isChecked){
//            texto += "Trío/Doble par\n"}
//        if (checkCouple.isChecked){
//            texto += "Par/\n"}
//        if (checkWild.isChecked){
//            texto += "Wildcard\n"}
//
//        textHand.text = texto

    }
}

