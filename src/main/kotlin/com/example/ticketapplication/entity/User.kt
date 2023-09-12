package com.example.ticketapplication.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
@Document("User")
data class User(
    @Id
    val id: String?,
    val name : String,
    val email: String,
    val phone: Long,
    val password: String,
    val role: String,

)
