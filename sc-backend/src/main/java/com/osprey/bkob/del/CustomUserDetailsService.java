//package com.osprey.bkob.service;
//
//import javax.transaction.Transactional;
//
//import com.osprey.bkob.dto.UserDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.osprey.bkob.domain.entities.User;
//import com.osprey.bkob.repository.UserRepository;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	UserRepository userRepo;
//
//	@Override
//	@Transactional
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepo.findByUsernameOrEmail(username, username)
//				.orElseThrow(() -> new UsernameNotFoundException("User not found with username or email " + username));
//
//		return UserDto.create(user);
//	}
//
//	// This method is used by JWTAuthenticationFilte
//	@Transactional
//	public UserDetails loadUserById(Long id) {
//		User user = userRepo.findById(id)
//				.orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
//		return UserDto.create(user);
//	}
//
//}
