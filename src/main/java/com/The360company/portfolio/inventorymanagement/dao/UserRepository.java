package com.The360company.portfolio.inventorymanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.The360company.portfolio.inventorymanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String username);
	
}
