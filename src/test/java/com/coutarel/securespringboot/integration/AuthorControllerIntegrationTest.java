package com.coutarel.securespringboot.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import com.coutarel.securespringboot.TestDataUtils;
import com.coutarel.securespringboot.domain.entities.AuthorEntity;
import com.coutarel.securespringboot.mappers.impl.AuthorMapper;
import com.coutarel.securespringboot.services.AuhtorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class AuthorControllerIntegrationTest {

  private AuhtorService authorService;

  private AuthorMapper authorMapper;

  private MockMvc mockMvc;

  private ObjectMapper objectMapper;
  
  @Autowired
  public AuthorControllerIntegrationTest(AuhtorService authorService, AuthorMapper authorMapper, MockMvc mockMvc) {
    this.authorService = authorService;
    this.authorMapper = authorMapper;
    this.mockMvc = mockMvc;
    this.objectMapper = new ObjectMapper();
  }

  @Test
  public void testThatCreateAuthorReturnsStatus200WhenAuthorIsSubmitted() throws Exception{
    AuthorEntity authorEntity = TestDataUtils.createTestAuthorA();
    AuthorEntity savedAuthorEntity = authorService.saveAuthor(authorEntity);
    String savedAuthorJson = objectMapper.writeValueAsString(savedAuthorEntity);

    mockMvc.perform(
      MockMvcRequestBuilders.post("/authors").contentType(MediaType.APPLICATION_JSON).content(savedAuthorJson)
    ).andExpect(
      MockMvcResultMatchers.status().isCreated()
    );
  }

  @Test
  public void testThatCreateAuthorReturnsSavedAuthorWhenAuthorIsSubmitted() throws Exception {
    AuthorEntity authorEntity = TestDataUtils.createTestAuthorA();
    AuthorEntity savedAuthorEntity = authorService.saveAuthor(authorEntity);
    String savedAuthorJson = objectMapper.writeValueAsString(savedAuthorEntity);

    mockMvc.perform(
        MockMvcRequestBuilders.post("/authors").contentType(MediaType.APPLICATION_JSON).content(savedAuthorJson))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.id").value(savedAuthorEntity.getId()))
          .andExpect(
            MockMvcResultMatchers.jsonPath("$.name").value(savedAuthorEntity.getName()))
          .andExpect(
            MockMvcResultMatchers.jsonPath("$.age").value(savedAuthorEntity.getAge())
          );
  }

  @Test
  public void testThatGetAllAuthorsReturns200Status() throws Exception{   
    mockMvc.perform(
      MockMvcRequestBuilders.get("/authors").contentType(MediaType.APPLICATION_JSON)
    ).andExpect(
      MockMvcResultMatchers.status().isOk()
    );
  }

  @Test
  public void testThatGetAllAuthorsReturnsSavedAuthors() throws Exception {
    AuthorEntity authorA = TestDataUtils.createTestAuthorA();
    authorService.saveAuthor(authorA);
    
    mockMvc.perform(
        MockMvcRequestBuilders.get("/authors").contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.[0].id").value(authorA.getId())
          )
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.[0].name").value(authorA.getName())
            )
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.[0].age").value(authorA.getAge()));;
  }
  
}
