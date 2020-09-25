package com.example.springbootschedularquartz.quartzwithDb.controller;

import com.example.springbootschedularquartz.quartzwithDb.properties.QuartzScheduleInfo;
import com.example.springbootschedularquartz.quartzwithDb.services.impl.JobServiceImpl;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quartzJobs")
public class ScheduleJobsAPI {

    @Autowired
    public JobServiceImpl jobService;

    @PostMapping("/postJob")
    public void postJob(@RequestBody QuartzScheduleInfo quartzScheduleInfo) {
        try {
            jobService.register(quartzScheduleInfo);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
