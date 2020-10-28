package com.example.proyecto1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto1.R
import com.example.proyecto1.`interface`.BottomDialogListener
import com.example.proyecto1.models.Content


class ContentAdapter(private val contents: List<Content>, val bottomDialogListener: BottomDialogListener) : RecyclerView.Adapter<ContentAdapter.ContentAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.contact, parent, false)

        return ContentAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContentAdapterViewHolder, position: Int) {
        val content = contents[position]
        holder.onBind(content)
    }

    override fun getItemCount(): Int {
        return contents.size
    }

    inner class ContentAdapterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(content: Content) {
            val textViewName = view.findViewById<TextView>(R.id.textview_name)
            val textViewTel = view.findViewById<TextView>(R.id.textview_tel)
            val textViewNumber = view.findViewById<TextView>(R.id.textview_number)
            val texViewSuite = view.findViewById<TextView>(R.id.textview_Suit)

            textViewName.text = content.name
            textViewTel.text = content.tel
            textViewNumber.text = content.number.toString()
            texViewSuite.text = content.suit

            view.setOnClickListener {
                bottomDialogListener.onClick(content.id!!)
            }
        }
    }
}