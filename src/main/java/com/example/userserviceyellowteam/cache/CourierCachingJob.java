package com.example.userserviceyellowteam.cache;

import com.example.userserviceyellowteam.db.repository.UserJpaRepository;
import lombok.AllArgsConstructor;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;



/**
 * Задача на обновление кеша с курьерами
 */
@Component
@AllArgsConstructor
public class CourierCachingJob implements Job {

    private final UserJpaRepository userJpaRepository;
    private final CacheManager cacheManager;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Cache courierCache = cacheManager.getCache("courierCache");
        if (courierCache != null) {
            courierCache.clear();
        }
        userJpaRepository.findAllWhereRoleLikeCourier();
    }
}
