package com.bff

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DogBffApplication

fun main(args: Array<String>) {
    runApplication<DogBffApplication>(*args)
}
