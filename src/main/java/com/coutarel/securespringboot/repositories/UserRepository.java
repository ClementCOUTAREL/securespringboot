package com.coutarel.securespringboot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coutarel.securespringboot.domain.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
