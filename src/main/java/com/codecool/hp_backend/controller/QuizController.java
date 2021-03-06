package com.codecool.hp_backend.controller;

import com.codecool.hp_backend.service.DataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/quiz")
public class QuizController {

    private final DataHandler dataHandler;

    @Autowired
    public QuizController(@Qualifier("dataHandlerDB") DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    @GetMapping("/house/random")
    public ResponseEntity<Object> getRandomHouseQuizCharacter() {
        return ResponseEntity.ok(dataHandler.getRandomHouseQuizCharacter());
    }

}
