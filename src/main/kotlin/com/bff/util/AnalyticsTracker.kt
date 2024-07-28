package com.bff.util

import com.bff.model.BreedAnalytics

object AnalyticsTracker {

    private val analyticsData: MutableMap<Int, BreedAnalytics> = HashMap()

    fun trackBreedRequest(breedId: Int, breedName:String) {
        analyticsData.compute(breedId) { _, existingData ->
            existingData?.apply { clickCount++ } ?: BreedAnalytics(breedId, breedName, 1)
        }
    }

    fun getAnalyticsData(): Map<Int, BreedAnalytics> {
        return analyticsData
    }
}
