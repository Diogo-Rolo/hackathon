package org.academiadecodigo.controller;

import org.academiadecodigo.model.Customer;
import org.academiadecodigo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController  {

    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = "/addcustomer")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        System.out.println("hssdghaihgsdak");
        return "clientform";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/addcustomer")
    public String addCustomer(Customer customer) {
        Customer savedCustomer = customerService.createCustomer(customer);
        return "redirect:customer/" + savedCustomer.getId();

    }

    @RequestMapping(method = RequestMethod.GET, value = "/customer/{id}")
    public String addCustomer(Model model, @PathVariable Integer id) {
        Customer customer = new Customer();
        for (Customer cust: customerService.getAllCustomers()){
            if (cust.getId() == id) {
                customer = cust;
            }
        }
        model.addAttribute("customer", customer);
        return "main";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String addNameAndPassword(@ModelAttribute Customer customerDTO) {

        for (Customer customer : customerService.getAllCustomers()){

            if(customerDTO.getEmail() == customer.getEmail() && customerDTO.getPassword() == customer.getPassword()){

                return "customer/"+customer.getId();

            }

        }

        return "login";

    }

    @RequestMapping(method = RequestMethod.GET, value = {"/", ""})
    public String firstPage(Model model) {

        model.addAttribute("customer", new Customer());
        return "index";

    }

    @RequestMapping(method = RequestMethod.GET, value = {"/health/{id}"})
    public String health(Model model, @PathVariable Integer id) {
        Customer customer = new Customer();
        for (Customer cust: customerService.getAllCustomers()){
            if (cust.getId() == id) {
                customer = cust;
            }
        }
        model.addAttribute("challenge", customer.getHealthChallenge());
        return "viewhealth";

    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

}
