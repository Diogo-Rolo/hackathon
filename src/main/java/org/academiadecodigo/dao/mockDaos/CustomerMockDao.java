package org.academiadecodigo.dao.mockDaos;

import org.academiadecodigo.dao.CustomerDao;
import org.academiadecodigo.mockDB.MockData;
import org.academiadecodigo.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerMockDao implements CustomerDao {

    MockData mockData = MockData.getInstance();

    @Override
    public Customer getById() {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        Customer toReturn = mockData.addCustomer(customer);
        return toReturn;
    }

    @Override
    public Customer update(Customer customer) {
        Customer toReturn = mockData.updateCustomer(customer);
        return toReturn;
    }
}
