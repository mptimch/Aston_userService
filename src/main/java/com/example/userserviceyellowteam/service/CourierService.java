package com.example.userserviceyellowteam.service;

import com.example.userserviceyellowteam.db.entity.User;

/**
 * планирую сюда прикрутить кеширование курьеров раз в день
 * из бд чтобы не ходить каждый раз когда нужен он доставке
 */
public interface CourierService {
    User getAny();
}
