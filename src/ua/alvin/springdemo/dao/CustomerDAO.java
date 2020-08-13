package ua.alvin.springdemo.dao;

import ua.alvin.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

//    public void updateCustomer(Customer customer);

    Customer getCustomer(int theId);

    void deleteCustomer(Customer customer);

    void deleteCustomer(int theId);

    List<Customer> searchCustomer(String theSearchName);
}
