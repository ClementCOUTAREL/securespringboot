package com.coutarel.securespringboot.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.coutarel.securespringboot.domain.dto.AuthorDto;
import com.coutarel.securespringboot.domain.entities.AuthorEntity;
import com.coutarel.securespringboot.mappers.impl.AuthorMapper;
import com.coutarel.securespringboot.services.AuhtorService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class AuthorController {

  private AuhtorService authorService;

  private AuthorMapper authorMapper;
  
  public AuthorController(AuhtorService authorService, AuthorMapper authorMapper){
    this.authorService = authorService;
    this.authorMapper = authorMapper;
  }

  @GetMapping(path = "/authors")
  public List<AuthorDto> getAllAuthors() {
      List<AuthorEntity> authors = authorService.findAll();
      return authors.stream().map(authorMapper::mapTo).collect(Collectors.toList());
  }

  @PostMapping("/authors")
  public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
      AuthorEntity authorEntity = authorMapper.mapFrom(authorDto);
      AuthorEntity savedAuthor = authorService.saveAuthor(authorEntity);
      return new ResponseEntity<>(authorMapper.mapTo(savedAuthor),HttpStatus.CREATED);
  }
  
  
}
