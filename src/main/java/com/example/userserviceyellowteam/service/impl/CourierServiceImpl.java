package com.example.userserviceyellowteam.service.impl;

import com.example.userserviceyellowteam.db.entity.User;
import com.example.userserviceyellowteam.db.repository.UserJpaRepository;
import com.example.userserviceyellowteam.service.CourierService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CourierServiceImpl implements CourierService {
    private final UserJpaRepository userJpaRepository;
    private final AtomicInteger counter = new AtomicInteger(0);

    public CourierServiceImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    /**
     * Возвращает одного курьера из кеша
     * @return User
     */
    @Override
    public User getAny() {
        List<User> list = userJpaRepository.findAllWhereRoleLikeCourier();
        int currentCounter = counter.getAndIncrement();
        int index = currentCounter % list.size();
        return list.get(index);
    }
}
