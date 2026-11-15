# Research & Decisions Log

### The Initial Approach: Over-Engineering
When I first received this challenge, I wanted to build something highly ambitious.
I started researching and building an "Infrastructure Drift Reconciler" using advanced
architectural patterns (O(n) time complexity, pure functions, strict state vectors).

### The Pivot: Choosing Ownership Over Complexity
After a few days, I realized I was relying too heavily on complex concepts that were 
slightly beyond my current level of expertise to fully own and defend.
The challenge prompt stated: *"A small, well-designed project that you fully understand
is better than a large project that you don't."*

I made the engineering decision to pull the emergency brake. I pivoted to building
this **Uptime Health Monitor**.

**Why I made this decision:**
1. **DevOps Relevance:** Monitoring uptime is a fundamental DevOps task.
2. **Total Ownership:** By keeping the architecture simple (an MVP without a database),
I can confidently explain every single line of code, how the HTTP connections work,
and why I chose a `ConcurrentHashMap` for thread-safe memory storage.

### Technical Learnings
* **HTTP Connections:** I learned how to use Java's native `HttpURLConnection` 
to make web requests and evaluate HTTP status codes without needing heavy external libraries.
* **Spring Scheduling:** I researched how to automate background tasks in Spring Boot
using the `@EnableScheduling` and `@Scheduled` annotations.
* **Thread Safety:** Because the background timer is writing to the map at the same time
the REST API might be reading from it, I learned that a standard `HashMap` could crash.
I researched and implemented a `ConcurrentHashMap` to ensure thread safety.