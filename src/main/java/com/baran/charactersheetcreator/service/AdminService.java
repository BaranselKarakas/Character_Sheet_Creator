package com.baran.charactersheetcreator.service;

import org.springframework.stereotype.Service;

@Service
public class AdminService {
    public void deleteCharacter(int id) {
        CharService.getCharList().remove(CharService.getCharById(id));
        System.out.println("Funkt");
    }

    public void deleteAllCharacters() {
        CharService.getCharList().removeAll(CharService.getCharList());
    }
}
