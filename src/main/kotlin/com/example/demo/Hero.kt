package com.example.demo

data class Hero(
    private val id: Int = 0,
    private var name: String = "",
    private val abilities: MutableList<String> = mutableListOf(),
    private var image: ByteArray? = null,
    private var isImageDrawn: Boolean = false
) {

    fun getId(): Int {
        return id
    }

    fun setName(name: String) {
        this.name = name
    }
    fun getName(): String {
        return name
    }

    fun setAbilities(abilities: List<String>) {
        this.abilities.clear()
        this.abilities.addAll(abilities)
    }
    fun getAbilities(): List<String> {
        return abilities
    }

    fun setImage(image:ByteArray) {
        this.image = image
    }
    fun getImage(): ByteArray? {
        return image
    }

    fun setIsImageDrawn(isImageDrawn:Boolean) {
        this.isImageDrawn = isImageDrawn
    }
    fun getIsImageDrawn(): Boolean {
        return isImageDrawn
    }



    override fun equals(other: Any?): Boolean {
        if (super.equals(other)) return true;
        return other is Hero && this.id == other.id
    }
}