package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("heroService")
class HeroService @Autowired constructor(private val heroes: MutableList<Hero>) {

    fun getHeroes(): MutableList<Hero> {
        return heroes
    }
}
