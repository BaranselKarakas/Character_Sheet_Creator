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

<<<<<<< HEAD
<<<<<<< HEAD
    @PostMapping("/")
    public String submitCharacterName(@ModelAttribute Character character, RedirectAttributes redirectAttrs) {
<<<<<<< HEAD
<<<<<<< HEAD
=======
    @PostMapping("/ ")
=======
    @PostMapping("/")
>>>>>>> 038466c (remove typo)
    public String submitCharacterName(@ModelAttribute Character character, @RequestParam("name") String name, RedirectAttributes redirectAttrs) {
        character.setName(name);
<<<<<<< HEAD
        CharacterService.getArrayList().add(character);
>>>>>>> 0137718 (exchange HashMap with ArrayList)
=======
        CharacterService.getMyCharacterArrayList().add(character);
>>>>>>> a04ecbc (rename ArrayList + make mvnw executable)
        redirectAttrs.addFlashAttribute("character", character);
        return "redirect:/character";
    }

    @GetMapping("/character")
    public String characterPage(RedirectAttributes redirectAttrs) {
=======
        getMyCharacterArrayList().add(character);
        indexOfMyArrayList = getMyCharacterArrayList().size() - 1;
        redirectAttrs.addFlashAttribute("character", character);
        return "redirect:/characters/" + indexOfMyArrayList;
>>>>>>> fdfe0ab (wip functional characterlist)
=======
        getMyCharacterArrayList().add(character);
        indexOfMyArrayList = getMyCharacterArrayList().size() - 1;
        redirectAttrs.addFlashAttribute("character", character);
        return "redirect:/characters/" + indexOfMyArrayList;
>>>>>>> 17a9f2c (wip add basic functionality  to characterlist page)
    }

    @GetMapping("/characters")
    public String showAllCharacters(Model model){
        model.addAttribute("myCharacterArrayList", getMyCharacterArrayList());
        model.addAttribute("character", getMyCharacterArrayList().get(indexOfMyArrayList));
        return "characterlist";
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
    @GetMapping("/characters/{name}")
    public String getCharacterPage(RedirectAttributes redirectAttrs) {
=======
    @GetMapping("/characters/{index}")
    public String getCharacterPage(@PathVariable int index, Model model) {
        model.addAttribute("character", getMyCharacterArrayList().get(index));
>>>>>>> fdfe0ab (wip functional characterlist)
=======
    @GetMapping("/characters/{index}")
    public String getCharacterPage(@PathVariable int index, Model model) {
        model.addAttribute("character", getMyCharacterArrayList().get(index));
>>>>>>> 17a9f2c (wip add basic functionality  to characterlist page)
        return "characterpage";
    }

>>>>>>> b0f1cd5 (rename method)
}
