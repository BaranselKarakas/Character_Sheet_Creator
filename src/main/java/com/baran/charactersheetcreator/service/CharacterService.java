package com.baran.charactersheetcreator.service;

import com.baran.charactersheetcreator.domain.Character;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;


@Service
public class CharacterService {

    static ArrayList<Object> arrayList = new ArrayList<>();

    public static ArrayList<Object> getArrayList() {
        return arrayList;
    }

    public static void setArrayList(ArrayList<Object> arrayList) {
        CharacterService.arrayList = arrayList;
    }


}
