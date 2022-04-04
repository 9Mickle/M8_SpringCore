package com.epam.m8_springcore.facade;

import com.epam.m8_springcore.entity.Event;
import com.epam.m8_springcore.entity.Ticket;
import com.epam.m8_springcore.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface BookingFacade {

    /**
     * CRUD Event.
     */
    Event getEventById(Long id);

    Event getEventByTitle(String title);

    List<Event> getEventsByDate(LocalDate date);

    Event createEvent(Event event);

    Event updateEvent(Event event);

    Event deleteEvent(Long id);

    /**
     * CRUD User.
     */
    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByEmail(String email);

    User createUser(User user);

    User updateUser(User user);

    User deleteUser(Long id);

    /**
     * CRUD Ticket
     */
    Ticket getTicketById(Long id);

    Ticket bookTicket(Ticket ticket);

    Ticket updateTicket(Ticket ticket);

    List<Ticket> getBookedTicketsByUser(User user);

    List<Ticket> getBookedTicketsByEvent(Event event);

    Ticket cancelTicket(Long id);
}
