package ua.alvin.springdemo.dao;

import ua.alvin.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void addCustomer(Customer customer);

}
