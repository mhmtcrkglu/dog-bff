package com.bff.service

import com.bff.client.DogApiClient
import com.bff.model.BreedSummary
import org.springframework.stereotype.Service

@Service
class BreedsService(
    private val dogApiClient: DogApiClient
) : IBreedsService {

    /**
     * Fetch all breeds with pagination from Dog API.
     *
     * @param page The page number to retrieve.
     * @param size The number of breeds per page.
     * @return A list of breeds for the given page and limit.
     */
    override fun getAllBreeds(page: Int, size: Int): List<BreedSummary> {
        val breeds = dogApiClient.fetchBreeds(page, size)
        val paginatedBreedSummaries = breeds.map { BreedSummary(it.id, it.name) }
        return paginatedBreedSummaries
    }
}
