package com.codecool.hp_backend.service;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CharacterStorageTest {

//    private static PotterApiService potterApiService;
    private static CharacterProvider provider;
    private static CharacterStorage characterStorage;
    private static Map<String, PotterCharacter> charactersTest = new LinkedHashMap<>();

    @BeforeEach
    void init() {
        charactersTest.put("0", new PotterCharacter("human", "Harry Potter", "0", "Gryffindor", "Hogwarts School of Witchcraft and Wizardry"));
        charactersTest.put("1", new PotterCharacter("human", "Draco Malfoy", "1", "Slytherin", "Hogwarts School of Witchcraft and Wizardry"));
        charactersTest.put("2", new PotterCharacter("ghost", "Bloody Baron", "2", "Slytherin", "Hogwarts School of Witchcraft and Wizardry"));
        provider = mock(PotterApiService.class);
        when(provider.getAllCharacters()).thenReturn(charactersTest);
        characterStorage = new CharacterStorage(provider);
    }


    @Test
    void getCharactersReturnsMatchingElements() {
        assertEquals(charactersTest, characterStorage.getCharacters());
    }


    @Test
    void getCharacterByIdWithExistingIdReturnsExistingCharacter() {
        PotterCharacter testCharacter = charactersTest.get("2");
        assertEquals(testCharacter, characterStorage.getCharacterById("2"));
    }

    @Test
    void getCharacterByIdWithNonExistingIdThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> characterStorage.getCharacterById("4"));
    }

    @Test
    void getCharacterListReturnsMatchingElements() {
        List<PotterCharacter> potterCharacterList = new ArrayList<>(charactersTest.values());
        assertIterableEquals(potterCharacterList, characterStorage.getCharacterList());
    }
}