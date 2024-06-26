package com.example.demo

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Blob

@Service("heroService")
class HeroService (private val heroes: MutableList<Hero>) {

    @PostConstruct
    fun init() {
        println(getHeroes().size)

        println("List of Heroes:")
        getHeroes().forEach { hero ->
            println("${hero.id}: ${hero.name}, Abilities: ${hero.abilities?.joinToString(", ") ?: "None"}")
        }
    }

    private fun getHeroes(): List<Hero> {
        return heroes
    }

    private fun getHero(heroId: Int): Hero? {
        return getHeroes().find { it.id == heroId }
    }

    fun getHeroNames(): Map<Int, String> {
        return getHeroes().associate {it.id to it.name }
    }

    fun getImage(heroId: Int): Blob? {
        return getHero(heroId)?.image
    }

    fun getAbilities(heroId: Int): List<String>? {
        return getHero(heroId)?.abilities
    }
}
