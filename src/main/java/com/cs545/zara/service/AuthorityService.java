package com.cs545.zara.service;

import com.cs545.zara.domain.Authority;
import com.cs545.zara.domain.User;

public interface AuthorityService {
	
	void save(Authority authority);
	Authority createAuth(String username);

}
