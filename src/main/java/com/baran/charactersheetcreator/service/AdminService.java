package com.baran.charactersheetcreator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final CharService charService;

    @Autowired
    public AdminService(CharService charService) {
        this.charService = charService;
    }

    public void deleteCharacter(int id) {
        charService.deleteChar(id);
        System.out.println("Funkt");
    }

    public void deleteAllCharacters() {
        charService.deleteAllChars();
    }
}
