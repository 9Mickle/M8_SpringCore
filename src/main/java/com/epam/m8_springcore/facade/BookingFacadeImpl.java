package com.epam.m8_springcore.facade;

import com.epam.m8_springcore.entity.Event;
import com.epam.m8_springcore.entity.Ticket;
import com.epam.m8_springcore.entity.User;
import com.epam.m8_springcore.service.EventService;
import com.epam.m8_springcore.service.TicketService;
import com.epam.m8_springcore.service.UserService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BookingFacadeImpl implements BookingFacade {

    private final UserService userService;
    private final EventService eventService;
    private final TicketService ticketService;

    /**
     * Methods for Event.
     */
    @Override
    public Event getEventById(Long id) {
        return eventService.findById(id);
    }

    @Override
    public Event getEventByTitle(String title) {
        return eventService.findByTitle(title);
    }

    @Override
    public List<Event> getEventsByDate(LocalDate date) {
        return eventService.findAll()
                .stream()
                .filter(elem -> elem.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public Event createEvent(Event event) {
        return eventService.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventService.update(event);
    }

    @Override
    public Event deleteEvent(Long id) {
        return eventService.delete(id);
    }

    /**
     * Methods for User.
     */
    @Override
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userService.findById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userService.findByEmail(email);
    }

    @Override
    public User createUser(User user) {
        return userService.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userService.update(user);
    }

    @Override
    public User deleteUser(Long id) {
        return userService.delete(id);
    }

    /**
     * Methods for Ticket.
     */
    @Override
    public Ticket getTicketById(Long id) {
        return ticketService.findById(id);
    }

    @Override
    public Ticket bookTicket(Ticket ticket) {
        return ticketService.save(ticket);
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return ticketService.update(ticket);
    }

    @Override
    public List<Ticket> getBookedTicketsByUser(User user) {
        return ticketService.findAll()
                .stream()
                .filter(elem -> elem.getUserId().equals(user.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getBookedTicketsByEvent(Event event) {
        return ticketService.findAll()
                .stream()
                .filter(elem -> elem.getEventId().equals(event.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Ticket cancelTicket(Long id) {
        return ticketService.delete(id);
    }
}
