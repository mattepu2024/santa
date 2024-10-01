package com.orders.cristmas.santa.service;

import com.orders.cristmas.santa.domain.Hood;
import com.orders.cristmas.santa.entities.HoodEntity;
import com.orders.cristmas.santa.repository.HoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.IconView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class HoodService {
    private Logger LOGGER = LoggerFactory.getLogger(HoodService.class);
    @Autowired
    private HoodRepository repository;

    public Long saveHood(Hood hood) {
        LOGGER.info("Received to request create a hood for hoodCapacity={}", hood.getHoodCapacity());
        HoodEntity entity = repository.save(convert(hood));
        return entity.getID();
    }

    public List<Hood> getAllHoods() {
        List<HoodEntity> entities = repository.findAll();
        return convert(entities);
    }

    private List<Hood> convert(List<HoodEntity> entities) {
        List<Hood> hoods = new ArrayList<>();
        entities.stream().forEach(entity -> {
            hoods.add(new Hood(entity.getHoodCapacity(), entity.getHoodWeights().split(",")));
        });
        return hoods;
    }

    private Hood convert(HoodEntity entity) {
        Hood hood = new Hood();
        hood.setHoodCapacity(entity.getHoodCapacity());
        String[] weights = entity.getHoodWeights().split(",");
        hood.setPresentWeights(weights);
        return hood;
    }

    private HoodEntity convert(Hood hood) {
        HoodEntity entity = new HoodEntity();
        entity.setHoodCapacity(hood.getHoodCapacity());
        entity.setHoodWeights(convertToString(hood.getPresentWeights()));
        return entity;
    }

    private static String convertToString(String [] weights) {
        StringBuilder sb = new StringBuilder();
        return Arrays.stream(weights).collect(Collectors.joining(","));
    }




}
