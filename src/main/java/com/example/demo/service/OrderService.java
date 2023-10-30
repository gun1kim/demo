package com.example.demo.service;

public interface OrderService {

    /**
     * 1) 10000 ==> 9900원 (100원 할인)
     * 2) 10000 ==> 9000원 (10% 할인)
     */
    int getPrice(int price);

}
