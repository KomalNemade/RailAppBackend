package com.example.ticketapplication.repository

import com.example.ticketapplication.entity.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface UserRepository : ReactiveCrudRepository<User, Long>{
   abstract fun findUserByEmailAndPassword(email: String?, password: String?): Mono<User>?
}