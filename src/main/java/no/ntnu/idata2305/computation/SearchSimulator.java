package no.ntnu.idata2305.computation;

import no.ntnu.idata2305.utils.ResponseGenerator;

import java.net.ServerSocket;

public class SearchSimulator {
    public static void processClientRequest(ServerSocket socket) throws Exception {
        long time1 = System.currentTimeMillis();
        System.out.println("Request processing started at: " + time1);
        Thread.sleep(10 * 1000);
        long time2 = System.currentTimeMillis();
        System.out.println("Request processing ended at: " + time2 + "\n");
    
        String responseHeader = ResponseGenerator.generatorResponseHeader(20);
        String responseHTML = ResponseGenerator.generatorResponseHTML(time1, time2);
        System.out.println(responseHeader + responseHTML);
    }
}