package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean(name = ["heroes"])
    fun heroes(): List<Hero> {
        val heroesList = mutableListOf<Hero>()

        heroesList.add(Hero(12, "Nice Guy", mutableListOf("Flying", "Making people happy")))
        heroesList.add(Hero(13, "Bombasto", mutableListOf("Boom?", "Boom!")))
        heroesList.add(Hero(14, "Celeritas", mutableListOf("Eating Celery.")))
        heroesList.add(Hero(15, "Magneta", mutableListOf("Attracts women named neta", "Knows where the north is")))
        heroesList.add(Hero(16, "RubberMan", mutableListOf("Is decently flexible", "Convicted for stealing the devil fruit?")))
        heroesList.add(Hero(17, "Dynama", mutableListOf("Boom!", "Boom?")))
        heroesList.add(Hero(18, "Dr. IQ", mutableListOf("Erm akchually")))
        heroesList.add(Hero(19, "Magma Man", mutableListOf("Extremely sensitive to cold")))
        heroesList.add(Hero(20, "Tornadude", mutableListOf("Can run decently fast")))

        return heroesList
    }
}