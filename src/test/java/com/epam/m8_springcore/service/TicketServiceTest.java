package com.epam.m8_springcore.service;

import com.epam.m8_springcore.ParentTestClass;
import com.epam.m8_springcore.entity.Ticket;
import com.epam.m8_springcore.storage.TicketStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicketServiceTest extends ParentTestClass {

    private TicketService ticketService;
    private TicketStorage ticketStorage;
    private Ticket ticket;

    @BeforeEach
    public void setUp() {
        ticketService = context.getBean("ticketService", TicketService.class);
        ticketStorage = context.getBean("ticketStorage", TicketStorage.class);

        ticket = new Ticket(1L, 1L, 1L, 1);
        ticketStorage.saveTicket(ticket);
    }

    @Test
    void size() {
        assertEquals(1, ticketService.size());
    }

    @Test
    void findAll() {
        assertEquals(List.of(ticket), ticketService.findAll());
    }

    @Test
    void findById() {
        assertEquals(ticket, ticketService.findById(ticket.getId()));
    }

    @Test
    void save() {
        Ticket newTicket = new Ticket(2L, 1L, 1L, 2);
        assertEquals(newTicket, ticketService.save(newTicket));
    }

    @Test
    void update() {
        int newPlace = 2;
        Ticket updatedTicket = new Ticket(1L, 1L, 1L, newPlace);
        assertEquals(updatedTicket, ticketService.update(updatedTicket));
    }

    @Test
    void delete() {
        assertEquals(ticket, ticketService.delete(ticket.getId()));
    }

    @Test
    void clear() {
        ticketService.clear();
        assertEquals(0, ticketStorage.getSizeStorage());
    }
}