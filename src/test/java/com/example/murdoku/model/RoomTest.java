package com.example.murdoku.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;

public class RoomTest {

    @Test
    void shouldCollectAddedCell() {
        Room room = new Room("Hallway");
        room.addCell(new Cell(1, 1));
        room.addCell(new Cell(2, 1));
        room.addCell(new Cell(3, 1));
        room.addCell(new Cell(3, 2));
        room.addCell(new Cell(3, 3));
        room.addCell(new Cell(3, 4));
        room.addCell(new Cell(3, 5));

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
}
