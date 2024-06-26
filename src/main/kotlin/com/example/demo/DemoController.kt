package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.sql.Blob

@RestController
public class DemoController (private val heroService: HeroService) {

    @GetMapping("/names")
    fun getHeroNames(): Map<Int, String> {
        return heroService.getHeroNames()
    }

    @GetMapping("/{heroId}/image")
    fun getImage(@PathVariable heroId:Int): Blob? {
        return heroService.getImage(heroId)
    }

    @GetMapping("/{heroId}/abilities")
    fun getAbilities(@PathVariable heroId:Int): List<String>? {
        return heroService.getAbilities(heroId)
    }
}