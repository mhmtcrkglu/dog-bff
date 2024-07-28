package com.bff.service

import com.bff.model.BreedAnalytics
import com.bff.util.AnalyticsTracker
import org.springframework.stereotype.Service

@Service
class AnalyticsServiceImp : AnalyticsService {

    override fun getAnalyticsReport(): Map<Int, BreedAnalytics> {
        return AnalyticsTracker.getAnalyticsData()
    }
}
