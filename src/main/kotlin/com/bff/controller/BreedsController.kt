package com.bff.controller

import com.bff.model.BreedDetail
import com.bff.model.BreedSummary
import com.bff.service.BreedsServiceImp
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min

@RestController
@RequestMapping("/breeds")
@Validated
class BreedsController(private val breedsService: BreedsServiceImp) {

    @GetMapping("/list/all")
    fun listAllBreeds(
        @Min(0, message = "Page value must be greater than or equal to 0")
        @RequestParam page: Int,
        @Min(10, message = "Size value must be greater than or equal to 10")
        @RequestParam size: Int
    ): List<BreedSummary> {
        return breedsService.getAllBreedSummaries(page, size)
    }

    @GetMapping("/detail/{id}")
    fun getBreedDetail(@PathVariable id: Int): BreedDetail {
        return breedsService.getBreedDetail(id)
    }
}
