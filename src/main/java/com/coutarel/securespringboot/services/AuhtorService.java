package com.coutarel.securespringboot.services;

import java.util.List;

import com.coutarel.securespringboot.domain.entities.AuthorEntity;

public interface AuhtorService {
  List<AuthorEntity> findAll();

  AuthorEntity saveAuthor(AuthorEntity authorDto);
}
