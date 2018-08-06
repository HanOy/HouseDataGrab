package com.oyh;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GrabTask implements Runnable {

	final private static String BASE_URL = "http://www.xhj.com";
	
	//页数
	int pageNumber;
	
    public GrabTask(int pageNumber) {
    	this.pageNumber = pageNumber;
    }
    
	public void run() {
		try {
			//http://www.xhj.com/ershoufang/pg103s2y1/    s2为两室  y1为住宅
			
			String url = BASE_URL + "/ershoufang/pg" + pageNumber + "s2y1/";
			Document doc = Jsoup.connect(url).get();
			
			Elements list = doc.select(".lp_list .lp_wrap");
			
			List<HousePojo> resultList = new ArrayList<HousePojo>();
			
			for (Element element : list) {
				HousePojo house = wrapElement2Pojo(element);
				
				resultList.add(house);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static HousePojo wrapElement2Pojo(Element element) {
		HousePojo house = new HousePojo();
		//2室1厅1卫  |  62.28㎡  
		String desc = element.select(".font14").html();
		String houseType = desc.split("\\|")[0].trim();
		String area = desc.split("\\|")[1].trim();
		
		house.setHall(Integer.parseInt(houseType.substring(0, 1)));
		house.setRoom(Integer.parseInt(houseType.substring(2, 3)));
		house.setToilet(Integer.parseInt(houseType.substring(4, 5)));
		
		house.setArea(new BigDecimal(area.replace("㎡", "")));
		
		house.setCommunity(element.select(".yihao>span").get(0).text());
		
		house.setDistrict(element.select(".lp_dizhi").text().split("[【】]+")[1]);
		house.setAddress(element.select(".lp_dizhi").text().replaceAll("\\s*", "").trim());
		
		house.setPrice(new BigDecimal(element.select(".lp_jia>span").text().trim()));
		house.setAverage(new BigDecimal(element.select(".rg").text().trim().replace("元/㎡", "")));
		
		house.setFloor(element.select(".gaoceng").text().replaceAll("\\s*", "").trim().split("\\|")[0]);
		house.setYear(element.select(".gaoceng").text().replaceAll("\\s*", "").trim().split("\\|")[1].replace("建筑年代：", "").replace("年", ""));
		
		house.setSubway(0);
		house.setElevator(0);
		house.setVisit(0);
		
		Elements biaoqians = element.select(".biaoqian");
		for (Element biaoqian : biaoqians) {
			if (biaoqian.hasClass("a002")) {
				house.setElevator(1);
				break;
			}
			if (biaoqian.hasClass("a001")) {
				house.setVisit(1);
				break;
			}
			if (biaoqian.hasClass("a")) {
				house.setSubway(1);
			}
		}
		
		house.setHref(BASE_URL + element.select(".heading").attr("href"));
		return house;
	}

	public static void main(String[] args) throws IOException {
		String url = BASE_URL + "/ershoufang/pg1s2y1/";
		Document doc = Jsoup.connect(url).get();
		
		Elements list = doc.select(".lp_list .lp_wrap");
		Element e = list.get(0);
		HousePojo house = wrapElement2Pojo(e);
		
		System.out.println(house.getAddress());
	}
}
