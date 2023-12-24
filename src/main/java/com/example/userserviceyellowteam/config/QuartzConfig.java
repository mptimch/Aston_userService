package com.example.userserviceyellowteam.config;
import com.example.userserviceyellowteam.cache.CourierCachingJob;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetailFactoryBean jobDetail() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        jobDetailFactory.setJobClass(CourierCachingJob.class);
        jobDetailFactory.setDescription("Invoke Courier caching");
        jobDetailFactory.setDurability(true);
        return jobDetailFactory;
    }

    @Bean
    public CronTriggerFactoryBean cronTrigger(JobDetail jobDetail) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetail);
        cronTriggerFactoryBean.setCronExpression("0 0 9 * * ?");
        cronTriggerFactoryBean.setName("loadCouriers");
        return cronTriggerFactoryBean;
    }

    @Bean
    public SchedulerFactoryBean scheduler(Trigger cronTrigger) {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setTriggers(cronTrigger);
        schedulerFactory.setStartupDelay(2);
        schedulerFactory.setAutoStartup(true);
        return schedulerFactory;
    }
}
