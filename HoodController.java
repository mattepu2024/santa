package com.orders.cristmas.santa.controller;

import com.orders.cristmas.santa.domain.Hood;
import com.orders.cristmas.santa.service.HoodService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/hood")
public class HoodController {
    private Logger LOGGER = LoggerFactory.getLogger(HoodController.class);

    @Autowired
    private HoodService service;
    @PostMapping(value="/fill")
    public ResponseEntity createHood(@Valid @RequestBody Hood hood) {
        LOGGER.info("Received request to create a logger ");
        Long Id = service.saveHood(hood);
        LOGGER.info("Hood filled successfully id={}", Id);
        return ResponseEntity.ok(Id);
    }

    @GetMapping(value="/getAllHoods")
    public List<Hood> getAllHoods() {
       List<Hood> lists =  service.getAllHoods();
       LOGGER.info("Total hoods={}", lists.size());
       return lists;
    }


}
