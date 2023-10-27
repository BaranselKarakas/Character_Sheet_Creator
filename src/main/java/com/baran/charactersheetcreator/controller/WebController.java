package com.baran.charactersheetcreator.controller;

import com.baran.charactersheetcreator.domain.Character;
import com.baran.charactersheetcreator.service.CharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

<<<<<<< HEAD
    @PostMapping("/")
    public String submitCharacterName(@ModelAttribute Character character, RedirectAttributes redirectAttrs) {
=======
    @PostMapping("/ ")
    public String submitCharacterName(@ModelAttribute Character character, @RequestParam("name") String name, RedirectAttributes redirectAttrs) {
        character.setName(name);
        CharacterService.getArrayList().add(character);
>>>>>>> 0137718 (exchange HashMap with ArrayList)
        redirectAttrs.addFlashAttribute("character", character);
        return "redirect:/character";
    }

    @GetMapping("/character")
    public String characterPage(RedirectAttributes redirectAttrs) {
    }

    @GetMapping("/characters")
    public String showAllCharacters(){
        return "characterlist";
    }

}
