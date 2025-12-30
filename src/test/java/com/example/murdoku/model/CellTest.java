package com.example.murdoku.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void shouldStoreRowAndColumn() {
        Cell cell = new Cell(2, 5);
        assertEquals(2, cell.row());
        assertEquals(5, cell.col());
    }

    @Test
    void shouldNotAcceptNegativeCoordinates() {
        assertThrows(IllegalArgumentException.class, () -> new Cell(-1, 0));
    }

    @Test
    void shouldReturnStringRepresentation() {
        Cell cell = new Cell(2, 5);
        assertEquals("Cell(R3, C6)", cell.toString());
    }

    @Test
    void shouldCreateFromStringRepresentation() {
        Cell cell = Cell.fromString("R3,C6");
        assertThat(cell).isEqualTo(new Cell(2, 5));
    }
}