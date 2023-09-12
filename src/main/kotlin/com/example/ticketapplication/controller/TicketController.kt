package com.example.ticketapplication.controller

import com.example.ticketapplication.entity.Ticket
import com.example.ticketapplication.service.TicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
@RequestMapping("/ticket")
class TicketController (
    @Autowired
    val ticketService: TicketService
    ) {
        @GetMapping("/")
        fun getAllTicket(): Flux<Ticket> {
            return ticketService.getAllTicket()
        }

        @PostMapping("/add")
        fun addTicket(@RequestBody tickets: Flux<Ticket>): Flux<Ticket> {
            return ticketService.addTicket(tickets)
        }





}