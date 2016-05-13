package bg.kirilov.company.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kirilov_a
 */
@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(Model model){
        model.addAttribute("name","Alex");
        return "greeting";
    }
}
