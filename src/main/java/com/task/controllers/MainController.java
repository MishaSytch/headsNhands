package com.task.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.models.Creature;
import com.task.models.Monstor;
import com.task.models.Player;

@Controller
public class MainController {

    private Player player;
    private Monstor monstor;
    private Random random = new Random();;
    private int n = 100;

    @GetMapping("/")
    public String home(Model model) {

        if (player == null)
            player = new Player(random.nextInt(1, 31), random.nextInt(1, 31), random.nextInt(1, n), random.nextInt(1, 5), random.nextInt(5, 11));
        
        if (monstor == null || !monstor.isAlive())
            monstor = new Monstor(random.nextInt(1, 31), random.nextInt(1, 31), random.nextInt(1, n), random.nextInt(1, 5), random.nextInt(5, 11));
        
            Creature[] creatures = new Creature[]{player, monstor};

        for (Creature creature : creatures) {
            creature.damage = String.valueOf(creature.getDamagePointNow());
            creature.health = String.valueOf(creature.getHealthPoint());
        }

        model.addAttribute("creatures", creatures);

        return "main.html";
    }

    @GetMapping("/{type}")
    public String attack(
        @PathVariable String type,
        Model model
    ) {
        if (type != null) {
            if (type.equals("Player")) {
                player.toAttack(monstor);
            }

            if (type.equals("Monstor")) {
                monstor.toAttack(player);
            }
        }

        return "redirect:/";
    }
}
