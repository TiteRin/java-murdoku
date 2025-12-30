package com.example.murdoku.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
            Map<Cell, Room> rooms = new HashMap<>();
            for (Cell cell : room.cells()) rooms.put(cell, room);

            assertThat(grid.rooms()).isEqualTo(rooms);
            assertThat(grid.getRoomAt(3, 1)).contains(room);
        }

        @Test
        void shouldReturnNullIfRoomDoesNotExist() {
            Grid grid = new Grid(9);
            assertThat(grid.getRoomAt(1, 1)).isEmpty();
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


    @Nested
    class ItemTests {

        Grid grid;
        Cell cell;

        @BeforeEach
        void setUp() {
            grid = new Grid(9);
            cell = new Cell(1, 1);
        }

        @Test
        void shouldReturnEmptyWhenNoItemIsPlaced() {
            assertThat(grid.getItemAt(cell)).isEmpty();
        }

//        @Test
//        void shouldReturnItemWhenItemIsPlaced() {
//
//            Item item = Item.singleCell("Chair", "Furniture", true);
//            grid.placeItem(cell, item);
//            assertThat(grid.getItemAt(cell)).contains(item);
//        }
//
//        @Test
//        void shouldThrowExceptionIfCellIsAlreadyOccupied() {
//            Item item = Item.singleCell("Chair", "Furniture", true);
//            grid.placeItem(cell, item);
//            assertThrows(IllegalArgumentException.class, () -> grid.placeItem(cell, item));
//        }
//
//        @Test
//        @DisplayName("Should throw exception if cell is out of bound")
//        void shouldThrowExceptionIfCellIsOutOfBounds() {
//            Cell cell = new Cell(10, 10);
//            assertThrows(IllegalArgumentException.class, () -> grid.placeItem(cell, Item.singleCell("Chair", "Furniture", true)));
//        }
    }
}
