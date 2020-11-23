package com.iccteams.iccteams.controller;

import com.iccteams.iccteams.model.Country;
import com.iccteams.iccteams.model.Player;
import com.iccteams.iccteams.service.CountryService;
import com.iccteams.iccteams.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private CountryService countryService;
    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("countries",countryService.findAll());
        return "Country_list";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("country",new Country());
        return "Country_form";
    }
    @GetMapping("/update")
    public String update(@RequestParam("countryId")int id, Model model){
        //Player category = playerService.findById(id);
        model.addAttribute("country",playerService.findById(id));
        return "Country_form";
    }
    @PostMapping("/save")
    public String saveCategory(@Valid @ModelAttribute("country") Country country,
                               BindingResult result, Model model) {
        if(result.hasErrors()){
            return "Country_form";
        }
        countryService.save(country);
        return "redirect:/countries/";

    }
    @GetMapping("/delete")
    public String delete(@RequestParam("countryId")int id){
        countryService.deleteById(id);
        return "redirect:/countries/";
    }
}
