package com.example.miappterremotos

data class Terremoto(
    val id: String,
    val place: String,
    val magnitude: Double,
    val time: Long,
    val latitude: Double,
    val longitude: Double
)
