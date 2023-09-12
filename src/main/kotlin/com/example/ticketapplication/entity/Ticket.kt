package com.example.ticketapplication.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("Ticket")
data class Ticket(
    @Id
    val id: String?,
    val name: String,
    val age: String,
    val berth: String,
    val gender: String,
    val mobileNo : String,
    val emailId : String,
    val price : String,



    )
