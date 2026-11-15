# AI Usage Log

I used AI tools as a learning mentor during this challenge.

### How I used AI
* **Brainstorming:** Discussed small, practical DevOps project ideas that fit a junior/trainee scope.
* **Mental Models:** Asked for simple analogies to understand how Spring Boot components connect (`Controller` -> `Service` -> `PingService`).
* **Troubleshooting:** Used AI to help understand Maven/IDE setup issues and how `HttpURLConnection` timeouts work.

### Incorrect or Unhelpful Suggestions
* An AI assistant initially gave me `setConnectTimeout` without `setReadTimeout`, which I added after reviewing how slow servers can hang.
* An AI assistant also generated a complex set of extra endpoints and advanced test setups. I rejected and reverted those changes because the challenge states not to submit code I cannot fully explain, and I wanted to keep total ownership of a small, clear codebase.

### How I verified suggestions
* Ran `./mvnw test` to verify `PingServiceTest` passes.
* Started the app locally, tested `http://localhost:8080/api/status` in Chrome, and included a fake URL (`https://this-website-is-fake-123.com`) to verify it safely reports `"DOWN"` instead of crashing.