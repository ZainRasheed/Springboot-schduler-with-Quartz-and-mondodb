package com.example.springbootschedularquartz.quartzwithDb.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Setter
@Getter
@Document(collection = "quartzInfo")
public class QuartzScheduleInfo {

    private String scheduleJobId = UUID.randomUUID().toString();

    private String name;

    private String time;

    private String status;

    private boolean cronJob;
}
