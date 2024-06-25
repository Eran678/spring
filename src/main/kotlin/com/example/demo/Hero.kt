package com.example.demo

import java.sql.Blob

class Hero(
    var id: Int = 0,
    var name: String? = null,
    var abilities: List<String>? = null,
    var image: Blob? = null,
    var isImageDrawn: Boolean = false
) {
    // Primary constructor with default values

    // Secondary constructor with id, name, and abilities parameters
    constructor(id: Int, name: String, abilities: List<String>) : this(id, name, abilities, null, false)

    // Equals method to compare two Hero objects based on their id
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Hero) return false
        return id == other.id
    }
}