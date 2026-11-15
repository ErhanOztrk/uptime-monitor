# Uptime API Health Monitor

### What I built and why
I built a small Spring Boot REST API that checks whether websites are online. Every 10 seconds, a background task pings a list of URLs, checks their HTTP status codes, and shares the latest results at a web endpoint.

I chose this project because monitoring service uptime is a common, practical DevOps task.

### How to run it
1. Ensure you have Java 21 installed.
2. Clone this repository.
3. Run the application from your IDE or terminal: `./mvnw spring-boot:run`
4. Open a browser and visit: `http://localhost:8080/api/status`

### How it works
1. **Input (`application.yaml`):** Holds the list of URLs to check so users can change them without editing Java code.
2. **The Checker (`PingService`):** Uses Java's built-in `HttpURLConnection` to send a `GET` request with a 3-second connect and read timeout. A 200-level response returns `"UP"`; errors or timeouts return `"DOWN"`.
3. **The Scheduler (`MonitorService`):** Uses `@Scheduled` to run every 10 seconds and stores results in a `ConcurrentHashMap` (safe for background writes and web reads).
4. **The API (`HealthController`):** Exposes `GET /api/status` and returns the map as JSON.

### What I would improve with more time
* **Database Storage:** Save check history in PostgreSQL instead of memory so uptime percentages are not lost on restart.
* **Alerting:** Send an email or Slack alert if a website stays `"DOWN"` across multiple checks.
* **Runtime API Input:** Add a `POST` endpoint so users can add new URLs while the app is running.