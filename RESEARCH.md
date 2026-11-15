# Research & Decisions Log

### What I Needed to Learn & Why
Since I wanted to build a small, reliable tool that I understand, I focused on three core areas:
* **HTTP Requests in Java:** How to check if a URL is online without adding heavy external libraries.
* **Scheduled Tasks:** How to make Spring Boot run a check automatically in the background.
* **External Input:** How to read a list of URLs from `application.yaml` so users do not have to edit Java code to monitor new sites.

### Where I Looked & How I Assessed Information
* I checked the official **Spring Boot documentation** to learn how `@Scheduled` and `@Value` work.
* I checked the **Oracle JavaDocs** for `HttpURLConnection` to understand how connection timeouts work. I chose `HttpURLConnection` because it is built into Java and keeps the project simple.

### Problems & Approaches That Didn't Work
1. **Hardcoded URLs:** At first, I wrote the 3 URLs directly inside `MonitorService.java`. I realized this did not allow real user input, so I moved them to `application.yaml` using `@Value`.
2. **Hanging Connections:** Initially, I only added `setConnectTimeout(3000)`. While reviewing failure modes, I realized a server could accept a connection and then freeze before replying. I added `setReadTimeout(3000)` to prevent the app from hanging.
3. **Thread Safety:** Because the `@Scheduled` background timer writes to the map while the web controller reads from it, a normal `HashMap` is not thread-safe. I switched to `ConcurrentHashMap` so both can access it safely.