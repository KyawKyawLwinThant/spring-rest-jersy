package com.example.springbootjersy.service;

import com.example.springbootjersy.model.Customer;

import java.util.List;

public interface CustomerService {
  Customer create(Customer customer);

  Customer findById(int id);

  List<Customer> findAll();
}
