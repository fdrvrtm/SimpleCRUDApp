package com.example.carmanager;

import com.example.carmanager.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private CarService service;

    @RequestMapping("/")
    public String homePage(Model model){
        List<Car> listCars = service.showAll();
        model.addAttribute("listCars", listCars);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewCarPage(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);

        return "new_car";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute("car") Car car) {
        service.save(car);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCarPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_car");
        Car car = service.get(id);
        mav.addObject("car", car);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteCar(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }

}