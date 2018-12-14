package org.academiadecodigo.service.mockService;

import org.academiadecodigo.dao.CustomerDao;
import org.academiadecodigo.mockDB.MockData;
import org.academiadecodigo.model.CulturalChallenge;
import org.academiadecodigo.model.Customer;
import org.academiadecodigo.model.HealthyChallenge;
import org.academiadecodigo.model.SocialChallenge;
import org.academiadecodigo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceMock implements CustomerService {
    CustomerDao customerDao;
    MockData mockData = MockData.getInstance();

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public Customer getById(Integer id) {
        return mockData.getCustomerMap().get(id);
    }

    @Override
    public Customer nextCulturalChallenge(Customer customer) {
        Integer currId = customer.getCulturalChallenge().getId();
        CulturalChallenge challenge = mockData.getCulturalChallenge(currId + 1);
        customer.setCulturalChallenge(challenge);
        return customer;
    }

    @Override
    public Customer nextHealthyChallenge(Customer customer) {
        Integer currId = customer.getHealthyChallenge().getId();
        HealthyChallenge challenge = mockData.getHealthyChallenge(currId +1);
        customer.setHealthyChallenge(challenge);
        return customer;
    }

    @Override
    public Customer nextSocialChallenge(Customer customer) {
        Integer currId = customer.getSocialChallenge().getId();
        SocialChallenge challenge = mockData.getSocialChallenge(currId +1);
        customer.setSocialChallenge(challenge);
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

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
