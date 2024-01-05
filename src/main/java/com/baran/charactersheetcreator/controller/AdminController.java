package com.baran.charactersheetcreator.controller;

import com.baran.charactersheetcreator.service.AdminService;
import com.baran.charactersheetcreator.service.CharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    private final CharService charService;

    @Autowired
    public AdminController(AdminService adminService, CharService charService) {
        this.adminService = adminService;
        this.charService = charService;
    }

    @GetMapping("/characters")
    public String shows(Model model) {
        if (charService.getAllChars() == null) {
            return "characterlistempty";
        } else {
            model.addAttribute("", charService.getAllChars());
            return "admincharacterlist";
        }
    }

    @GetMapping("/characters/delete/{id}")
    public String deleteCharacter(@PathVariable int id) {
        System.out.println("Deleting character with ID: " + id);
        adminService.deleteChar(id);
        return "redirect:/admin/characters";
    }

    @GetMapping("/characters/delete/all")
    public String delete() {
        System.out.println("Deleting character with ID: ");
        adminService.deleteAllChars();
        return "redirect:/admin/characters";
    }


}

