package com.bff.controller

import com.bff.model.BreedDetail
import com.bff.model.BreedSummary
import com.bff.service.BreedsServiceImp
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/breeds")
class BreedsController(private val breedsService: BreedsServiceImp) {

    @GetMapping("/list/all")
    fun listAllBreeds(
        @RequestParam page: Int,
        @RequestParam size: Int
    ): List<BreedSummary> {
        return breedsService.getAllBreedSummaries(page, size)
    }

    @GetMapping("/detail/{id}")
    fun getBreedDetail(@PathVariable id: Int): BreedDetail {
        return breedsService.getBreedDetail(id)
    }
}
