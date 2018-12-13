package org.academiadecodigo.dao;

import org.academiadecodigo.model.Customer;

public interface CustomerDao {
    Customer getById();
    Customer save(Customer customer);
}
