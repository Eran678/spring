package com.example.demo

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

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

    fun getHeroes(): List<Hero> {
        return heroes
    }
}
