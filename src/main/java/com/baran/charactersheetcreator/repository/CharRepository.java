package com.baran.charactersheetcreator.repository;

import com.baran.charactersheetcreator.domain.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CharRepository extends CrudRepository<Character, Integer> {


}