package com.example.springbootschedularquartz.quartzwithDb.services;

import com.example.springbootschedularquartz.quartzwithDb.properties.QuartzScheduleInfo;
import org.quartz.SchedulerException;

public interface IJobService {

    void startAllSchedulers();

    void register(final QuartzScheduleInfo quartzScheduleInfo) throws SchedulerException;

    void pause(final String jobKey, final String jobGroup) throws SchedulerException;

    void resume(final String jobKey, final String jobGroup) throws SchedulerException;

    void reschedule(final String triggerKey, final String triggerGroup,  final QuartzScheduleInfo quartzScheduleInfo) throws SchedulerException;

    void delete(final String jobKey, final String jobGroup) throws SchedulerException;

}
