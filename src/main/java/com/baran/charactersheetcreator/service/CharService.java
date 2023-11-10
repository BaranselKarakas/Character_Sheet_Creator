package com.baran.charactersheetcreator.service;

import com.baran.charactersheetcreator.domain.Character;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CharService {

    private int index;
    static ArrayList<Object> charList = new ArrayList<>();

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static ArrayList<Object> getCharList() {
        return charList;
    }

    public static void setCharList(ArrayList<Object> charList) {
        CharService.charList = charList;
    }

    public int getNextId(){
        return getCharList().size();
    }

    public void addCharacter(Character character){
        getCharList().add(character);
        setIndex(getCharList().size() - 1);
    }

    public Object getChar(){
        return getCharList().get(getIndex());
    }




}
