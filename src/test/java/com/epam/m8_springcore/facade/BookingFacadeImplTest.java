package com.epam.m8_springcore.facade;

import com.epam.m8_springcore.ParentTestClass;
import com.epam.m8_springcore.entity.Event;
import com.epam.m8_springcore.entity.Ticket;
import com.epam.m8_springcore.entity.User;
import com.epam.m8_springcore.exception.AlreadyExistException;
import com.epam.m8_springcore.storage.TicketStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookingFacadeImplTest extends ParentTestClass {

    private BookingFacadeImpl bookingFacade;
    private Ticket ticket;

    @BeforeEach
    void setUp() {
        bookingFacade = context.getBean("bookingFacadeImpl", BookingFacadeImpl.class);
        TicketStorage ticketStorage = context.getBean("ticketStorage", TicketStorage.class);
        ticket = new Ticket(1L, 1L, 1L, 1);

        ticketStorage.saveTicket(ticket);
    }

    /**
     * Создать пользователя.
     */
    @Test
    void canCreateUser() {
        User user = new User(1L, "Misha", "misha@mail.ru");
        assertEquals(user, bookingFacade.createUser(user));
    }

    /**
     * Создать мероприятие.
     */
    @Test
    void canCreateEvent() {
        Event event = new Event(1L, "Event", LocalDate.now());
        assertEquals(event, bookingFacade.createEvent(event));
    }

    /**
     * Успешный заказ билета.
     */
    @Test
    void successBookTicket() {
        Ticket ticket = new Ticket(2L, 1L, 1L, 2);
        assertEquals(ticket, bookingFacade.bookTicket(ticket));
    }

    /**
     * Неуспешный заказ билета.
     */
    @Test
    void throwAlreadyExistException() {
        // Нельзя сохранять с таким же id.
        Ticket ticket1 = new Ticket(1L, 1L, 1L, 2);
        assertThrows(AlreadyExistException.class, () -> bookingFacade.bookTicket(ticket1));

        // Нельзя заказать билет на тоже место, которое уже занято на это мероприятие.
        Ticket ticket2 = new Ticket(2L, 1L, 1L, 1);
        assertThrows(AlreadyExistException.class, () -> bookingFacade.bookTicket(ticket2));
    }

    /**
     * Получить все билеты оформленные на пользовтеля.
     */
    @Test
    void getBookedTicketsByUser() {
        User user = new User(1L, "Misha", "miha@mail.ru");
        assertEquals(List.of(ticket), bookingFacade.getBookedTicketsByUser(user));
    }

    /**
     * Получить все билеты на это мероприятие.
     */
    @Test
    void getBookedTicketsByEvent() {
        Event event = new Event(1L, "Event", LocalDate.of(2022, 4, 4));
        assertEquals(List.of(ticket), bookingFacade.getBookedTicketsByEvent(event));
    }

    /**
     * Удалить билет.
     */
    @Test
    void cancelTicket() {
        assertEquals(ticket, bookingFacade.cancelTicket(ticket.getId()));
    }
}