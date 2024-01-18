package com.baran.charactersheetcreator.service;

import com.baran.charactersheetcreator.domain.Character;
import com.baran.charactersheetcreator.repository.CharRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CharServiceTest {

    @Test
    void whenIntegerIsNullReturnNull(){
        //given
        CharRepository charRepository = Mockito.mock();
        Mockito.when(charRepository.findById(12)).thenReturn(Optional.empty());
        CharService charService = new CharService(charRepository);
        //when
        Character i = charService.getCharById(12);
        //then
        assertThat(i).isNull();
    }

    @Test
    void returnCharacter(){
        //given
        Character character = new Character();
        CharRepository charRepository = Mockito.mock();
        Mockito.when(charRepository.findById(12)).thenReturn(Optional.of(character));
        CharService charService = new CharService(charRepository);
        //when
        Character i = charService.getCharById(12);
        //then
        assertThat(i).isEqualTo(character);
    }


}