package com.gmail.andersoninfonet.employeemanager.monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class LoggerService implements HealthIndicator {

    private static final String LOGGER_SERVICE = "Logger Service";

    @Override
    public Health health() {
        if(isLoggerHealthGood()) {
            return Health.up().withDetail(LOGGER_SERVICE, "Logger is running.").build();
        }

        return Health.down().withDetail(LOGGER_SERVICE, "Logger is down").build();
    }

    private boolean isLoggerHealthGood() {
        return true;
    }
    
}
