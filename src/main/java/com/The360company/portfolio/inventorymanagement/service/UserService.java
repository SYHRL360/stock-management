package com.The360company.portfolio.inventorymanagement.service;



import org.springframework.security.core.userdetails.UserDetailsService;

import com.The360company.portfolio.inventorymanagement.entity.User;
import com.The360company.portfolio.inventorymanagement.user.UserRegister;

public interface UserService extends UserDetailsService{

	public User findByUserName(String username);
	
	public void save(UserRegister registerUser);
	
}
