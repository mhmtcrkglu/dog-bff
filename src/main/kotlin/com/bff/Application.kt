package com.bff

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class DogBffApplication

fun main(args: Array<String>) {
    runApplication<DogBffApplication>(*args)
}
