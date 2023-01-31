package no.ntnu.idata2305.computation;

import java.net.Socket;

public class AsyncSearchSimulator implements Runnable {
  
  protected Socket clientSocket = null;
  protected String serverText = null;
  
  public AsyncSearchSimulator(Socket clientSocket, String serverText) {
    this.clientSocket = clientSocket;
    this.serverText = serverText;
  }
  
  public void processClientRequest() throws InterruptedException {
    long time1 = System.currentTimeMillis();
    System.out.println("Request processing started at: " + time1);
    Thread.sleep(10 * 1000);
    long time2 = System.currentTimeMillis();
    System.out.println("Request processing ended at: " + time2);
  }
  
  public void run() {
    try {
      processClientRequest();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}