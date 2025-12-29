package com.example.murdoku.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Nested
    class RoomTests {

        Grid grid;
        Room room;

        @BeforeEach
        void setUp() {
            this.grid = new Grid(9);

            this.room = new Room("Hallway");
            room.addCell(new Cell(1, 1));
            room.addCell(new Cell(2, 1));
            room.addCell(new Cell(3, 1));
            room.addCell(new Cell(3, 2));
            room.addCell(new Cell(3, 3));
            room.addCell(new Cell(3, 4));
            room.addCell(new Cell(3, 5));

            grid.placeRoom(room);


        }

        @Test
        void shouldPlaceRoomAndRetrieveIt() {
            Set<Room> rooms = new HashSet<>();
            rooms.add(room);

            assertThat(grid.rooms()).isEqualTo(rooms);
            assertThat(grid.getRoomAt(3, 1)).isEqualTo(room);
        }

        @Test
        void shouldReturnNullIfRoomDoesNotExist() {
            Grid grid = new Grid(9);
            assertNull(grid.getRoomAt(1, 1));
        }

        @Test
        void shouldThrowExceptionIfCellIsOutOfBounds() {
            Grid grid = new Grid(9);
            assertThrows(IllegalArgumentException.class, () -> grid.getRoomAt(10, 10));
        }

        @Test
        void shouldThrowExceptionIfRoomIsOutOfBounds() {
            Grid grid = new Grid(9);
            Room room = new Room("Hallway");
            room.addCell(new Cell(10, 10));
            assertThrows(IllegalArgumentException.class, () -> grid.placeRoom(room));
        }

        @Test
        void shouldThrowExceptionIfRoomOverlaps() {
            Grid grid = new Grid(9);
            Room room = new Room("Hallway");
            room.addCell(new Cell(1, 1));
            room.addCell(new Cell(2, 1));
            grid.placeRoom(room);
            Room room2 = new Room("Bedroom 1");
            room2.addCell(new Cell(2, 1));
            assertThrows(IllegalArgumentException.class, () -> grid.placeRoom(room2));
        }
    }


}
