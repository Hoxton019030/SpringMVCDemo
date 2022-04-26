package com.jerrymvc.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerrymvc.springdemo.model.GoodPhoto;
import com.jerrymvc.springdemo.model.GoodPhotoDao;

@Service
public class GoodPhotoService {
	
	@Autowired
	private GoodPhotoDao goodPhotoDao;
	
	public GoodPhoto insertGoodPhoto(GoodPhoto gp) {
		return goodPhotoDao.saveGoodPhoto(gp);
	}

}
