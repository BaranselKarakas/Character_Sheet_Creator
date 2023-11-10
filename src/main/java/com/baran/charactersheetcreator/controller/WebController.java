package com.baran.charactersheetcreator.controller;

import com.baran.charactersheetcreator.domain.Character;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.baran.charactersheetcreator.service.CharacterService.getMyCharacterArrayList;

@Controller
public class WebController {

    int indexCharacterList;

    @GetMapping("/")
    public String getCharacterCreator(Model model) {
        model.addAttribute("character", new Character());
        return "charactercreator";
    }

    @PostMapping("/")
    public String createCharacter(Character character, Model model) {
        character.setId(getMyCharacterArrayList().size());
        getMyCharacterArrayList().add(character);
        indexCharacterList = getMyCharacterArrayList().size() - 1;
        return "redirect:/characters/" + indexCharacterList;
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