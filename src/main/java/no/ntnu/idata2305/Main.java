package no.ntnu.idata2305;

import no.ntnu.idata2305.servers.MultiThreadedServer;
import no.ntnu.idata2305.servers.SingleThreadedServer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting server...");
        MultiThreadedServer server = new MultiThreadedServer(8080);
        new Thread(server).start();
    }
}
