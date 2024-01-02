package com.baran.charactersheetcreator.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character, Integer> {

    List<Character> findByName(String name);

    Character findById(long id);
}