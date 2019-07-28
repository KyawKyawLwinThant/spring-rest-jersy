package com.example.springbootjersy.rest;

import com.example.springbootjersy.model.Customer;
import com.example.springbootjersy.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Component
@Path("customer")
public class CustomerResource {

  @Autowired
  private CustomerService customerService;

  @GET
  @Path("creation")
  public Response create(){
    Arrays.asList(new Customer("Thaw Thaw",23,"Mandalay","123456"),
            new Customer("Thuza New",22,"Yangon","2222222"),
            new Customer("Khaing Khaing",24,"Mandalay","3333333"))
            .stream()
            .forEach(customerService::create);
    return Response.ok().entity("successfully created.").build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("all")
  public List<Customer> showAllCustomer(){
    return customerService.findAll();
  }

  @GET
  @Path("/all/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Customer showCustomer(@PathParam("id") int id){
    logger.info("Customer Id:"+ id);
    System.out.println("Customer:"+ id);
    return customerService.findById(id);
  }

  private static Logger logger = LoggerFactory.getLogger(CustomerResource.class);
}
