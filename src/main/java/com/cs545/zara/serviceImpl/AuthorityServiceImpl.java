package com.cs545.zara.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs545.zara.domain.Authority;
import com.cs545.zara.domain.User;
import com.cs545.zara.repository.AuthorityDao;
import com.cs545.zara.service.AuthorityService;



@Service
public class AuthorityServiceImpl implements AuthorityService{
 
	@Autowired
	public AuthorityDao authorityDao;
	
	@Override
	public void save(Authority authority) {
		authorityDao.save(authority);
		
		
		
	}


	@Override
	public Authority createAuth(String username) {
		Authority authority=new Authority(username,"ROLE_USER");
		save(authority);
		
		
		return authorityDao.findByusername(username);
	}

}
