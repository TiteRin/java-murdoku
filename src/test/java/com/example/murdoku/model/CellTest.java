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
        assertThat(Cell.fromString("R3,C6")).isEqualTo(new Cell(2, 5));
        assertThat(Cell.fromString("c6 r3")).isEqualTo(new Cell(2, 5));
        assertThat(Cell.fromString("c 6 r 3")).isEqualTo(new Cell(2, 5));
        assertThat(Cell.fromString("R3-C6")).isEqualTo(new Cell(2, 5));
        assertThat(Cell.fromString("R3C6")).isEqualTo(new Cell(2, 5));

        assertThrows(IllegalArgumentException.class, () -> Cell.fromString("rrrccc"));
        assertThrows(IllegalArgumentException.class, () -> Cell.fromString("r-1 c2"));
    }
}