package com.baran.charactersheetcreator.service;

import com.baran.charactersheetcreator.domain.Character;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CharService {

    private int index;
    static ArrayList<Character> charList = new ArrayList<>();

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static ArrayList<Character> getCharList() {
        return charList;
    }

    public int getNextId(){
        return getCharList().size();
    }

    public void addCharacter(Character character){
        getCharList().add(character);
        setIndex(getCharList().size() - 1);
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
