package com.bff.service

import com.bff.model.BreedAnalytics
import com.bff.util.AnalyticsTracker
import org.springframework.stereotype.Service

@Service
class AnalyticsServiceImpl : AnalyticsService {
    /**
     * Get the analytics report of all tracked breed requests.
     *
     * @return A map where the keys are breed IDs and the values are the request counts.
     */
    override fun getAnalyticsReport(): Map<Int, BreedAnalytics> {
        return AnalyticsTracker.getAnalyticsData()
    }
}
