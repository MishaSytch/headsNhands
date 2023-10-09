package com.task;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.task.controllers", "com.task.services", "com.task.models"})
public class Config {
    
}
