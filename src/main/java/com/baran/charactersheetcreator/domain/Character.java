package com.baran.charactersheetcreator.domain;

public class Character {

    private int id = 0;
    private static int nextId = 0;
    private String name;
    private String profession;
    private int strength;
    private int agility;
    private int intelligence;

    private int id = -1;

    public Character() {
        this.id++;
    }


    public Character() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", characterID=" + id +
                '}';
    }
}

