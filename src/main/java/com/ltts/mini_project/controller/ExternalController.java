package com.ltts.mini_project.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltts.mini_project.bo.BusBo;
import com.ltts.mini_project.model.Bus;
import com.ltts.mini_project.service.BusService;

@RestController
public class ExternalController {
	
	@Autowired
	BusBo bb;
	
	@Autowired 
	BusService bs;
	
	@GetMapping("/external/busses")
	public List<Bus> getBusses(){
		return bs.getAllBusses();
	}
	
	@GetMapping("/external/busses/{id}")
	public Bus getBusById(@PathVariable int id) {
		return bs.getById(id);
	}
	
	@PostMapping("external/busses")
	public Bus insertBus(Bus b) {
		return bs.insertBus(b);
	}
	
	@PutMapping("external/busses")
	public Bus updateBus(Bus b) {
		return bs.insertBus(b);
	}
	
	@DeleteMapping("external/busses/{id}")
	public void deleteBus(@PathVariable int id) {
		bs.delete(id);
		
	}
	

}
