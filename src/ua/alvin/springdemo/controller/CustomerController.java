package ua.alvin.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.alvin.springdemo.entity.Customer;
import ua.alvin.springdemo.service.CustomerService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
//#{${orderByOptions}}
@Controller
@RequestMapping("/customer")
public class CustomerController {

@Value("#{T(java.util.Arrays).asList(orderByOptions['orderByOptions'])}")
private ArrayList<String> orderByOptions;

    //inject customer service layer which contains customerDAO and
    // delegates it work with customers
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model, @ModelAttribute("customer")Customer customer){
        //get customers list from Service
        List<Customer> customerList = customerService.getCustomers();
        //add customers to the model
        model.addAttribute("customers", customerList);
        model.addAttribute("orderByOptions", orderByOptions);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @GetMapping("/showFormUpdateCustomer")
    public String showFormUpdateCustomer(@RequestParam("customerId") int theId, Model model){

        Customer theCustomer = customerService.getCustomer(theId);

        model.addAttribute("customer", theCustomer);

//        return "customer-update-form";
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){

        Customer customer = customerService.getCustomer(theId);

//или так
//        customerService.deleteCustomer(customer);

        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

    @PostMapping("/saveCustomer")//information received from HTML form defined where action="saveCustomer" mentioned
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer,
                               BindingResult theBindingResult) {
        System.out.println(1);
        customerService.saveCustomer(customer);
        System.out.println(1);

        if (theBindingResult.hasErrors()) return "customer-form";
        else {
            return "redirect:/customer/list";
        }
    }

 /*   @GetMapping("/showFormUpdateCustomer")
    public String showFormUpdateCustomer(Model model){
model.addAttribute("customer", new Customer());
        return "customer-update-form";
    }*/




 /*   @PostMapping("/updateCustomer")
    public String showFormUpdateCustomer(@ModelAttribute("customer")Customer theCustomer,
                                         BindingResult theBindingResult){

        if (theBindingResult.hasErrors()) return "customer-form";
        else return "redirect:/customer/list";

    }*/


}
