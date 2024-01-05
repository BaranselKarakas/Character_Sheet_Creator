package com.baran.charactersheetcreator.controller;

import com.baran.charactersheetcreator.domain.Character;
import com.baran.charactersheetcreator.service.CharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    private final CharService charService;

    @Autowired
    public WebController(CharService charService) {
        this.charService = charService;
    }

    @GetMapping("/")
    public String getCharacterCreator(Model model) {
        model.addAttribute("character", new Character());
        return "charactercreator";
    }

    @PostMapping("/")
    public String createCharacter(Character character, Model model) {
        charService.addCharacter(character);
        return "redirect:/characters/" + character.getId();
    }

    @GetMapping("/characters")
    public String showallCharacters(Model model) {
        if (charService.getAllChars() == null) {
            return "characterlistempty";
        } else {
            model.addAttribute("allCharacter", charService.getAllChars());
            return "characterlist";
        }
    }

    @GetMapping("/characters/{id}") //index is the value with which you got redirected here.
    public String getCharacterPage(@PathVariable int id, Model model) {
        model.addAttribute("character", charService.getCharById(id));
        return "characterpage";
    }

}