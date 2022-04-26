package com.jerrymvc.springdemo.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GoodPhotoDao {
	
	@Autowired
	private SessionFactory factory;
	
	public GoodPhoto saveGoodPhoto(GoodPhoto gp) {
		Session session = factory.getCurrentSession();
		session.save(gp);
		
		return gp;
	}

}
