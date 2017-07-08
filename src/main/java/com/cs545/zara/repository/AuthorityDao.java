package com.cs545.zara.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.cs545.zara.domain.Authority;
import com.cs545.zara.domain.PrimaryAccount;
import com.cs545.zara.domain.Role;

public interface AuthorityDao extends CrudRepository<Authority, Long>{
	
	Authority findByusername (String name);
}
