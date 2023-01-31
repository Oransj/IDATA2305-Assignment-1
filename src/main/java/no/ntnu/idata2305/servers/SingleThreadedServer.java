package no.ntnu.idata2305.servers;

import no.ntnu.idata2305.computation.SearchSimulator;
import no.ntnu.idata2305.utils.ResponseGenerator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedServer implements Runnable {

    protected int serverPort = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;

    public SingleThreadedServer(int port) {
        this.serverPort = port;
    }

    public void run() {
        try {
            openServerSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!isStopped()) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("New client connected: " + client.getInetAddress().getHostAddress());
                SearchSimulator.processClientRequest(serverSocket);
                String responseHeader = ResponseGenerator.generatorResponseHeader(0);
                String responseHTML = ResponseGenerator.generatorResponseHTML(0, 0);
                System.out.println(responseHeader + responseHTML);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Server Stopped.");
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop() {
        this.isStopped = true;
    }

    private void openServerSocket() throws IOException {
        serverSocket = new ServerSocket(serverPort);
    }
}
