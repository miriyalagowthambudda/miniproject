package com.ltts.mini_project.bo;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.mini_project.model.Bus;
import com.ltts.mini_project.model.Transaction;
import com.ltts.mini_project.model.User;


@Repository
public class TransactionBo  {
	
	@Autowired
	SessionFactory sf;
	
	public boolean insertTrasaction(Transaction t) {
		System.out.println("inside TransactionBo beginning");
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(t);
		s.getTransaction().commit();
		s.close();
		System.out.println("outside TransactionBo end");
		return false;
	}
	
	

}
