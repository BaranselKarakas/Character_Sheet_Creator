package com.baran.charactersheetcreator.repository;

import com.baran.charactersheetcreator.domain.Character;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CharRepository extends CrudRepository<Character, Integer> {

    void delete(Optional<Character> byId);
}