package com.example.springbootschedularquartz.quartzwithDb.services;

import com.example.springbootschedularquartz.quartzwithDb.services.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ScheduleAllJobs implements ApplicationRunner {

    @Autowired
    private JobServiceImpl jobService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Schedule all new scheduler jobs at app startup - starting");
        try {
            jobService.startAllSchedulers();
            System.out.println("Schedule all new scheduler jobs at app startup - complete");
        } catch (Exception ex) {
            System.out.println("Schedule all new scheduler jobs at app startup - error " + ex);
        }
    }
}
