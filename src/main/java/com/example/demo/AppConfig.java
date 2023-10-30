package com.example.demo;

import com.example.demo.service.AmountOrderServiceImpl;
import com.example.demo.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public OrderService orderService() {
        return new AmountOrderServiceImpl();
//        return new RateOrderServiceImpl();
    }
}
