package com.ltts.mini_project.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ltts.mini_project.bo.BusBo;
import com.ltts.mini_project.bo.UserBo;
import com.ltts.mini_project.model.Bus;
import com.ltts.mini_project.model.User;

@RestController
public class HomeController {
	
	@Autowired
	UserBo ub;
	
	@Autowired
	BusBo bb;
	
	@RequestMapping("/")
	public ModelAndView m0() {
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("/registration")
	public ModelAndView m1() {
		return new ModelAndView("registration");
		
	}
	
	@RequestMapping(value="insertuser" , method=RequestMethod.POST)
	public ModelAndView m2(HttpServletRequest request,Model model) {
		
		String name=request.getParameter("uname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mobile=request.getParameter("mobile");
		
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setMobile(mobile);
		u.setPassword(password);
		u.setRole("USER");
		boolean b = ub.insertUser(u);
		if(b==false) {
			return new ModelAndView("success");
		}
		else {
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping("/home")
	public ModelAndView m3() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/login")
	public ModelAndView m5() {
		
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="checkuser")
	public ModelAndView m4(HttpServletRequest request,Model model) {
		
		ModelAndView mv = null;
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User u =ub.checkUserByEmail(email);
		System.out.println("user is null" +u);
		if(u.equals(null)) {
			model.addAttribute("msg","your username is wrong");
			mv=new ModelAndView("login");
		}
		else if(u.getEmail().equals(email)) {
			if(password.equals(u.getPassword())) {
			model.addAttribute("name",u.getName());
			model.addAttribute("email",u.getEmail());
			mv=new ModelAndView("welcome");
		}
			else {
				model.addAttribute("msg","your password is wrong");
				mv=new ModelAndView("login");
			}
		}
		
		else {
			model.addAttribute("msg","your username is wrong");
			mv=new ModelAndView("login");
		}
		return mv;
		
	}
	
	@RequestMapping("/updateuser")
	public ModelAndView m5(@RequestParam String email,Model model) {
		
		ModelAndView mv = new ModelAndView("updateuser");
		User u = ub.checkUserByEmail(email);
		model.addAttribute("user",u);
		return mv;
	}
	
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ModelAndView m6(HttpServletRequest request,Model model)
	{
		ModelAndView mv=null;
		String name=request.getParameter("uname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mobile=request.getParameter("mobile");
		
		User  u= ub.checkUserByEmail(email);
		u.setName(name);
		u.setEmail(email);
		u.setMobile(mobile);
		u.setPassword(password);
		u.setRole(request.getParameter("utype"));
		
		
		boolean b = ub.updateUser(u);
		if(b==false) {
			mv=new ModelAndView("error");
		}
		else {
			model.addAttribute("msg","successfully updated...");
			mv=new ModelAndView("success");
		}
		
		return mv;
	}
	
	
	@RequestMapping("/addbus")
	public ModelAndView m7() {
		return new ModelAndView("addbus");
	}
	
	
	@RequestMapping(value="insertbus",method=RequestMethod.POST)
	public ModelAndView m8(HttpServletRequest request,@RequestParam MultipartFile file) throws IOException {
		
		String name=request.getParameter("bname");
		LocalDate ld=LocalDate.parse(request.getParameter("start_date"));
		LocalTime lt=LocalTime.parse(request.getParameter("start_time"));
		int total_seats=Integer.parseInt(request.getParameter("nofs"));
		int available=Integer.parseInt(request.getParameter("avail"));
		String fromC=request.getParameter("fromC");
		String toC=request.getParameter("toC");
		String btype=request.getParameter("btype");
		int cost=Integer.parseInt(request.getParameter("cost"));
		System.out.println(request.getParameter("file"));
		//byte[] bt= file.getBytes();
		//String image= new org.apache.commons.codec.binary.Base64().encodeAsString(bt);
		 byte barr[]=file.getBytes();  
         
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream("C:\\Users\\gowthambudda\\Documents\\images"+File.separator+file.getOriginalFilename()));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close(); 
	 
		
		System.out.println(file.getOriginalFilename());
		System.out.println( name + "$$" + ld +"$$" + lt +"$$" + total_seats + "$$" + available + "$$" + fromC +"$$" + toC + "$$" + btype +"$$" +cost);
		
		Bus b= new Bus();
		b.setImage("C:\\Users\\gowthambudda\\Documents\\images"+File.separator+file.getOriginalFilename());
		b.setBusName(name);
		b.setStartDate(ld);
		b.setStartTime(lt);
		b.setNumOfSeats(total_seats);
		b.setAvailable(available);
		b.setFromC(fromC);
		b.setToC(toC);
		b.setBtype(btype);
		b.setCost(cost);
		bb.save(b);
		System.out.println(b);
		return new ModelAndView("success");
		
	}
	
	@RequestMapping("/viewbusses")
	public ModelAndView m9(Model model) {
		
		ModelAndView mv = new ModelAndView("viewbusses");
		List<Bus> li = bb.findAll();
		model.addAttribute("list",li);
		return mv;
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)public void showImage(@RequestParam("id") Integer itemId, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{

		
	   // Item item = itemService.get(itemId);   
		Optional<Bus> sk=bb.findById(itemId);
		if(sk.isPresent()) {
			//BufferedReader bf= new BufferedReader(new FileReader(sk.get().getImage()));
			if(sk.get().getImage()!=null) {
			File file=new File(sk.get().getImage());
			byte[] fileContent = Files.readAllBytes(file.toPath());
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		    response.getOutputStream().write(fileContent);
		}
		}
	    response.getOutputStream().close();
	}
	
	
	
}
