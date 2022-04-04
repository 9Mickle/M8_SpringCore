package com.epam.m8_springcore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {
    private Long id;
    private Long eventId;
    private Long userId;
    private Integer place;
}
