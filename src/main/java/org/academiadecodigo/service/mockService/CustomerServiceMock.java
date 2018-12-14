package org.academiadecodigo.service.mockService;

import org.academiadecodigo.dao.CustomerDao;
import org.academiadecodigo.mockDB.MockData;
import org.academiadecodigo.model.CulturalChallenge;
import org.academiadecodigo.model.Customer;
import org.academiadecodigo.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceMock implements CustomerService {
    CustomerDao customerDao;
    MockData mockData = MockData.getInstance();

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDao.save(customer);
    }


    @Override
    public Customer nextCulturalChallenge(Customer customer) {
        CulturalChallenge challenge = mockData.getCulturalChallenge((customer.getCulturalChallenge().getId())+1);
        customer.setCulturalChallenge(challenge);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {

        List<Customer> customerList = new ArrayList<>(mockData.getCustomerMap().values());

        return customerList;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
