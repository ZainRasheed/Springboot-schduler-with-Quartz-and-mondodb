package com.example.springbootschedularquartz.quartzwithDb.services.impl;

import com.example.springbootschedularquartz.quartzJobs.QuartsSimpleJob;
import com.example.springbootschedularquartz.quartzJobs.QuartsSimpleJob2;
import com.example.springbootschedularquartz.quartzwithDb.components.QuartzJobCreator;
import com.example.springbootschedularquartz.quartzwithDb.properties.QuartzScheduleInfo;
import com.example.springbootschedularquartz.quartzwithDb.services.IJobService;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class JobServiceImpl implements IJobService {

    @Autowired
    private SchedulerFactoryBean scheduler;

    @Autowired
    private QuartzJobCreator quartzJobCreator;

    @Autowired
    private ApplicationContext context;

    /*@PostConstruct
    public void someMethod() throws SchedulerException {
        System.out.println(scheduler.isRunning()+" --- "+ scheduler.isAutoStartup());
        try {
            System.out.println(">>>>>>>>>" + getJobDetails().getObject().getKey() + ">>>>>>" + getCronTrigger().getObject().getKey());
            scheduler.getScheduler().scheduleJob(getJobDetails().getObject(), getCronTrigger().getObject());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public void startAllSchedulers() {
        // Use MongoDB to get all tasks and schedule it
    }

    @Override
    public void register(QuartzScheduleInfo quartzScheduleInfo) throws SchedulerException {

        if (quartzScheduleInfo.isCronJob()) {
            scheduler.getScheduler().scheduleJob(
                    quartzJobCreator.createJob(QuartsSimpleJob.class, context, quartzScheduleInfo).getObject(),
                    quartzJobCreator.getCronTrigger(quartzScheduleInfo).getObject());
        } else {
            scheduler.getScheduler().scheduleJob(
                    quartzJobCreator.createJob(QuartsSimpleJob2.class, context, quartzScheduleInfo).getObject(),
                    quartzJobCreator.getCronTrigger(quartzScheduleInfo).getObject());
        }
    }

    @Override
    public void pause(String jobKey, String jobGroup) throws SchedulerException {
        scheduler.getScheduler().pauseJob(new JobKey(jobKey, jobGroup));
    }

    @Override
    public void resume(String jobKey, String jobGroup) throws SchedulerException {
        scheduler.getScheduler().resumeJob(new JobKey(jobKey, jobGroup));
    }

    @Override
    public void reschedule(String triggerKey, String triggerGroup, QuartzScheduleInfo quartzScheduleInfo) throws SchedulerException {
        scheduler.getScheduler().rescheduleJob(TriggerKey.triggerKey(triggerKey, triggerGroup), quartzJobCreator.getCronTrigger(quartzScheduleInfo).getObject());
    }

    @Override
    public void delete(String jobKey, String jobGroup) throws SchedulerException {
        scheduler.getScheduler().deleteJob(new JobKey(jobKey, jobGroup));
    }
}
