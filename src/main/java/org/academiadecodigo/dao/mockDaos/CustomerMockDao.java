package org.academiadecodigo.dao.mockDaos;

import org.academiadecodigo.dao.CustomerDao;
import org.academiadecodigo.mockDB.MockData;
import org.academiadecodigo.model.Customer;

public class CustomerMockDao implements CustomerDao {

    MockData mockData = MockData.getInstance();

    @Override
    public Customer getById() {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        mockData.addCustomer(customer);
        return customer;
    }
}
