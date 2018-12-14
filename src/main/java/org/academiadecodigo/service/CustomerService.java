package org.academiadecodigo.service;

import org.academiadecodigo.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer nextCulturalChallenge(Customer customer);
    List<Customer> getAllCustomers();
}
