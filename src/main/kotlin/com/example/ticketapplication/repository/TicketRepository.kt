package com.example.ticketapplication.repository

import com.example.ticketapplication.entity.Ticket
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TicketRepository : ReactiveCrudRepository<Ticket,String> {
}