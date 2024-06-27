package com.example.demo

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Service("heroService")
class HeroService (private val heroes: MutableList<Hero>, private val ranks: MutableList<Int>) {

    @PostConstruct
    fun init() {
        println()

        println("List of Heroes: (${getHeroes().size})")
        getHeroes().forEach { hero ->
            println("${hero.getId()}: ${hero.getName()}, Abilities: ${hero.getAbilities()?.joinToString(", ") ?: "None"}")
        }
    }

    private fun getHeroes(): MutableList<Hero> {
        return heroes
    }

    private fun getHero(heroId: Int): Hero? {
        return getHeroes().find { it.getId() == heroId }
    }

    fun getHeroNames(): Map<Int, String> {
        return getHeroes().associate {it.getId() to it.getName() }
    }

    data class GetImageResponse(
        val image: ByteArray?,
        val isImageDrawn: Boolean
    )
    fun getImage(heroId: Int): GetImageResponse? {
        val hero = getHero(heroId) ?: return null
        return GetImageResponse(image = hero.getImage(), isImageDrawn = hero.getIsImageDrawn())
    }

    fun getAbilities(heroId: Int): List<String>? {
        return getHero(heroId)?.getAbilities()
    }

    fun getUniqueId(): Int {
        return getHeroes().maxOf { it.getId() } + 1
    }

    //modifiers
    fun addHero(name:String, abilities: List<String>): Int {
        val newId = getUniqueId()
        getHeroes().add(Hero(newId, name, abilities.toMutableList()))
        return newId;
    }

    fun updateHero(heroId:Int, name:String, abilities: List<String>) {
        val hero = getHero(heroId) ?: return
        hero.setName(name)
        hero.setAbilities(abilities)
    }

    fun deleteHero(heroId:Int) {
        getHeroes().removeIf { it.getId() == heroId }
    }

    fun updateImage(heroId:Int, image:ByteArray, isImageDrawn:Boolean) {
        val hero = getHero(heroId) ?: return
        hero.setImage(image)
        hero.setIsImageDrawn(isImageDrawn)
    }

    //ranks
    fun getRanks(): MutableList<Int> {
        return ranks
    }

    fun updateRanks(ranks: List<Int>) {
        val rankList: MutableList<Int> = getRanks()
        rankList.clear()
        rankList.addAll(ranks)
    }
}
