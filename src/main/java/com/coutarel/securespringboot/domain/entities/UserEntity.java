package com.coutarel.securespringboot.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
  public Long id;
  public String username;
  @Column(unique=true)
  public String email;
  public String password;
}
