package com.coutarel.securespringboot.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDto {
  public Long id;
  public String name;
  public Integer age;
}
