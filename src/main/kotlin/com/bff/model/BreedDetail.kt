package com.bff.model

import com.fasterxml.jackson.annotation.JsonProperty


data class DogBreed(
    val weight: Weight,
    val height: Height,
    val id: Int,
    val name: String,
    @JsonProperty("bred_for")
    val bredFor: String?,
    @JsonProperty("breed_group")
    val breedGroup: String?,
    @JsonProperty("life_span")
    val lifeSpan: String?,
    val temperament: String?,
    val origin: String?,
    @JsonProperty("reference_image_id")
    val referenceImageId: String?,
)

data class Weight(
    val imperial: String?,
    val metric: String?,
)

data class Height(
    val imperial: String?,
    val metric: String?,
)

