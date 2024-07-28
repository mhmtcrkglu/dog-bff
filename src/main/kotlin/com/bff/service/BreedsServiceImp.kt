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

    @Cacheable(cacheNames = ["all_breed_summaries"], key = "#page + '_' + #size")
    override fun getAllBreedSummaries(page: Int, size: Int): List<BreedSummary> {
        val breedDetails = dogApiClient.fetchBreeds(page, size)
        updateCache(breedDetails)
        return breedDetails.map { it.toBreedSummary() }
    }

    private fun updateCache(breedDetails: List<BreedDetail>) {
        breedDetails.forEach { allBreedsCache[it.id] = it }
    }

    private fun BreedDetail.toBreedSummary(): BreedSummary {
        return BreedSummary(id, name)
    }

    override fun getBreedDetail(id: Int): BreedDetail {
        return allBreedsCache[id]?.let { breedDetail ->
            AnalyticsTracker.trackBreedRequest(id, breedDetail.name)
            breedDetail
        } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Breed not found")
    }
}
