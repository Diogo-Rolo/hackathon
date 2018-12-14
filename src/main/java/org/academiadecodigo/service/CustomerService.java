package org.academiadecodigo.service;

import org.academiadecodigo.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer getById(Integer id);
    Customer createCustomer(Customer customer);
    Customer nextCulturalChallenge(Customer customer);
    Customer nextHealthyChallenge(Customer customer);
    List<Customer> getAllCustomers();
}
