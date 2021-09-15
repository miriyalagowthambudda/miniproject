package com.ltts.mini_project.bo;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.mini_project.model.User;

@Repository
public class UserBo {

	@Autowired
	SessionFactory sf;
	
	public boolean insertUser(User u) {
		
		System.out.println("inside userBo beginning");
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
		s.close();
		System.out.println("outside userBo end");
		return false;
		
	}
	
	public User checkUserByEmail(String email) {
		User u =null;
		Session s= sf.openSession();
		//s.beginTransaction();
		Query q=s.createQuery("select u from User u where u.email  = :email");
		q.setParameter("email",email);
		List<User> u1=q.getResultList();
		if(u1==null)
			return null;
		//s.getTransaction().commit();
		return u1.get(0);
	}
	
	public boolean updateUser(User u) {
		Session s = sf.openSession();
		s.beginTransaction();
		s.saveOrUpdate(u);
		s.getTransaction().commit();
		s.close();
		return true;
	}
}
