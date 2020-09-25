package com.example.springbootschedularquartz.quartzwithDb.components;

import com.example.springbootschedularquartz.quartzwithDb.properties.QuartzScheduleInfo;
import org.quartz.SimpleTrigger;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Component
public class QuartzJobCreator {

    public JobDetailFactoryBean createJob(Class<? extends QuartzJobBean> jobClass, ApplicationContext context, QuartzScheduleInfo quartzScheduleInfo) {
        JobDetailFactoryBean jobDetails = new JobDetailFactoryBean();
        jobDetails.setJobClass(jobClass);
        jobDetails.setDurability(true);
        jobDetails.setApplicationContext(context);
        jobDetails.setName(quartzScheduleInfo.getName());
        jobDetails.setGroup(quartzScheduleInfo.getName());
        jobDetails.afterPropertiesSet();
        return jobDetails;
    }

    /*public SimpleTriggerFactoryBean createSimpleTrigger(QuartzScheduleInfo quartzScheduleInfo) {
        SimpleTriggerFactoryBean simpleTrigger = new SimpleTriggerFactoryBean();
        simpleTrigger.setName("Simple_Trigger");
        simpleTrigger.setStartTime(Date.parse(quartzScheduleInfo.getTime()));
        simpleTrigger.setRepeatInterval(2000);
        simpleTrigger.setRepeatCount(-1);
        simpleTrigger.setMisfireInstruction();
        simpleTrigger.afterPropertiesSet();
        return simpleTrigger;
    }*/

    public CronTriggerFactoryBean getCronTrigger(QuartzScheduleInfo quartzScheduleInfo) {
        CronTriggerFactoryBean cronTrigger = new CronTriggerFactoryBean();
        cronTrigger.setName(quartzScheduleInfo.getName());
        //cronTrigger.setName(quartzScheduleInfo.getTime());
        cronTrigger.setCronExpression(quartzScheduleInfo.getTime());
        //cronTrigger.setMisfireInstruction();
        try {
            cronTrigger.afterPropertiesSet();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cronTrigger;
    }

}
