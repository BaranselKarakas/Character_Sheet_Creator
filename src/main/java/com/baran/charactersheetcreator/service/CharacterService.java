package com.baran.charactersheetcreator.service;

import com.baran.charactersheetcreator.domain.Character;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class CharacterService {

    HashMap<String, Character> characterHashMap = new HashMap<String, Character>();

    public HashMap<String, Character> getCharacterHashMap() {
        return characterHashMap;
    }

    public void setCharacterHashMap(HashMap<String, Character> characterHashMap) {
        this.characterHashMap = characterHashMap;
    }

    public Character createCharacter(){
        Character character = new Character();
        getCharacterHashMap().put(character.getName(), character);
        return character;
    }

}
