package com.iccteams.iccteams.controller;

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
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private CountryService countryService;
    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("players",playerService.findAll());
        return "Player_list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("player",new Player());
        model.addAttribute("countries",countryService.findAll());
        return "Player_form";
    }

    @GetMapping("/update")
    public String update(@RequestParam("playerId")int id, Model model){
        Player player = playerService.findById(id);
        model.addAttribute(player);
        return "Player_form";
    }
    @PostMapping("/save")
    public String saveCategory(@Valid @ModelAttribute("player") Player player,
                               BindingResult result, Model model) {
        if(result.hasErrors()){
            return "Player_form";
        }
        playerService.save(player);
        return "redirect:/players/";

    }
    @GetMapping("/delete")
    public String delete(@RequestParam("playerId")int id){
        playerService.deleteById(id);
        return "redirect:/players/";
    }
}
