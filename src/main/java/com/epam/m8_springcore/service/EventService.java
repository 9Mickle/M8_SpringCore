package com.epam.m8_springcore.service;

import com.epam.m8_springcore.dao.EventDAO;
import com.epam.m8_springcore.entity.Event;
import lombok.Setter;

import java.util.List;

@Setter
public class EventService {

    private EventDAO eventDAO;

    public int size() {
        return eventDAO.size();
    }

    public List<Event> findAll() {
        return eventDAO.findAll();
    }

    public Event findById(Long id) {
        return eventDAO.findById(id);
    }

    public Event findByTitle(String title) {
        return eventDAO.findByTitle(title);
    }

    public Event save(Event event) {
        return eventDAO.save(event);
    }

    public Event update(Event event) {
        return eventDAO.update(event);
    }

    public Event delete(Long id) {
        return eventDAO.delete(id);
    }

    public void clear() {
        eventDAO.clear();
    }
}
