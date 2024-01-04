package com.baran.charactersheetcreator.service;

import com.baran.charactersheetcreator.domain.Character;
import com.baran.charactersheetcreator.repository.CharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CharService {

    private final CharRepository charRepository;

    @Autowired
    public CharService(CharRepository charRepository){
        this.charRepository = charRepository;
    }

    private static int counter = 0;
    static ArrayList<Character> charList = new ArrayList<>();

    public int getCounter() {
        return counter;
    }

    public int getCounterMinusOne(){
        return counter - 1;
    }

    public Iterable<Character> getAllChars() {
        return charRepository.findAll();
    }


    public void addCharacter(Character character){
        charRepository.save(character);
        counter++;
    }

    public Character getCharById(Integer id){
        for (Character character : charRepository.findAll()) {
            if (character.getId() == id) {
                return character;
            }
        }
        return null;
    }

    public void deleteChar(Integer id){
        charRepository.delete(charRepository.findById(id));
    }

    public void deleteAllChars(){
        charRepository.deleteAll();
    }

}
