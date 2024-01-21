package com.coutarel.securespringboot.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.coutarel.securespringboot.domain.dto.AuthorDto;
import com.coutarel.securespringboot.domain.entities.AuthorEntity;
import com.coutarel.securespringboot.repositories.AuthorRepository;
import com.coutarel.securespringboot.services.AuhtorService;

@Service
public class AuthorServiceImpl implements AuhtorService {

  private AuthorRepository authorRepo;

  public AuthorServiceImpl(AuthorRepository authorRepo){
    this.authorRepo = authorRepo;
  }

  @Override
  public List<AuthorEntity> findAll() {
    return StreamSupport.stream(authorRepo.findAll().spliterator(), false).collect(Collectors.toList());
  }

  @Override
  public AuthorEntity saveAuthor(AuthorEntity author) {
    return authorRepo.save(author);
  }

}
