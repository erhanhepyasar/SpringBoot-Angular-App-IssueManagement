package com.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.entity.User;

public interface UserService {
	
	User save(User user);	
	User getById(Long id);	
	Page<User> getAllPageable(Pageable pageable);
	User getByUsername(String username);

}
