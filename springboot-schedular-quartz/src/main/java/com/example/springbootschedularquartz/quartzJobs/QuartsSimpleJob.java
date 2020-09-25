package com.example.springbootschedularquartz.quartzJobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;
import static java.time.MonthDay.now;

@Component
public class QuartsSimpleJob extends QuartzJobBean {
//public class QuartsSimpleJob implements Job {

    //For NORMAL JAVA
    /*@Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            System.out.println("Job start...");
            System.out.println(now());
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        try {
            System.out.println("Job start..........\n");
            System.out.println(now());
            System.out.println("\n........ jobID: " + jobExecutionContext.getJobDetail().getKey());
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
