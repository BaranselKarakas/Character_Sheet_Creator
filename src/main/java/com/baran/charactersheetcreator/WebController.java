package com.baran.charactersheetcreator;

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
    public String submitCharacterName(@ModelAttribute Character character, RedirectAttributes redirectAttrs) {
        redirectAttrs.addFlashAttribute("character", character);
        return "redirect:/character";
    }
    @GetMapping("/character")
    public String characterPage(RedirectAttributes redirectAttrs) {
        return "characterpage";
    }

}