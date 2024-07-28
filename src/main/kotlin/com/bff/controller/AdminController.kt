package com.bff.controller

import com.bff.model.BreedAnalytics
import com.bff.service.AnalyticsServiceImp
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class AdminController(private val analyticsService: AnalyticsServiceImp) {

    @GetMapping("/report/tracking")
    fun getAnalytics(): Map<Int, BreedAnalytics> {
        return analyticsService.getAnalyticsReport()
    }
}
