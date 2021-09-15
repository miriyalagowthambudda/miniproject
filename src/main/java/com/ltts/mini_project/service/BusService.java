package com.ltts.mini_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltts.mini_project.bo.BusBo;
import com.ltts.mini_project.model.Bus;

@Service
public class BusService {
	
	@Autowired
	BusBo bb;
	
	public Bus insertBus(Bus b) {
		return bb.save(b);
	}
	
	public List<Bus> getAllBusses(){
		return bb.findAll();
	}
	
	public Bus getById(int id) {
		return bb.getById(id);
	}
	
	public void saveOrUpdate(Bus b) {
		bb.save(b);
	}
	
	public void delete(int id) {
		bb.deleteById(id);
	}
	
	public void update(Bus b,int id) {
		
		bb.save(b);
	}
}
