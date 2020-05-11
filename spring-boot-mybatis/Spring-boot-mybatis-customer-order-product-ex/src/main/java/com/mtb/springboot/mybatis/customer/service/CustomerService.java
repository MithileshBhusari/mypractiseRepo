package com.mtb.springboot.mybatis.customer.service;

import com.mtb.springboot.mybatis.customer.mapper.CustomerMapper;
import com.mtb.springboot.mybatis.customer.model.Address;
import com.mtb.springboot.mybatis.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> getAllCustomers() {
        return customerMapper.getAllCustomers();
    }


    public Customer getCustomer(int  customerId) {
        return customerMapper.getCustomer(customerId);
    }

    public List<Address> getCustomerAddresses(String customerAddress){
        return  customerMapper.findAddressesByCustomer(customerAddress);
    }

    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
    }

    public void deleteUser(String name) {
        customerMapper.deleteUser(name);
    }

    public void addCustomerAddress(Address address, int customerId) {
            customerMapper.addCustomerAddress(address,customerId);
    }
}
