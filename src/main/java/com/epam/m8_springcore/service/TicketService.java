package com.epam.m8_springcore.service;

import com.epam.m8_springcore.dao.TicketDAO;
import com.epam.m8_springcore.entity.Ticket;
import lombok.Setter;

import java.util.List;

@Setter
public class TicketService {

    private TicketDAO ticketDAO;

    public int size() {
        return ticketDAO.size();
    }

    public List<Ticket> findAll() {
        return ticketDAO.findAll();
    }

    public Ticket findById(Long id) {
        return ticketDAO.findById(id);
    }

    public Ticket save(Ticket ticket) {
        return ticketDAO.save(ticket);
    }

    public Ticket update(Ticket ticket) {
        return ticketDAO.update(ticket);
    }

    public Ticket delete(Long id) {
        return ticketDAO.delete(id);
    }

    public void clear() {
        ticketDAO.clear();
    }
}
