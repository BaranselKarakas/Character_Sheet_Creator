package com.baran.charactersheetcreator.controller;

import com.baran.charactersheetcreator.service.AdminService;
import com.baran.charactersheetcreator.service.CharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/characters")
    public String showAllCharacters(int index) {
        adminService.deleteCharacter(index);
        return "admincharacterlist";
    }

    @GetMapping("/characters/delete/{index}")
        public void deleteCharacter(){
        deleteCharacter();
    }

    @GetMapping("/characters/delete/all")
    public void deleteAllCharacter(){
        deleteAllCharacter();
    }


}

