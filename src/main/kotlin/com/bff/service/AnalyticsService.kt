package com.bff.service

import com.bff.model.BreedAnalytics

interface AnalyticsService {
    fun getAnalyticsReport(): Map<Int, BreedAnalytics>
}