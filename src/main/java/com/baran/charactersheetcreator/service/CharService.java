package com.baran.charactersheetcreator.service;

import com.baran.charactersheetcreator.domain.Character;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CharService {

    static ArrayList<Character> charList = new ArrayList<>();
    private static int counter = 0;

    public static ArrayList<Character> getCharList() {
        return charList;
    }

    public static Character getCharById(int id) {
        for (Character character : getCharList()) {
            if (character.getId() == id) {
                return character;
            }
        }
        return null;
    }

    public int getCounter() {
        return counter;
    }

    public int getCounterMinusOne() {
        return counter - 1;
    }

    public void addCharacter(Character character) {
        getCharList().add(character);
        counter++;
    }

}
