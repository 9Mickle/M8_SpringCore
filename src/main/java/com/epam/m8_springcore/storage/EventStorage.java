package com.epam.m8_springcore.storage;

import com.epam.m8_springcore.entity.Event;
import com.epam.m8_springcore.exception.AlreadyExistException;
import com.epam.m8_springcore.exception.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Хранилище событий.
 */
public class EventStorage {

    private final Map<Long, Event> eventMap = new HashMap<>();

    public int getSizeStorage() {
        return eventMap.size();
    }

    public List<Event> getAllEvents() {
        return new ArrayList<>(eventMap.values());
    }

    public Event getEventById(Long id) {
        return eventMap.values()
                .stream()
                .filter(event -> event.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Event not found with id: " + id));
    }

    public Event getEventByTitle(String title) {
        return eventMap.values()
                .stream()
                .filter(event -> event.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Event not found with title: " + title));
    }

    public Event saveEvent(Event event) {
        if (eventMap.values()
                .stream()
                .noneMatch(elem -> (elem.getId().equals(event.getId()) &&
                        elem.getTitle().equals(event.getTitle())))) {

            eventMap.put(event.getId(), event);
            return event;
        } else {
            throw new AlreadyExistException("Event with id already exist!");
        }
    }

    public Event updateEvent(Event event) {
        return eventMap.computeIfPresent(event.getId(), (key, value) -> value = event);
    }

    //public Event updateEvent(Event event) {
    //        return eventMap.computeIfPresent(event.getId(), (key, value) -> {
    //            value.setTitle(event.getTitle());
    //            value.setDate(event.getDate());
    //            return value;
    //        });
    //    }

    public Event deleteEvent(Long id) {
        return eventMap.remove(id);
    }

    public void deleteAllEvents() {
        eventMap.clear();
    }
}
