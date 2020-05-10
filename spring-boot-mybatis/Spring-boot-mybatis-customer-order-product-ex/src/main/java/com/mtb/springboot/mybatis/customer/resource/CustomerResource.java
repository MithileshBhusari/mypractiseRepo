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
    public List<Customer> getCustomerAddresses() {
        return customerService.getAll();
    }

    @GetMapping("getCustomer/{name}")
    public Customer getCustomer(@PathVariable String name) {
        return customerService.getCustomer(name);
    }

    @PostMapping("/addCustomer")
    private void addUser(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @DeleteMapping("/{name}")
    private void deleteUser(@PathVariable String name) {
        customerService.deleteUser(name);
    }


    @GetMapping("/{customerId}/getAddresses")
    public List<Address> getCustomerAddresses(@PathVariable String customerId) {
        return customerService.getCustomerAddresses(customerId);
    }


}
