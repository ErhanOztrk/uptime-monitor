package com.ops.monitor.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MonitorService {

    private final PingService pingService;

    private final Map<String, String> statusStore = new ConcurrentHashMap<>();

    private final List<String> urlsToMonitor = List.of(
            "https://github.com",
            "https://google.com",
            "https://this-website-is-fake-123.com"
    );

    public MonitorService(PingService pingService) {
        this.pingService = pingService;
    }

    @Scheduled(fixedRate = 10000)
    public void checkAllWebsites() {
        System.out.println("--- Starting Health Check ---");

        for (String url : urlsToMonitor) {
            String status = pingService.checkStatus(url);

            statusStore.put(url, status);

            System.out.println("Checked " + url + " | Status: " + status);
        }
    }

    public Map<String, String> getStatusStore() {
        return statusStore;
    }
}