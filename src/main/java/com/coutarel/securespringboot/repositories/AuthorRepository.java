package com.coutarel.securespringboot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coutarel.securespringboot.domain.entities.AuthorEntity;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {

}
