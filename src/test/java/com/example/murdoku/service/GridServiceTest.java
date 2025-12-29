package com.example.murdoku.service;

import com.example.murdoku.model.Grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GridServiceTest {

    @Autowired
    GridService gridService;

    @Test
    void shouldCreateEmptyGridOfGivenSize() {
        Grid grid = gridService.createEmptyGrid(9);
        assertEquals(9, grid.size());
    }

}
