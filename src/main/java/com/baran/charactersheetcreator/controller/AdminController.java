package com.baran.charactersheetcreator.controller;

import com.baran.charactersheetcreator.service.AdminService;
import com.baran.charactersheetcreator.service.CharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.baran.charactersheetcreator.service.CharService.getCharList;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/characters")
    public String showAllCharacters(Model model, CharService charService) {
        if (!getCharList().isEmpty()) {
            model.addAttribute("myCharacterArrayList", getCharList());
            return "admincharacterlist";
        } else return "admincharacterlist";
    }

    @GetMapping("/characters/delete/{id}")
    public String deleteCharacter(@PathVariable int id) {
        System.out.println("Deleting character with ID: " + id);
        adminService.deleteCharacter(id);
        return "redirect:/admin/characters";
    }

    @GetMapping("/characters/delete/all")
    public String deleteAllCharacter() {
        System.out.println("Deleting character with ID: ");
        adminService.deleteAllCharacters();
        return "redirect:/admin/characters";
    }


}

