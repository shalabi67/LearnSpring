package com.learn.springboot.configuration.health;

import com.justgifit.JustGifItProperties;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by mohammad on 10/20/2017.
*/
@Component
public class JustGifItHealthIndicator implements HealthIndicator {
    @Inject
    private JustGifItProperties properties;


    @Override
    public Health health() {
        if (!properties.getGifLocation().canWrite()) {
            return Health.down().build();
        }

        return Health.up().build();
    }
}
