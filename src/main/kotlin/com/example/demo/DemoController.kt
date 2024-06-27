package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.Base64

@RestController
public class DemoController (private val heroService: HeroService) {

    @GetMapping("/names")
    fun getHeroNames(): Map<Int, String> {
        return heroService.getHeroNames()
    }

    data class GetImageResponse(
        val image: String?,
        val isImageDrawn: Boolean
    )
    @GetMapping("/{heroId}/image")
    fun getImage(@PathVariable heroId:Int): GetImageResponse? {
        val response = heroService.getImage(heroId) ?: return null
        val img: String? = response.image?.let { Base64.getEncoder().encodeToString(it) }
        return GetImageResponse(image = img, isImageDrawn = response.isImageDrawn)
    }

    @GetMapping("/{heroId}/abilities")
    fun getAbilities(@PathVariable heroId:Int): List<String>? {
        return heroService.getAbilities(heroId)
    }

    // modifiers
    data class AddHeroRequest(
        val name: String,
        val abilities: List<String>
    )
    @PostMapping("/addHero")
    fun addHero(@RequestBody request:AddHeroRequest): Int {
        return heroService.addHero(request.name, request.abilities)
    }

    data class UpdateHeroRequest(
        val heroId: Int,
        val name: String,
        val abilities: List<String>
    )
    @PostMapping("/updateHero")
    fun updateHero(@RequestBody request:UpdateHeroRequest) {
        return heroService.updateHero(request.heroId, request.name, request.abilities)
    }

    data class DeleteHeroRequest(
        val heroId: Int
    )
    @PostMapping("/deleteHero")
    fun deleteHero(@RequestBody request:DeleteHeroRequest) {
        return heroService.deleteHero(request.heroId)
    }

    data class UpdateImageRequest(
        val heroId: Int,
        val image: String,
        val isImageDrawn: Boolean
    )
    @PostMapping("/updateImage")
    fun updateImage(@RequestBody request:UpdateImageRequest) {
        val imageBytes = Base64.getDecoder().decode(request.image)
        heroService.updateImage(request.heroId, imageBytes, request.isImageDrawn)
    }

    //ranks
    @GetMapping("/ranks")
    fun getRanks(): List<Int> {
        return heroService.getRanks()
    }

    data class UpdateRanksRequest(
        val ranks: List<Int>
    )
    @PostMapping("/updateRanks")
    fun updateRanks(@RequestBody request:UpdateRanksRequest) {
        heroService.updateRanks(request.ranks)
    }
}