package com.baran.charactersheetcreator.controller;

import com.baran.charactersheetcreator.domain.Character;
import com.baran.charactersheetcreator.service.CharService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static com.baran.charactersheetcreator.service.CharService.getMyCharacterArrayList;

@Controller
public class WebController {

    int indexCharacterList;

    @GetMapping("/")
    public String getCharacterCreator(Model model) {
        model.addAttribute("character", new Character());
        return "charactercreator";
    }

    @PostMapping("/")
    public String createCharacter(Character character, Model model, CharService charService) {
        character.setId(charService.getNextId());
        charService.addCharacter(character);
        return "redirect:/characters/" + charService.getIndex();
    }

    @GetMapping("/characters")
    public String showAllCharacters(Model model) {
        if (!getMyCharacterArrayList().isEmpty()) {
            model.addAttribute("myCharacterArrayList", getMyCharacterArrayList());
            model.addAttribute("character", getMyCharacterArrayList().get(indexCharacterList));
            return "characterlist";
        } else return "characterlistempty";
    }

    @GetMapping("/characters/{index}") //index is the value with which you got redirected here.
    public String getCharacterPage(@PathVariable int index, Model model) {
        model.addAttribute("character", getMyCharacterArrayList().get(index));
        return "characterpage";
    }

}