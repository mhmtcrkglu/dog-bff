package com.bff.service

import com.bff.model.BreedDetail
import com.bff.model.BreedSummary

interface BreedsService {
    /**
     * Fetch all breeds with pagination from cache or Dog API.
     *
     * @param page The page number to retrieve.
     * @param size The number of breeds per page.
     * @return A list of breeds for the given page and limit.
     */
    fun getAllBreedSummaries(page: Int, size: Int): List<BreedSummary>

    /**
     * Fetch breed detail by ID from cache.
     *
     * @param id The breed ID to fetch details for.
     * @return The breed detail for the given ID.
     */
    fun getBreedDetail(id: Int): BreedDetail?
}