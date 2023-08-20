package com.angga.postr.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.angga.postr.api.entity.UserRepository;
import com.angga.postr.api.model.UserDetailsImpl;

/**
 * This class used for bridge of services between entities and repository
 * 
 * @author Angga Bayu Sejati<anggabs86@gmail.com>
 */
@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	/**
	 * override loadUserByUsername
	 * 
	 * @return UserDetails
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// defensive strategy --> prevent blank `username`
		if (username.trim().equalsIgnoreCase("")) {
			new UsernameNotFoundException("Username cannot be blank!");
		}

		// Get username value
		var userData = userRepository.findByUsername(username);
		userData.orElseThrow(()-> new UsernameNotFoundException("Invalid `username` credential!"));

		return userData.map(UserDetailsImpl::new).get();
	}
}
