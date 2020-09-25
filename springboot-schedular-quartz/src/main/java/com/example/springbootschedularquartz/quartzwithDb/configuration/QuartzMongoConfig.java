package com.example.springbootschedularquartz.quartzwithDb.configuration;

import com.example.springbootschedularquartz.quartzJobs.QuartsSimpleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import java.util.Properties;


@Configuration
public class QuartzMongoConfig {

    @Autowired
    private QuartzProperties quartzProperties;

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Quartz for SpringBoot
     *
     * 1. QuartzJob -> BeanFactory
     * 2. Trigger -> BeanFactory
     * 		- Simple
     * 		- Cron
     * 3. Scheduler -> BeanFactory
     *
     * All the JOBS can be attached from any componenet class
    */


    //Create AutoWiringSpringBeanJobFactory class to enable @Autowiring of SchedulerFactoryBean throughout classes
    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    //Create a scheduler
    //Attach SpringBeanJobFactory
    //Don't attach trigger ot JobDetail... can be attached/scheduled in any @Component class or a class.
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        Properties properties = new Properties();
        properties.putAll(quartzProperties.getProperties());
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setAutoStartup(true);
        scheduler.setOverwriteExistingJobs(true);
        scheduler.setApplicationContext(applicationContext);
        scheduler.setQuartzProperties(properties);
        scheduler.setJobFactory(springBeanJobFactory());
        return scheduler;
    }

    /*@Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setAutoStartup(true);
        schedulerFactory.setJobFactory(springBeanJobFactory());
        schedulerFactory.setApplicationContextSchedulerContextKey("applicationContext");
        schedulerFactory.setConfigLocation(new ClassPathResource("quartz.properties"));
        schedulerFactory.setWaitForJobsToCompleteOnShutdown(Boolean.TRUE);
        return schedulerFactory;
    }*/

}
