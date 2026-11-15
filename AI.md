# AI Usage Log

I used AI (ChatGPT/Claude) as a technical mentor during this challenge.

**How I used it:**
* **Brainstorming:** I used AI to help me brainstorm project ideas that would be relevant
to a Junior DevOps role in a highly secure/banking environment.
* **Mental Models:** When I struggled to understand how the Spring Boot components talked
to each other, I asked the AI for real-world analogies. It gave me the
"Drive-Thru Window" model (Controller = Cashier, Service = Cook), which perfectly
clarified the architecture for me.
* **Syntax Guidance:** I used AI to help me find the correct syntax 
for `HttpURLConnection` to set a timeout, ensuring the application wouldn't hang forever
if a website was completely unresponsive.

**Verification:**
I verified the AI's suggestions by running the code locally, intentionally 
adding a fake/broken URL to the monitoring list to ensure the error-handling correctly
caught the failure and reported it as "DOWN" instead of crashing the application.