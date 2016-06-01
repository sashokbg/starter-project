package bg.kirilov.company.web.controllers;

import bg.kirilov.company.web.model.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kirilov_a
 */
@Controller
public class GreetingController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping("/")
    public String greeting(Model model){
        model.addAttribute("name","Alex");
        model.addAttribute("cities",cityRepository.findAll());
        model.addAttribute("filteredCities",cityRepository.findByName("Sofia"));

        return "greeting";
    }
}
