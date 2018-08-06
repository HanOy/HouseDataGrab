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
            JdbcUtils jdbc = new JdbcUtils();
            jdbc.getConnection();
            
            for (int i = 1; i <= 123; i++) {
            	pool.execute(new GrabTask(i, jdbc));
            }
            
            jdbc.releaseConn();
            //释放资源
            pool.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
