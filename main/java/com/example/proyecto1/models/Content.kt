package com.example.proyecto1.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Content (
    @PrimaryKey(autoGenerate = true)
    val id: Long?=null,
    val name: String,
    val tel: String,
    val number: Int,
    val suit: String
) {


    override fun equals(other: Any?): Boolean {
        if (other is Content) {
            return other.id == this.id //&& name == otherObj.name
        }

        return false
    }
}