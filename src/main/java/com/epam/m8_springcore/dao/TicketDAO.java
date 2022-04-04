package com.epam.m8_springcore.dao;

import com.epam.m8_springcore.entity.Ticket;
import com.epam.m8_springcore.storage.TicketStorage;
import lombok.Setter;

import java.util.List;

/**
 * Слой доступа к хранилищу билетов.
 */
@Setter
public class TicketDAO {

    private TicketStorage ticketStorage;

    public int size() {
        return ticketStorage.getSizeStorage();
    }

    public List<Ticket> findAll() {
        return ticketStorage.getAllTickets();
    }

    public Ticket findById(Long id) {
        return ticketStorage.getTicketById(id);
    }

    public Ticket save(Ticket Ticket) {
        return ticketStorage.saveTicket(Ticket);
    }

    public Ticket update(Ticket Ticket) {
        return ticketStorage.updateTicket(Ticket);
    }

    public Ticket delete(Long id) {
        return ticketStorage.deleteTicket(id);
    }

    public void clear() {
        ticketStorage.deleteAllTickets();
    }
}
