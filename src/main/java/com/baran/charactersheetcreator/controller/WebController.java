package com.baran.charactersheetcreator.controller;

import com.baran.charactersheetcreator.domain.Character;
import com.baran.charactersheetcreator.service.CharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.baran.charactersheetcreator.service.CharacterService.getMyCharacterArrayList;
@Controller
public class WebController {

    int indexOfMyArrayList;

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
    public String submitCharacterName(@ModelAttribute Character character, RedirectAttributes redirectAttrs) {
        character.setId(getMyCharacterArrayList().size());
        getMyCharacterArrayList().add(character);
        indexOfMyArrayList = getMyCharacterArrayList().size() - 1;
        redirectAttrs.addFlashAttribute("character", character);
        return "redirect:/characters/" + indexOfMyArrayList;
    }

    @GetMapping("/characters")
    public String showAllCharacters(Model model){
        model.addAttribute("myCharacterArrayList", getMyCharacterArrayList());
        model.addAttribute("character", getMyCharacterArrayList().get(indexOfMyArrayList));
        return "characterlist";
    }

    @GetMapping("/characters/{index}")
    public String getCharacterPage(@PathVariable int index, Model model) {
        model.addAttribute("character", getMyCharacterArrayList().get(index));
        return "characterpage";
    }

}
