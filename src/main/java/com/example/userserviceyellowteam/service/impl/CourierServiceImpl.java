package com.example.userserviceyellowteam.service.impl;

import com.example.userserviceyellowteam.db.entity.User;
import com.example.userserviceyellowteam.db.repository.UserJpaRepository;
import com.example.userserviceyellowteam.service.CourierService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
     *
     * @return User
     */
    @Override
    @Transactional
    public User getAny() {
        Optional<List<User>> optionalUsers = userJpaRepository.findAllWhereRoleLikeCourier();
        List<User> list = optionalUsers.orElseThrow();
        int currentCounter = counter.getAndIncrement();
        int index = currentCounter % list.size();
        return list.get(index);
    }
}
