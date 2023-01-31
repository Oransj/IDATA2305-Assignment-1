# How to run the code

1. In your IDE by choice, press the run button next to the main method
2. Send an HTTP request to the server, which is on port 8080. This can be done, for example, in a web-browser use the url localhost:8080
3. The server will print its response in the terminal.

# Observations
We have observed that when connecting multiple clients to a single threaded
server, the server will only be able to handle one client at a time. It also
needs to wait for the client to finish before it can handle the next client.

When running the multithreaded server, we observed that it was able to handle
multiple clients at the same time and that it did not need to wait for a task to finish
before starting a new task for another client.
