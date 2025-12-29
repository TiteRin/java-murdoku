package com.example.murdoku.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    @Test
    void shouldCreateGridWithCorrectSize() {
        Grid grid = new Grid(9);
        assertEquals(9, grid.rows());
        assertEquals(9, grid.columns());
    }

    @Test
    void shouldNotCreateGridWithInvalidSize() {
        assertThrows(IllegalArgumentException.class, () -> new Grid(0));
    }
}
