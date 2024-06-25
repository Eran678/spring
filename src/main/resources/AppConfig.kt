package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean(name = ["heroes"])
    fun heroes(): MutableList<Hero> {
        val heroesList = mutableListOf<Hero>()

        heroesList.add(Hero(12, "Nice Guy", listOf("Flying", "Making people happy")))
        heroesList.add(Hero(13, "Bombasto", listOf("Boom?", "Boom!")))
        heroesList.add(Hero(14, "Celeritas", listOf("Eating Celery.")))
        heroesList.add(Hero(15, "Magneta", listOf("Attracts women named neta", "Knows where the north is")))
        heroesList.add(Hero(16, "RubberMan", listOf("Is decently flexible", "Convicted for stealing the devil fruit?")))
        heroesList.add(Hero(17, "Dynama", listOf("Boom!", "Boom?")))
        heroesList.add(Hero(18, "Dr. IQ", listOf("Erm akchually")))
        heroesList.add(Hero(19, "Magma Man", listOf("Extremely sensitive to cold")))
        heroesList.add(Hero(20, "Tornadude", listOf("Can run decently fast")))

        return heroesList
    }
}