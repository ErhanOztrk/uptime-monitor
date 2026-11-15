package com.ops.monitor.controller;

import com.ops.monitor.service.MonitorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealthController {

    private final MonitorService monitorService;

    public HealthController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @GetMapping("/status")
    public Map<String, String> getStatus() {
        return monitorService.getStatusStore();
    }
}