package com.bff.controller

import com.bff.model.BreedAnalytics
import com.bff.service.AnalyticsServiceImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin")
class AdminController(private val analyticsService: AnalyticsServiceImpl) {
    @GetMapping("/report/tracking")
    fun getAnalytics(): Map<Int, BreedAnalytics> {
        return analyticsService.getAnalyticsReport()
    }
}
