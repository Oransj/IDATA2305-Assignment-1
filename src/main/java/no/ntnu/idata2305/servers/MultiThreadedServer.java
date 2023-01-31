package no.ntnu.idata2305.servers;

import no.ntnu.idata2305.computation.AsyncSearchSimulator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer implements Runnable {
  protected int serverPort = 8080;
  protected ServerSocket serverSocket = null;
  protected boolean isStopped = false;
  
  public MultiThreadedServer(int port) {
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
        Socket clientSocket = serverSocket.accept();
        System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());
        new Thread(
          new AsyncSearchSimulator(
            clientSocket, "Multithreaded Server"
          )
        ).start();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    System.out.println("Server stopped");
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
