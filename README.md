# Uptime API Health Monitor

### What I built and why
I built a lightweight Spring Boot REST API that acts as an automated Uptime Health Monitor.
It runs a background scheduled task to ping a list of critical URLs every 10 seconds, 
checks their HTTP status codes, and exposes a live dashboard via a REST endpoint.

I chose this project because monitoring infrastructure reliability and uptime is a core
responsibility for DevOps engineers, especially in high-stakes environments like banking.

### How to run it
1. Ensure you have Java 17 (or higher) and Maven installed.
2. Clone this repository.
3. Run the application using your IDE or via the command line: `./mvnw spring-boot:run`
4. Open a web browser and navigate to: `http://localhost:8080/api/status`

### How it works
1. **The Scout (`PingService`):** Uses standard `java.net.HttpURLConnection` to send a GET
request to a URL. If it receives a 200-level response, it returns "UP". Otherwise,
it catches the exception and returns "DOWN".
2. **The Manager (`MonitorService`):** Uses Spring's `@Scheduled` annotation to wake up 
every 10 seconds, iterate through a list of URLs, send the Scout, and store the results
in a thread-safe `ConcurrentHashMap`.
3. **The API (`HealthController`):** Exposes a `@GetMapping` endpoint that reads 
the HashMap and returns the live status as a JSON object to the user.

### What I would improve with more time
* **Database Integration:** Currently, state is held in memory (HashMap).
I would integrate PostgreSQL via Spring Data JPA to persist historical health checks,
allowing us to calculate "99.9% Uptime" metrics over a 30-day period.
* **Alerting System:** I would add a webhook integration so that if a service returns 
"DOWN" three times in a row, it automatically sends an alert to a Slack channel or PagerDuty.
* **Dynamic Configuration:** Move the hardcoded list of URLs into an `application.yml` file
or a database table so they can be updated without recompiling the code.