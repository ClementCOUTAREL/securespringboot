package com.coutarel.securespringboot.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.coutarel.securespringboot.TestDataUtils;
import com.coutarel.securespringboot.domain.entities.AuthorEntity;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositoryIntegrationTest {

  private AuthorRepository authorRepository;

  @Autowired
  public AuthorRepositoryIntegrationTest(AuthorRepository authorRepository){
    this.authorRepository = authorRepository;
  }

  @Test
  public void testThatAuthorCanBeListed(){
    AuthorEntity authorA = TestDataUtils.createTestAuthorA();
    authorRepository.save(authorA);

    Iterable<AuthorEntity> result = authorRepository.findAll();
    assertNotNull(result);
  }

}
