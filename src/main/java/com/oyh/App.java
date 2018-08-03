package com.oyh;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        
        try {
            ExecutorService pool = Executors.newCachedThreadPool();
            
            for (int i = 1; i <= 120; i++) {
            	pool.execute(new GrabTask(i));
            }
            
            //释放资源
            pool.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
