package com.example.murdoku.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void shouldStoreRowAndColumn() {
        Cell cell = new Cell(2, 5);
        assertEquals(2, cell.row());
        assertEquals(5, cell.col());
    }
}