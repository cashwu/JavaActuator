package com.cashwu.javaactuator.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Calendar;

/**
 * @author cash.wu
 * @since 2024/05/31
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if (hour > 12) {
            return Health.outOfService().withDetail("reason", "i am out of service after lunchtime")
                         .withDetail("hour", hour).build();
        }

        if (Math.random() <= 0.1) {
            return Health.down().withDetail("reason", "i break 10% of the time")
                    .build();
        }

        return Health.up()
                .withDetail("reason", "all is good").build();
    }
}
