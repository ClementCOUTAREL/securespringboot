package com.coutarel.securespringboot.config;

import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;

@Configuration
public class MapperConfig {

  @Bean
  public ModelMapper modelMapper(){
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    return modelMapper;
  }

}
