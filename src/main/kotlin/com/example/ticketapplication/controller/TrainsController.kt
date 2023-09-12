package com.example.ticketapplication.controller

import com.example.ticketapplication.entity.Trains
import com.example.ticketapplication.service.TrainsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
@RequestMapping("/trains")
class TrainsController(
    @Autowired
    val trainsService: TrainsService
) {
    @GetMapping("/")
    fun getAllTrains(): Flux<Trains> {
        return trainsService.getAllTrains()
    }

    @PostMapping("/add")
    fun addTrains(@RequestBody train: Trains): Mono<Trains> {
        return trainsService.addTrain(train)
    }

    @GetMapping("/trainno/{trainNo}")
    fun getTrainByTrainNo(@PathVariable trainNo: String): Mono<Trains>? {
        return trainsService.getTrainByTrainNo(trainNo)
    }
    @GetMapping("/id/{id}")
    fun getTrainById(@PathVariable id: String): Mono<Trains>? {
        return trainsService.getTrainById(id)
    }

    @GetMapping("/search")
    fun getTrainsBySrcDes(@RequestParam("source") source: String,@RequestParam("destination") destination: String ): Flux<Trains>? {
        return trainsService.getTrainsBySrcDes(source,destination)
    }
    @PutMapping("/train/{id}")
    fun updateTrainById(@PathVariable id: String, @RequestBody updatedTrain: Trains): Mono<Trains>? {
        updatedTrain.id = id
        return trainsService.updateTrain(updatedTrain)
    }

}
