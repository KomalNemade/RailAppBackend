package com.example.ticketapplication.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("Trains")
data class Trains(
    @Id
    var id: String?,
    val trainName : String,
    val trainNo : String,
    val source: String,
    val destination: String,
    val date: String,
    val seat: String,
    val price: String,

    )
