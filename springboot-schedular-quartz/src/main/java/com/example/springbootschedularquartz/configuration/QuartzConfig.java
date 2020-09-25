package com.example.springbootschedularquartz.configuration;

import com.example.springbootschedularquartz.quartzJobs.QuartsSimpleJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfig {

/**
     * Quartz for SpringBoot
     *
     * 1. QuartzJob -> BeanFactory
     * 2. Trigger -> BeanFactory
     * 		- Simple
     * 		- Cron
     * 3. Scheduler -> BeanFactory
     *
     * All the JOBS can be only defined in @Configuration scope
     * */



    //Create job detail and attach a Quartz job class
    /*@Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
        jobDetail.setJobClass(QuartsSimpleJob.class);
        return jobDetail;
    }*/

    //Create a SIMPLE trigger
    //RUNs FIVE times
    /*@Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetail) {
        SimpleTriggerFactoryBean simpleTrigger = new SimpleTriggerFactoryBean();
        simpleTrigger.setJobDetail(jobDetail.getObject());
        simpleTrigger.setRepeatInterval(5000l);
        simpleTrigger.setRepeatCount(5);
        return simpleTrigger;
    }*/

    //Create a CRON trigger and attach JobDetail
    //RUNs every 5sec
    /*@Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetail) {
        CronTriggerFactoryBean cronTrigger = new CronTriggerFactoryBean();
        cronTrigger.setJobDetail(jobDetail.getObject());
        cronTrigger.setCronExpression("0/5 * * * * ?");
        return cronTrigger;
    }*/

    //Create a scheduler
    //Attach trigger and/or jobDetails in scheduler
    /*@Bean
    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTrigger, CronTriggerFactoryBean cronTrigger) {
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
//        scheduler.setTriggers(simpleTrigger.getObject());
        scheduler.setTriggers(cronTrigger.getObject());
        return scheduler;
    }*/

}
