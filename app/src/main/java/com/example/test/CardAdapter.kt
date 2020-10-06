package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(private val apuestas: List<Apuesta>) : RecyclerView.Adapter<CardAdapter.CardHolder>() {

    class CardHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(apuesta: Apuesta) {
            val image = view.findViewById<ImageView>(R.id.image)
            val title = view.findViewById<TextView>(R.id.title)
            val content = view.findViewById<TextView>(R.id.content)

            image.setImageResource(apuesta.image)
            title.text = apuesta.title
            content.text = apuesta.content
//            view.visibility = View.GONE;


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.cardcard, parent, false)
        
        return CardHolder(view)
    }

    override fun onBindViewHolder(cardHolder: CardHolder, position: Int) {
        val animal = apuestas[position]
        cardHolder.onBind(animal)
    }

    override fun getItemCount(): Int {
        return apuestas.size
    }
}