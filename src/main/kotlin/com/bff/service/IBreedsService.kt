package com.bff.service

import com.bff.model.BreedSummary

interface IBreedsService {
    fun getAllBreeds(page: Int, size: Int): List<BreedSummary>
}