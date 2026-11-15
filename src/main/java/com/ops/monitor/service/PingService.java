package com.ops.monitor.service;

import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

@Service
public class PingService {

    public String checkStatus(String urlAddress) {
        try {
            URL url = new URI(urlAddress).toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);

            int responseCode = connection.getResponseCode();

            if (responseCode >= 200 && responseCode < 300) {
                return "UP";
            } else {
                return "DOWN";
            }

        } catch (Exception e) {

            return "DOWN";
        }
    }
}