package ua.alvin.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.alvin.springdemo.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    //need to inject session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        //get current HB session
        Session currentSession = sessionFactory.getCurrentSession();

        //create a query
        Query<Customer> customerQuery =
                currentSession.createQuery("from Customer", Customer.class);

        //execute query and get result list
        List<Customer> customers = customerQuery.getResultList();

        //return the result
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        System.out.println(3);

        Session session = sessionFactory.getCurrentSession();
        session.save(customer);

        System.out.println(3);

    }
}
