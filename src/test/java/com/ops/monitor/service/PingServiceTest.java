package com.ops.monitor.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PingServiceTest {

    private final PingService pingService = new PingService();

    @Test
    void shouldReturnUpForHealthyWebsite() {
        String status = pingService.checkStatus("https://github.com");
        assertEquals("UP", status);
    }

    @Test
    void shouldReturnDownForBrokenWebsite() {
        String status = pingService.checkStatus("https://this-website-is-fake-123456789.com");
        assertEquals("DOWN", status);
    }
}