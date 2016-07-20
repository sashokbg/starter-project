package bg.kirilov.company.web.controllers;

import bg.kirilov.company.model.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kirilov_a
 */
@Controller
public class GreetingController {

    @Autowired
    private OrdersRepository ordersRepository;

    @RequestMapping("/")
    public String greeting(Model model){
        model.addAttribute("name","Alex");
        model.addAttribute("orders", ordersRepository.findAll());
        model.addAttribute("order", null);//ordersRepository.findByNumber(10247L));

        return "greeting";
    }
}
