package com.bff.service

import com.bff.client.DogApiClient
import com.bff.model.BreedDetail
import com.bff.model.BreedSummary
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

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
    @Cacheable(cacheNames = ["breeds"], key = "#page + '_' + #size")
    override fun getAllBreeds(page: Int, size: Int): List<BreedSummary> {
        val allBreedDetails = dogApiClient.fetchBreeds(page, size)
        return allBreedDetails.map { BreedSummary(it.id, it.name) }
    }
}
