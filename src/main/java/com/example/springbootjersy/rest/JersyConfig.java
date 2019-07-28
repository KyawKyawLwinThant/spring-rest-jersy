package com.example.springbootjersy.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("rs")
public class JersyConfig extends ResourceConfig {
  public JersyConfig(){
      register(CustomerResource.class);
  }
}
