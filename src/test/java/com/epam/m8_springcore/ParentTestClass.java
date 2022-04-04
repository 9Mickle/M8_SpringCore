package com.epam.m8_springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ParentTestClass {

    protected ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("application_context.xml");
}
