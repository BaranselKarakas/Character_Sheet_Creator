package com.baran.charactersheetcreator.service;

import com.baran.charactersheetcreator.repository.CharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final CharRepository charRepository;

    @Autowired
    public AdminService(CharRepository charRepository) {
        this.charRepository = charRepository;
    }

    public void deleteChar(Integer id) {
        charRepository.deleteById(id);
    }

    public void deleteAllChars() {
        charRepository.deleteAll();
    }
}
