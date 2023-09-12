package com.example.ticketapplication.service

import com.example.ticketapplication.entity.Trains
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface TrainsService {
    fun getAllTrains(): Flux<Trains>
    fun getTrainByTrainNo(trainNo: String): Mono<Trains>?

    fun addTrain(train: Trains): Mono<Trains>

    abstract fun getTrainById(id: String): Mono<Trains>?
    fun updateTrain(train: Trains):Mono<Trains>?
    fun getTrainsBySrcDes(src:String,des:String):Flux<Trains>?
    //fun updateTrain(trainNo: String, updatedTrain: Trains): Mono<Trains>?
   // fun deleteTrain(trainNo: String)
}