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

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String addNameAndPassword(@ModelAttribute Customer customerDTO) {

        for (Customer customer : customerService.getAllCustomers()){

            if(customerDTO.getEmail() == customer.getEmail() && customerDTO.getPassword() == customer.getPassword()){

                return "redirect:customer/" + customer.getId();

            }

        }

        return "redirect:customer/1";

    }

    @RequestMapping(method = RequestMethod.GET, value = {"/", ""})
    public String firstPage(Model model) {

        model.addAttribute("customer", new Customer());
        return "index";

    }

    @RequestMapping(method = RequestMethod.GET, value = {"/health/{id}"})
    public String health(Model model, @PathVariable Integer id) {
        Customer customer = null;
        for (Customer cust: customerService.getAllCustomers()){
            if (cust.getId() == id) {
                customer = cust;
            }
        }
        model.addAttribute("challenge", customer.getHealthyChallenge());
        return "viewhealth";

    }

    @RequestMapping(method = RequestMethod.GET, value = {"health/{id}/next"})
    public String healthNext(Model model, @PathVariable Integer id){
        Customer customer = customerService.getById(id);
        customerService.nextHealthyChallenge(customer);
        return "redirect:/health/{id}";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"cultural/{id}/next"})
    public String culturalNext(Model model, @PathVariable Integer id){
        Customer customer = customerService.getById(id);
        customerService.nextCulturalChallenge(customer);
        return "redirect:/cultural/{id}";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"social/{id}/next"})
    public String socialNext(Model model, @PathVariable Integer id){
        Customer customer = customerService.getById(id);
        customerService.nextSocialChallenge(customer);
        return "redirect:/social/{id}";
    }






    @RequestMapping(method = RequestMethod.GET, value = {"/cultural/{id}"})
    public String cultural(Model model, @PathVariable Integer id) {
        Customer customer = new Customer();
        for (Customer cust: customerService.getAllCustomers()){
            if (cust.getId() == id) {
                customer = cust;
            }
        }
        model.addAttribute("challenge", customer.getCulturalChallenge());
        return "viewcultural";

    }

    @RequestMapping(method = RequestMethod.GET, value = {"/social/{id}"})
    public String social(Model model, @PathVariable Integer id) {
        Customer customer = new Customer();
        for (Customer cust: customerService.getAllCustomers()){
            if (cust.getId() == id) {
                customer = cust;
            }
        }
        model.addAttribute("challenge", customer.getSocialChallenge());
        return "viewsocial";

    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

}
