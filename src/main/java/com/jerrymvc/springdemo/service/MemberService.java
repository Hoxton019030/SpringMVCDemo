package com.jerrymvc.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jerrymvc.springdemo.model.Member;
import com.jerrymvc.springdemo.model.MemberDao;



@Service
@Transactional
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	public Member checkLogin(String loginName, String loginPwd) {
		Member tempMember = dao.findByNameAndPassword(loginName, loginPwd);
		
		if(tempMember != null) {
			return tempMember;
		}
		
		return null;
	}

}
