package com.baran.charactersheetcreator.controller;

import com.baran.charactersheetcreator.domain.Character;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {
    @GetMapping("/Hello")
    @ResponseBody
    public String getRoot() {
        return "Hello World";
    }

    @GetMapping("/")
    public String getCharacterCreator(Model model) {
        model.addAttribute("character", new Character());
        return "charactercreator";
    }

    @PostMapping("/")
    public String submitCharacterName(@ModelAttribute Character character, @RequestParam("name") String name, RedirectAttributes redirectAttrs) {
        character.setName(name);
        redirectAttrs.addFlashAttribute("character", character);
        return "redirect:/characters/" + name;
    }

    @GetMapping("/characters")
    public String showAllCharacters(){
        return "characterlist";
    }

    @GetMapping("/characters/{name}")
    public String characterListPage(RedirectAttributes redirectAttrs) {
        return "characterpage";
    }

}
