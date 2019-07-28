package com.example.springbootjersy.service;

import com.example.springbootjersy.model.Customer;
import com.example.springbootjersy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public Customer create(Customer customer) {
    return customerRepository.save(customer);
  }

  @Override
  public Customer findById(int id) {
    return customerRepository.getOne(id);
  }

  @Override
  public List<Customer> findAll() {
    return customerRepository.findAll();
  }
}
