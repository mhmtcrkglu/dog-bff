package com.bff.service

import com.bff.model.BreedDetail
import com.bff.model.BreedSummary

interface IBreedsService {
    fun getAllBreedSummaries(page: Int, size: Int): List<BreedSummary>
    fun getBreedDetail(id: Int): BreedDetail?
}