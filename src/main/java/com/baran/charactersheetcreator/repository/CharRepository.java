package com.baran.charactersheetcreator.repository;

import com.baran.charactersheetcreator.domain.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharRepository extends CrudRepository<Character, Integer> {

    public List<Character> findAllByUserId(String userId);

}