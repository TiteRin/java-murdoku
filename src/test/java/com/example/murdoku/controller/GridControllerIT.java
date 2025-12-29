package com.example.murdoku.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GridControllerIT {

    @Autowired
    MockMvc mvc;

    @Test
    void getEmptyGridShouldReturnSize() throws Exception {
        mvc.perform(get("/api/grid/4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size", is(4)));
    }

    @Test
    void shouldReturnBadRequestWhenInvalidSize() throws Exception {
        mvc.perform(get("/api/grid/0"))
                .andExpect(status().isBadRequest());

        mvc.perform(get("/api/grid/-1"))
                .andExpect(status().isBadRequest());
    }
}
