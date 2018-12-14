package org.academiadecodigo.dao;

import org.academiadecodigo.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao {
    Customer getById();
    Customer save(Customer customer);
    Customer update(Customer customer);
}
