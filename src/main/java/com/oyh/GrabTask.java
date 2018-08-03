package com.oyh;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GrabTask implements Runnable {

	String BASE_URL = "http://www.xhj.com/ershoufang/pg";
	
	//页数
	int pageNumber;
	
    public GrabTask(int pageNumber) {
    	this.pageNumber = pageNumber;
    }
    
	public void run() {
		try {
			//http://www.xhj.com/ershoufang/pg103s2y1/    s2为两室  y1为住宅
			
			String url = BASE_URL + pageNumber + "s2y1/";
			Document doc = Jsoup.connect(url).get();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
