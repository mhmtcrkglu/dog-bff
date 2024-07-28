package com.bff.controller

import com.bff.model.BreedSummary
import com.bff.service.BreedsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/breeds")
class BreedsController(private val breedsService: BreedsService) {

    @GetMapping("/list/all")
    fun listAllBreeds(
        @RequestParam page: Int,
        @RequestParam size: Int
    ): List<BreedSummary> {
        return breedsService.getAllBreeds(page, size)
    }
}
