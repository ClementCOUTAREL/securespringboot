package com.coutarel.securespringboot.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.coutarel.securespringboot.domain.dto.UserDto;
import com.coutarel.securespringboot.domain.entities.UserEntity;
import com.coutarel.securespringboot.mappers.Mapper;

@Component
public class UserMapper implements Mapper<UserEntity, UserDto> {

  private ModelMapper modelMapper;

  public UserMapper(ModelMapper modelMapper){
    this.modelMapper = modelMapper;
  }

  @Override
  public UserDto mapTo(UserEntity userEntity){
    return modelMapper.map(userEntity, UserDto.class);
  }

  @Override
  public UserEntity mapFrom(UserDto userDto) {
    return modelMapper.map(userDto, UserEntity.class);
  }

  
}
