package org.academiadecodigo.service;

import org.academiadecodigo.model.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer nextCulturalChallenge(Customer customer);
}
