package com.The360company.portfolio.inventorymanagement.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.The360company.portfolio.inventorymanagement.dao.UserRepository;
import com.The360company.portfolio.inventorymanagement.entity.User;
import com.The360company.portfolio.inventorymanagement.user.UserRegister;

@Service
public class UserServiceImpl implements UserService {

	// need to inject user repository
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	

	@Override
	public User findByUserName(String username) {
		// check the database if the user already exists
		return this.userRepository.findByUserName(username);
	}

	@Override
	public void save(UserRegister registerUser) {
		User user = new User();
		// assign user details to the user object
		user.setUserName(registerUser.getUserName());
		user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
		user.setFirstName(registerUser.getFirstName());
		user.setLastName(registerUser.getLastName());
		user.setEmail(registerUser.getEmail());
		
		this.userRepository.save(user);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");			
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), 
								new HashSet<GrantedAuthority>());
	}


	

}
