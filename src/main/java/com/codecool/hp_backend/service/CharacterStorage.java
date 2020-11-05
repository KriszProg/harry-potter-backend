package com.codecool.hp_backend.service;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class CharacterStorage {

    @Autowired
    public CharacterStorage(PotterApiService potterApiService) {
        this.characters = potterApiService.getAllCharacters();
    }

    private Map<String, PotterCharacter> characters;


    public Map<String, PotterCharacter> getCharacters() {
        return characters;
    }

    public PotterCharacter getCharacterById(String id) {
        if (characters.get(id) == null) {
            throw new NullPointerException("Couldn't find character with id: " + id);
        } else {
            return characters.get(id);
        }
    }

    public List<PotterCharacter> getCharacterList() {
        return new ArrayList<>(characters.values());
    }
}
