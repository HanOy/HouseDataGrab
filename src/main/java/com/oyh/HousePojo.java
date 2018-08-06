package com.oyh;

import java.math.BigDecimal;

public class HousePojo {
	
	private Integer id;
	
	//室
	private Integer room;
	
	//厅
	private Integer hall;
	
	//卫
	private Integer toilet;
	
	//小区
	private String community;
	
	//面积
	private BigDecimal area;
	
	//价格
	private BigDecimal price;
	
	//每平米价格
	private BigDecimal average;
	
	//建筑年代
	private String year;
	
	//层
	private String floor;
	
	//区
	private String district;
	
	//地址
	private String address;
	
	//是否近地铁
	private Integer subway;
	
	//是否电梯
	private Integer elevator;
	
	//是否随时看房
	private Integer visit;
	
	//详情链接
	private String href;

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public BigDecimal getAverage() {
		return average;
	}

	public void setAverage(BigDecimal average) {
		this.average = average;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	public Integer getHall() {
		return hall;
	}

	public void setHall(Integer hall) {
		this.hall = hall;
	}

	public Integer getToilet() {
		return toilet;
	}

	public void setToilet(Integer toilet) {
		this.toilet = toilet;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getSubway() {
		return subway;
	}

	public void setSubway(Integer subway) {
		this.subway = subway;
	}

	public Integer getElevator() {
		return elevator;
	}

	public void setElevator(Integer elevator) {
		this.elevator = elevator;
	}

	public Integer getVisit() {
		return visit;
	}

	public void setVisit(Integer visit) {
		this.visit = visit;
	}
}
