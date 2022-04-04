package com.epam.m8_springcore.dao;

import com.epam.m8_springcore.entity.Event;
import com.epam.m8_springcore.storage.EventStorage;
import lombok.Setter;

import java.util.List;

/**
 * Слой доступа к хранилищу событий.
 */
@Setter
public class EventDAO {

    private EventStorage eventStorage;

    public int size() {
        return eventStorage.getSizeStorage();
    }

    public List<Event> findAll() {
        return eventStorage.getAllEvents();
    }

    public Event findById(Long id) {
        return eventStorage.getEventById(id);
    }

    public Event findByTitle(String title) {
        return eventStorage.getEventByTitle(title);
    }

    public Event save(Event event) {
        return eventStorage.saveEvent(event);
    }

    public Event update(Event event) {
        return eventStorage.updateEvent(event);
    }

    public Event delete(Long id) {
        return eventStorage.deleteEvent(id);
    }

    public void clear() {
        eventStorage.deleteAllEvents();
    }
}
