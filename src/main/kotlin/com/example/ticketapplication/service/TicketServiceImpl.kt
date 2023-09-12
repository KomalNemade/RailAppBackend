package com.example.ticketapplication.service

import com.example.ticketapplication.entity.Ticket
import com.example.ticketapplication.repository.TicketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class TicketServiceImpl @Autowired constructor(private val ticketRepository: TicketRepository) : TicketService {
    override fun getAllTicket(): Flux<Ticket> {
        return ticketRepository.findAll()
    }

    override fun addTicket(tickets: Flux<Ticket>): Flux<Ticket> {
        return ticketRepository.saveAll(tickets)
    }

}
