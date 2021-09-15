package com.ltts.mini_project.bo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltts.mini_project.model.Bus;

@Repository
public interface BusBo extends JpaRepository<Bus,Integer>{
	
	

}
