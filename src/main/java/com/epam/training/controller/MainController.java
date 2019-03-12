package com.epam.training.controller;

import com.epam.training.model.Player;
import com.epam.training.service.BetService;
import com.epam.training.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    @Qualifier("RepositoryPlayerService")
    private PlayerService service;

    @Autowired
    private BetService betService;

    private Player currentPlayer;

    @GetMapping("/")
    public String view(){
        return "index";
    }

    @GetMapping("/createData")
    public String data(){
        betService.createData();
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("countryList", service.getCurrencyMap());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute Player player){
        service.addPlayer(player);
        model.addAttribute("css", "success");
        model.addAttribute("msg", "Player is registered successfully!");
        return "index";
    }

    @GetMapping("/players")
    public String getPlayers(Model model){
        model.addAttribute("players", service.getAll());
        return "players";
    }

    @GetMapping("/wagers")
    public String getWagers(Model model){
        model.addAttribute("wagers", service.getAllWagers());
        return "wagers";
    }


    @PostMapping("/login")
    public String login(Model model, @RequestParam("login") String login,
                        @RequestParam("password") String password){
        currentPlayer = service.getPlayer(login, password);
        if (currentPlayer == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Player not found");
            return "login";
        }
        model.addAttribute("css", "success");
        model.addAttribute("msg", "Player is logged in successfully!");
        model.addAttribute("player", currentPlayer);
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("player", currentPlayer);
        return "home";
    }

}
