package com.baran.charactersheetcreator.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CharacterService {

    static ArrayList<Object> myCharacterArrayList = new ArrayList<>();

    public static ArrayList<Object> getMyCharacterArrayList() {
        return myCharacterArrayList;
    }

    public static void setMyCharacterArrayList(ArrayList<Object> myCharacterArrayList) {
        CharacterService.myCharacterArrayList = myCharacterArrayList;
    }


}
