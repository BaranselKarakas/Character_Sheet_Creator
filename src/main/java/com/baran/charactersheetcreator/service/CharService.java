package com.baran.charactersheetcreator.service;

import com.baran.charactersheetcreator.domain.Character;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CharService {

    private int index;
    static ArrayList<Object> myCharacterArrayList = new ArrayList<>();

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static ArrayList<Object> getMyCharacterArrayList() {
        return myCharacterArrayList;
    }

    public static void setMyCharacterArrayList(ArrayList<Object> myCharacterArrayList) {
        CharService.myCharacterArrayList = myCharacterArrayList;
    }

    public int getNextId(){
        return getMyCharacterArrayList().size();
    }

    public void addCharacter(Character character){
        getMyCharacterArrayList().add(character);
        setIndex(getMyCharacterArrayList().size() - 1);
    }




}
