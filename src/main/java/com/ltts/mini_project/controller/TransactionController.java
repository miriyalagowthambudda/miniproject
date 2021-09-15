package com.ltts.mini_project.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ltts.mini_project.bo.BusBo;
import com.ltts.mini_project.bo.TransactionBo;
import com.ltts.mini_project.bo.UserBo;
import com.ltts.mini_project.model.Bus;
import com.ltts.mini_project.model.Transaction;
import com.ltts.mini_project.model.User;

@RestController
public class TransactionController {
		
	@Autowired
	BusBo bb;
	
	@Autowired
	UserBo ub;
	
	@Autowired 
	TransactionBo tb;
	
	
	
	@RequestMapping("/bookticket")
	public ModelAndView m1(@RequestParam String email,Model model,HttpServletRequest request) {
		
		ModelAndView mv= new ModelAndView("bookticket");
		List<Bus> li = bb.findAll();
		model.addAttribute("list",li);
		model.addAttribute("email",email);
		return mv;
		
	}
	
	@RequestMapping(value="inserttransaction" ,method=RequestMethod.POST)
	public ModelAndView m2(HttpServletRequest request,Model model) {
		
		int id =Integer.parseInt(request.getParameter("bname"));
		LocalDate ld=LocalDate.parse(request.getParameter("t_date"));
		String status = request.getParameter("t_status");
		int noft=Integer.parseInt(request.getParameter("noft"));
		String email=request.getParameter("user_id");
		User u =ub.checkUserByEmail(email);
		int user_id=u.getId();
		Transaction t=new Transaction();
		t.setBus_id(id);
		t.setT_date(ld);
		t.setT_status(status);
		t.setNoOfTickets(noft);
		t.setUser_id(user_id);
		boolean b=tb.insertTrasaction(t);
		Optional<Bus> b11=bb.findById(id);
		if(b11.isPresent()) {
			Bus b12=b11.get();
			//b12.setAvailable(b12.getAvailable()-noft);
			if(b12.getAvailable()<0) {
				model.addAttribute("avail",b12.getAvailable());
				return new ModelAndView("availabletickets");
			}
			else {
				b12.setAvailable(b12.getAvailable()-noft);
				bb.save(b12);
				//model.addAttribute("message", "your ticket is booked successfully");
				//return new ModelAndView("success");
			}
		}
		
		if(b11.isPresent()) {
			Bus b22=b11.get();
			int totalcost=b22.getCost()*noft;
			model.addAttribute("totalcost",totalcost);
			return new ModelAndView("totalmoney");
		}
		if(b==false) {
			
			return new ModelAndView("success");
		}
		else {
			return new ModelAndView("error");
		}
		
	}
	
	
	
}
