package com.coutarel.securespringboot;

import com.coutarel.securespringboot.domain.entities.AuthorEntity;

public class TestDataUtils {

  public static AuthorEntity createTestAuthorA(){
    return AuthorEntity.builder().id(1L).name("Tolkien").age(50).build();
  }
}
