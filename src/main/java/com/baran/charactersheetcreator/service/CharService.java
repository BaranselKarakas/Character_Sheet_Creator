package com.baran.charactersheetcreator.service;

import com.baran.charactersheetcreator.domain.Character;
import com.baran.charactersheetcreator.repository.CharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class CharService {

    private final CharRepository charRepository;

    @Autowired
    public CharService(CharRepository charRepository) {
        this.charRepository = charRepository;
    }


    public Iterable<Character> getAllChars() {
        return charRepository.findAll();
    }


    public void addCharacter(Character character) {
        charRepository.save(character);
    }

    public Character getCharById(Integer id) {
        return charRepository.findById(id).orElse(null);
    }

}
