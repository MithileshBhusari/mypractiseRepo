package com.mtb.springboot.mybatis.customer.service;

import com.mtb.springboot.mybatis.customer.mapper.CustomerMapper;
import com.mtb.springboot.mybatis.customer.model.Address;
import com.mtb.springboot.mybatis.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> getAll() {
        return customerMapper.getAll();
    }


    public Customer getCustomer(String name) {
        return customerMapper.getCustomer(name);
    }

    public List<Address> getCustomerAddresses(String customerAddress){
        return  customerMapper.findAddressesByCustomer(customerAddress);
    }

    public void addCustomer(Customer customer) {
        customerMapper.insert(customer);
    }

    public void deleteUser(String name) {
        customerMapper.deleteUser(name);
    }
}
