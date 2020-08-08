package ua.alvin.springdemo.service;

import ua.alvin.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);
}
