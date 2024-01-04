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

    public static ArrayList<Character> getCharList() {
        return charList;
    }


    public void addCharacter(Character character){
        getCharList().add(character);
        counter++;
    }

    public static Character getCharById(int id){
        for (Character character : getCharList()) {
            if (character.getId() == id) {
                return character;
            }
        }
        return null;
    }

}
