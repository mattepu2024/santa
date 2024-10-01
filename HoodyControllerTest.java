package com.orders.cristmas.santa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.cristmas.santa.domain.Hood;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.RequestEntity.post;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HoodyControllerTest.class)
public class HoodyControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testInvalidInputReturnBadRequest() throws JsonProcessingException {

        Hood hood = buildHood();
        String body = objectMapper.writeValueAsString(hood);
        //mvc.perform(post("/hood/fill"));

    }

    private Hood buildHood() {
        Hood hood = new Hood();
        String[] weights = {"10", "20"};
        hood.setPresentWeights(weights);
        return hood;
    }


}
