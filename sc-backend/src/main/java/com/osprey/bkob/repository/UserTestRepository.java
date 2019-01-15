package com.osprey.bkob.repository;

import com.osprey.bkob.domain.entities.TestUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserTestRepository extends CrudRepository<TestUser, Long> {

        List<TestUser> findByLastName(@Param("lastname") String lastname);

        List<TestUser> findByFirstName(@Param("firstname") String firstname);

        }
