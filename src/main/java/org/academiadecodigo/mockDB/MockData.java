package org.academiadecodigo.mockDB;

import org.academiadecodigo.model.CulturalChallenge;
import org.academiadecodigo.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class MockData {
    private static MockData ourInstance = new MockData();

    public static MockData getInstance() {
        return ourInstance;
    }

    private MockData() {
    }


    private Map<Integer, Customer> customerMap = new HashMap();
    private Map<Integer, CulturalChallenge> culturalChallengeMap = new HashMap<>();

    public Customer addCustomer(Customer customer){
        customer.setId(customerMap.keySet().size()+1);
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    public Customer updateCustomer(Customer customer){
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    public CulturalChallenge getCulturalChallenge(Integer id){
        return culturalChallengeMap.get(id);
    }











    public Map<Integer, Customer> getCustomerMap() {
        return customerMap;
    }

    public void setCustomerMap(Map<Integer, Customer> customerMap) {
        this.customerMap = customerMap;
    }
}
