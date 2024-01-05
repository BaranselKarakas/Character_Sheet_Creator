package com.baran.charactersheetcreator.repository;

import com.baran.charactersheetcreator.domain.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CharRepository extends CrudRepository<Character, Integer> {


}