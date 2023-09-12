package com.example.ticketapplication.repository

import com.example.ticketapplication.entity.Trains
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface TrainsRepository : ReactiveMongoRepository<Trains, String> {
    fun findByTrainNo(trainNo: String): Mono<Trains>?
    fun findBySourceAndDestination(source:String,destination: String): Flux<Trains>?
  fun findById(objectId: ObjectId):Mono<Trains>?
}