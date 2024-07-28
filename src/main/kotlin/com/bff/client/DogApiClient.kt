package com.bff.client

import com.bff.model.BreedDetail
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import org.springframework.web.util.UriComponentsBuilder

@Component
class DogApiClient {
    private val restTemplate = RestTemplate()
    private val apiUrl = "https://api.thedogapi.com/v1"

    /**
     * Fetch the list of breed details with pagination from The Dog API.
     * The API returns a list of breed objects with details.
     *
     * @param page The page number to retrieve.
     * @param limit The number of breeds per page.
     * @return List of BreedDetail objects for the given page and limit.
     */
    fun fetchBreeds(page: Int, limit: Int): List<BreedDetail> {
        val url = UriComponentsBuilder.fromHttpUrl("$apiUrl/breeds")
            .queryParam("page", page)
            .queryParam("limit", limit)
            .toUriString()

        return restTemplate.getForObject<Array<BreedDetail>>(url).toList()
    }
}
