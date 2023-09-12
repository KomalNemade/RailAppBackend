package com.example.ticketapplication.service

import com.example.ticketapplication.entity.Trains
import com.example.ticketapplication.repository.TrainsRepository
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class TrainsServiceImpl @Autowired constructor(private val trainsRepository: TrainsRepository) : TrainsService {
    override fun getAllTrains(): Flux<Trains> {
        return trainsRepository.findAll()
    }

    override fun getTrainByTrainNo(trainNo: String): Mono<Trains>? {
        return trainsRepository.findByTrainNo(trainNo)
    }

    override fun getTrainById(id: String): Mono<Trains>? {
        // Convert the String id to ObjectId or the appropriate type
        val objectId = try {
            ObjectId(id) // Attempt to convert the String to ObjectId
        } catch (e: IllegalArgumentException) {
            return Mono.empty() // Handle the case where the conversion fails
        }

        // Use the converted objectId in your findById query
        return trainsRepository.findById(objectId)
    }

    override fun updateTrain(train: Trains): Mono<Trains>? {
        return trainsRepository.save(train)
    }
    override fun getTrainsBySrcDes(src:String,des:String):Flux<Trains>?{
        return trainsRepository.findBySourceAndDestination(src,des)
    }
    override fun addTrain(train: Trains): Mono<Trains> {
        return trainsRepository.save(train)
    }

    /*override fun updateTrain(trainNo: String, updatedTrain: Trains): Mono<Trains>? {
        val existingTrain = trainsRepository.findByTrainNo(trainNo)
        return existingTrain.flatMap {
            updatedTrain.id = it.id
            trainsRepository.save(updatedTrain)
        }
    }

    override fun deleteTrain(trainNo: String) {
        val existingTrain = trainsRepository.findByTrainNo(trainNo)
        existingTrain.subscribe { train ->
            trainsRepository.delete(train)
        }
    } */
}
