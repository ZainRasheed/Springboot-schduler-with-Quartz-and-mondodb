package com.example.springbootschedularquartz;

import com.example.springbootschedularquartz.quartzJobs.QuartsSimpleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.PostConstruct;

@SpringBootApplication
//@EnableScheduling
public class SpringbootSchedularQuartzApplication {

	@Autowired
	private SchedulerFactoryBean factoryBean;

	public static void main(String[] args) throws SchedulerException {
		SpringApplication.run(SpringbootSchedularQuartzApplication.class, args);


		/**
		 * For normal java
		 *
		 * 1. QuartzJob
		 * 2. Trigger
		 * 		- Simple
		 * 		- Cron
		 * 3. Scheduler
		 */
		//Create job detail and attach a job class
/*
		JobDetail jobDetail = JobBuilder.newJob(QuartsSimpleJob.class).build();

		//Create a SIMPLE trigger
		//RUNs only ONCE
		Trigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity("Simple trigger").startNow().build();

		//Create a SIMPLE trigger
		//RUNs FIVE times
		Trigger simpleTrigger2 = TriggerBuilder.newTrigger().withIdentity("Simple trigger").withSchedule(
				SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(5)
		).build();

		//Create a CRON trigger
		//RUNs every 5sec
		Trigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("CRON trigger").withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

		//Create a scheduler
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, simpleTrigger2);
*/
	}
}
