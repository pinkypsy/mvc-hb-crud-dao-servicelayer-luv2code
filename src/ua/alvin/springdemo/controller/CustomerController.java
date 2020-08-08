package ua.alvin.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.alvin.springdemo.dao.CustomerDAO;
import ua.alvin.springdemo.entity.Customer;
import ua.alvin.springdemo.service.CustomerService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //inject customer service layer which contains customerDAO which returns customers by (customerDAO.getCustomers();)
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){

        //get customers list from Service
        List<Customer> customerList = customerService.getCustomers();

        //add customers to the model
        model.addAttribute("customers", customerList);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        model.addAttribute("customer", new Customer());

        return "customer-add-form";
    }

    @GetMapping("/saveCustomer")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer,
                                BindingResult theBindingResult) {
        System.out.println("Customer firstName: |" + theCustomer.getFirstName() + "|");
        System.out.println("Customer lastName: |" + theCustomer.getLastName() + "|");
        System.out.println(theBindingResult);

        if (theBindingResult.hasErrors()) return "customer-add-form";
        else return "list-customers";
    }



}
