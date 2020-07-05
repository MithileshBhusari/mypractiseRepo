package com.mtb.springboot.mybatis.customer.resource;

import com.mtb.springboot.mybatis.customer.model.Address;
import com.mtb.springboot.mybatis.customer.model.Customer;
import com.mtb.springboot.mybatis.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/getCustomer/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping("/addCustomer")
    private void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @PostMapping("/{customerId}/addCustomerAddress")
    private void addCustomerAddress(@RequestBody Address address,@PathVariable int customerId) {
        customerService.addCustomerAddress(address,customerId);
    }


    @DeleteMapping("/{name}")
    private void deleteUser(@PathVariable String name) {
        customerService.deleteUser(name);
    }


    @GetMapping("/{customerId}/getAddresses")
    public List<Address> getAllCustomers(@PathVariable String customerId) {
        return customerService.getCustomerAddresses(customerId);
    }


}