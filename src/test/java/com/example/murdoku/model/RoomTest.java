package com.example.murdoku.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class RoomTest {

    Room room = new Room("Hallway");

    @BeforeEach
    void setUp() {
        room.addCell(new Cell(1, 1));
        room.addCell(new Cell(2, 1));
        room.addCell(new Cell(3, 1));
        room.addCell(new Cell(3, 2));
        room.addCell(new Cell(3, 3));
        room.addCell(new Cell(3, 4));
        room.addCell(new Cell(3, 5));
    }


    @Test
    void shouldCollectAddedCell() {

        Set<Cell> cells = room.cells();
        assertEquals(7, cells.size());
        assertTrue(cells.contains(new Cell(1, 1)));
        assertTrue(cells.contains(new Cell(2, 1)));
        assertTrue(cells.contains(new Cell(3, 1)));
        assertTrue(cells.contains(new Cell(3, 2)));
        assertTrue(cells.contains(new Cell(3, 3)));
        assertTrue(cells.contains(new Cell(3, 4)));
        assertTrue(cells.contains(new Cell(3, 5)));
    }


    @Test
    void shouldReturnTrueIfContainsCell() {
        assertTrue(room.containsCellAt(3, 4));
    }

    @Test
    void shouldReturnFalseIfDoesNotContainCell() {
        assertFalse(room.containsCellAt(4, 4));
    }

    @Test
    void shouldReturnTheSameForContains() {
        Cell cell = new Cell(3, 4);
        assertTrue(room.containsCell(cell));
        assertTrue(room.containsCellAt(cell.row(), cell.col()));

        Cell cell2 = new Cell(5, 8);

        assertThat(room.containsCell(cell2)).isEqualTo(room.containsCellAt(cell2.row(), cell2.col()));
    }

}
