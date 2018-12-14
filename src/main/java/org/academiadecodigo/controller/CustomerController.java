package org.academiadecodigo.controller;


import org.academiadecodigo.model.Customer;
import org.academiadecodigo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class CustomerController  {

    private CustomerService customerService;
    private List<Customer> customerList;

    @RequestMapping(method = RequestMethod.GET, path = "/addcustomer")
    public String addCustomer() {

        return "clientform";

    }

    @RequestMapping(method = RequestMethod.POST, path = "/addcustomer")
    public String addCustomer(Customer customer) {
        customerService.createCustomer(customer);
        return "main";

    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public String addNameAndPassword(String email, String password) {
        customerList = customerService.getAllCustomers();

        for (Customer customer : customerList){

            if(email == customer.getEmail() && password == customer.getPassword()){

                return "customer/"+customer.getId();

            }

        }

        return "/login";

    }




}
