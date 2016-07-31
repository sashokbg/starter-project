package bg.kirilov.company.web.controllers;

import bg.kirilov.company.model.Customer;
import bg.kirilov.company.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    @RequestMapping("/customers")
    public String displayAll(Model model){
        List<Customer> customerList = repository.findAll();
        model.addAttribute("customers",customerList);
        model.addAttribute("name","Alexander");

        return "customers";
    }
}
