package com.example.springbootschedularquartz.quartzwithDb.configuration;

import org.quartz.spi.InstanceIdGenerator;

import java.util.UUID;

public class CustomRandominstanceUUID implements InstanceIdGenerator {

    //Figure a way to add this as the Job ID
    @Override
    public String generateInstanceId() {
        return UUID.randomUUID().toString();
    }
}
