package com.example.demo

import java.sql.Blob
import kotlin.time.measureTime

data class Hero(
    val id: Int = 0,
    var name: String = "",
    val abilities: MutableList<String> = mutableListOf(),
    var image: Blob? = null,
    var isImageDrawn: Boolean = false
) {



    override fun equals(other: Any?): Boolean {
        if (super.equals(other)) return true;
        return other is Hero && this.id == other.id
    }
}