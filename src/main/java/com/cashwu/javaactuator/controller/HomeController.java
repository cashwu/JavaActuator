package com.cashwu.javaactuator.controller;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cash.wu
 * @since 2024/05/31
 */
@RestController
public class HomeController {

    private MeterRegistry meterRegistry;

    public HomeController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/")
    public String Home() {

        meterRegistry.counter("home", "index", "123").increment();

        return "Hello World";
    }
}
