package com.example.demo.service;


//@Service
public class RateOrderServiceImpl implements OrderService {

    private final int DISCOUNT_RATE = 10;
    @Override
    public int getPrice(int price) {

        return price - (price * DISCOUNT_RATE / 100);
    }
}
