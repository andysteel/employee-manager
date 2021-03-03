package com.gmail.andersoninfonet.employeemanager.monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DatabaseService implements HealthIndicator {

    private static final String DATABASE_SERVICE = "Database Service";

    @Override
    public Health health() {
        if(isDatabaseHealthGood()) {
            return Health.up().withDetail(DATABASE_SERVICE, "Database is running.").build();
        }

        return Health.down().withDetail(DATABASE_SERVICE, "Database is down").build();
    }

    private boolean isDatabaseHealthGood() {
        return true;
    }
    
}
