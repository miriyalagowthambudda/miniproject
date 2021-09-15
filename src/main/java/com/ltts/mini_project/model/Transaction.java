package com.ltts.mini_project.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private LocalDate t_date;
	private String t_status;
	private int noOfTickets;
	private int user_id;
	private int bus_id;
	
	public Transaction() {
		super();
	}

	public Transaction(int id, LocalDate t_date, String t_status, int noOfTickets, int user_id, int bus_id) {
		super();
		this.id = id;
		this.t_date = t_date;
		this.t_status = t_status;
		this.noOfTickets = noOfTickets;
		this.user_id = user_id;
		this.bus_id = bus_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getT_date() {
		return t_date;
	}

	public void setT_date(LocalDate t_date) {
		this.t_date = t_date;
	}

	public String getT_status() {
		return t_status;
	}

	public void setT_status(String t_status) {
		this.t_status = t_status;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getBus_id() {
		return bus_id;
	}

	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", t_date=" + t_date + ", t_status=" + t_status + ", noOfTickets="
				+ noOfTickets + ", user_id=" + user_id + ", bus_id=" + bus_id + "]";
	}
	
	
	
	
}
