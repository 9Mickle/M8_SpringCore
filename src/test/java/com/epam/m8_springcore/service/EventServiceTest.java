package com.epam.m8_springcore.service;

import com.epam.m8_springcore.ParentTestClass;
import com.epam.m8_springcore.entity.Event;
import com.epam.m8_springcore.storage.EventStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventServiceTest extends ParentTestClass {

    private EventService eventService;
    private EventStorage eventStorage;
    private Event event;

    @BeforeEach
    public void setUp() {
        eventService = context.getBean("eventService", EventService.class);
        eventStorage = context.getBean("eventStorage", EventStorage.class);

        event = new Event(1L, "Event", LocalDate.of(2022, 4, 4));
        eventStorage.saveEvent(event);
    }

    @Test
    void size() {
        assertEquals(1, eventService.size());
    }

    @Test
    void findAll() {
        assertEquals(List.of(event), eventService.findAll());
    }

    @Test
    void findById() {
        assertEquals(event, eventService.findById(event.getId()));
    }

    @Test
    void findByTitle() {
        assertEquals(event, eventService.findByTitle(event.getTitle()));
    }

    @Test
    void save() {
        Event newEvent = new Event(2L, "NewEvent", LocalDate.now());
        assertEquals(newEvent, eventService.save(newEvent));
    }

    @Test
    void update() {
        String newTitle = "New Title";
        Event updatedEvent = new Event(1L, newTitle, LocalDate.now());
        assertEquals(updatedEvent, eventService.update(updatedEvent));
    }

    @Test
    void delete() {
        assertEquals(event, eventService.delete(event.getId()));
    }

    @Test
    void clear() {
        eventService.clear();
        assertEquals(0, eventStorage.getSizeStorage());
    }
}