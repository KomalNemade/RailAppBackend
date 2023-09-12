package com.example.ticketapplication.service

import com.example.ticketapplication.entity.Ticket
import reactor.core.publisher.Flux

interface TicketService {
    fun getAllTicket(): Flux<Ticket>

    //fun getTicketByName(name: String): Mono<Ticket>?
    fun addTicket(tickets:Flux<Ticket>): Flux<Ticket>


}