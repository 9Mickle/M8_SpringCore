package com.epam.m8_springcore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Event {
    private Long id;
    private String title;
    private LocalDate date;
}
