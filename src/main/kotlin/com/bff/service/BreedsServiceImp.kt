package com.bff.service

import com.bff.client.DogApiClient
import com.bff.model.BreedDetail
import com.bff.model.BreedSummary
import com.bff.util.AnalyticsTracker
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.concurrent.ConcurrentHashMap

@Service
class BreedsServiceImp(
    private val dogApiClient: DogApiClient
) : BreedsService {

    private val allBreedsCache = ConcurrentHashMap<Int, BreedDetail>()

    /**
     * Fetch all breeds with pagination from cache or Dog API.
     *
     * @param page The page number to retrieve.
     * @param size The number of breeds per page.
     * @return A list of breeds for the given page and limit.
     */
    @Cacheable(cacheNames = ["all_breed_summaries"], key = "#page + '_' + #size")
    override fun getAllBreedSummaries(page: Int, size: Int): List<BreedSummary> {
        val allBreedDetails = dogApiClient.fetchBreeds(page, size)
        allBreedDetails.forEach { allBreedsCache[it.id] = it }
        return allBreedDetails.map { BreedSummary(it.id, it.name) }
    }

    /**
     * Fetch breed detail by ID from cache.
     *
     * @param id The breed ID to fetch details for.
     * @return The breed detail for the given ID.
     */
    override fun getBreedDetail(id: Int): BreedDetail {
        val breedDetail = allBreedsCache[id]
        if (breedDetail != null){
            AnalyticsTracker.trackBreedRequest(id, breedDetail.name)
            return breedDetail
        }
        else throw ResponseStatusException(HttpStatus.NOT_FOUND, "Breed not found")
    }
}
