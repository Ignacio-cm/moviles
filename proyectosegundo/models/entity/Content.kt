package com.example.proyectosegundo.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Content (
    @PrimaryKey(autoGenerate = true)
    val id: Long?=null,
    val name: String,
    val tel: String,
    val number: String,
    val bet: String,
    val suit: String
) {


    override fun equals(other: Any?): Boolean {
        if (other is Content)
            return other.id == this.id
        return false
    }
}