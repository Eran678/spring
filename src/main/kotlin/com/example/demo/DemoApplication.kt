package com.example.demo

import org.apache.catalina.core.ApplicationContext
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.core.env.Environment
import java.util.*
import kotlin.collections.ArrayList

@SpringBootApplication
class Application

fun main() {
	var context: ConfigurableApplicationContext = runApplication<Application>()
	val heroService = context.getBean("heroService") as HeroService
	println(heroService.getHeroes().count())
	val heroesList = heroService.getHeroes()

	// Print and verify the list of heroes
	println("List of Heroes:")
	heroesList.forEach { hero ->
		println("${hero.id}: ${hero.name}, Abilities: ${hero.abilities?.joinToString(", ")}")
	}

	// application.properties method:
	//val environment: Environment = context.environment
	//val appNames = environment.getProperty("spring.application.names")?.split(',')?.toList()

	//xml method:
	//val context = ClassPathXmlApplicationContext("appContext.xml")
	//val heroesList = context.getBean("heroes") as ArrayList<Hero>
}
