package com.ltts.mini_project.model;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Component
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Bus {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String busName;
	private LocalDate startDate;
	private LocalTime startTime;
	private int numOfSeats;
	private int available;
	private String fromC;
	private String toC;
	private String btype;
	private int cost;
	//@Column(columnDefinition = "blob")
	private String image;
	
	
	public Bus() {
		super();
	}


	public Bus(int id, String busName, LocalDate startDate, LocalTime startTime, int numOfSeats, int available,
			String fromC, String toC, String btype, int cost, String image) {
		super();
		this.id = id;
		this.busName = busName;
		this.startDate = startDate;
		this.startTime = startTime;
		this.numOfSeats = numOfSeats;
		this.available = available;
		this.fromC = fromC;
		this.toC = toC;
		this.btype = btype;
		this.cost = cost;
		this.image = image;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBusName() {
		return busName;
	}


	public void setBusName(String busName) {
		this.busName = busName;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}


	public int getNumOfSeats() {
		return numOfSeats;
	}


	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}


	public int getAvailable() {
		return available;
	}


	public void setAvailable(int available) {
		this.available = available;
	}


	public String getFromC() {
		return fromC;
	}


	public void setFromC(String fromC) {
		this.fromC = fromC;
	}


	public String getToC() {
		return toC;
	}


	public void setToC(String toC) {
		this.toC = toC;
	}


	public String getBtype() {
		return btype;
	}


	public void setBtype(String btype) {
		this.btype = btype;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Bus [id=" + id + ", busName=" + busName + ", startDate=" + startDate + ", startTime=" + startTime
				+ ", numOfSeats=" + numOfSeats + ", available=" + available + ", fromC=" + fromC + ", toC=" + toC
				+ ", btype=" + btype + ", cost=" + cost + ", image=" + image + "]";
	}


	
	
	
}
