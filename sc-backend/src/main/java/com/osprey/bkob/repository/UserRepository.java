package com.osprey.bkob.repository;


import com.osprey.bkob.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, BaseRepository<User,Long> {
//
//	List<User> findByLastName(@Param("lastname") String lastname);
//
//	User findByFirstName(@Param("firstname") String firstname);
//
//
//	User findByToken(String token);
//
////	List<User> findByEmail(String email);
//
//    Optional<User> findByEmail(String email);
	Optional<User> findByuserName(String name);
	Optional<User> findByEmail(String email);
	Optional<User> findById(Long id);
	Optional<User> findByActivationCode(String code);
	Optional<User> findByCountry(String country);
//
//
//
////	Optional<User> findByUsernameOrEmail(String username, String email);
////
////    Boolean existsByUsername(String username);
////
////	Boolean existsByEmail(String email);
}