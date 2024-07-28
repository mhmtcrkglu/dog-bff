package com.bff.service

import com.bff.model.BreedAnalytics

interface AnalyticsService {
    /**
     * Get the analytics report of all tracked breed requests.
     *
     * @return A map where the keys are breed IDs, Names and the values are the request counts.
     */
    fun getAnalyticsReport(): Map<Int, BreedAnalytics>
}