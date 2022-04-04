package com.epam.m8_springcore.storage;

import com.epam.m8_springcore.entity.Ticket;
import com.epam.m8_springcore.exception.AlreadyExistException;
import com.epam.m8_springcore.exception.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Хранилище билетов.
 */
public class TicketStorage {

    private final Map<Long, Ticket> ticketMap = new HashMap<>();

    public Integer getSizeStorage() {
        return ticketMap.size();
    }

    public List<Ticket> getAllTickets() {
        return new ArrayList<>(ticketMap.values());
    }

    public Ticket getTicketById(Long id) {
        return ticketMap.values()
                .stream()
                .filter(ticket -> ticket.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Ticket not found with id: " + id));
    }

    public Ticket saveTicket(Ticket ticket) {
        if (ticketMap.values()
                .stream()
                .noneMatch(elem -> (elem.getId().equals(ticket.getId())
                        ||
                        (elem.getPlace().equals(ticket.getPlace()) && (elem.getEventId().equals(ticket.getEventId())))))) {

            ticketMap.put(ticket.getId(), ticket);
            return ticket;
        } else {
            throw new AlreadyExistException("Ticket with same id or same place already exist!");
        }
    }

    public Ticket updateTicket(Ticket ticket) {
        return ticketMap.computeIfPresent(ticket.getId(), (key, value) -> value = ticket);
    }

    public Ticket deleteTicket(Long id) {
        return ticketMap.remove(id);
    }

    public void deleteAllTickets() {
        ticketMap.clear();
    }
}
