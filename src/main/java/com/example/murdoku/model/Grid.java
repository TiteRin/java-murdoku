package com.example.murdoku.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Grid {

    @JsonProperty("size")
    private final int size;
    private final Map<Cell, Room> rooms = new HashMap<>();
    private final Map<Cell, Item> items = new HashMap<>();

    public Grid(int size) {

        if (size <= 0) {
            throw new IllegalArgumentException("Grid size must be positive");
        }

        this.size = size;
    }

    public void placeRoom(Room room) {

        for (Cell cell : room.cells()) {
            if (getRoomAt(cell).isPresent()) throw new IllegalArgumentException();
            validateBounds(cell);
        }

        for (Cell cell : room.cells()) {
            rooms.put(cell, room);
        }
    }

    private void validateBounds(Cell cell) {
        if (cell.row() < 0 ||
                cell.col() < 0 ||
                cell.row() >= size ||
                cell.col() >= size) {
            throw new IllegalArgumentException("Cell is out of bounds: " + cell);
        }
    }

    public int size() {
        return size;
    }

    public int rows() {
        return size;
    }

    public int columns() {
        return size;
    }

    public Map<Cell, Room> rooms() {
        return Map.copyOf(rooms);
    }

    public Optional<Room> getRoomAt(Cell cell) {
        validateBounds(cell);
        return Optional.ofNullable(rooms.get(cell));
    }

    public Optional<Room> getRoomAt(int row, int col) {
        return getRoomAt(new Cell(row, col));
    }

    public void placeItem(Cell cell, Item item) {

        validateBounds(cell);

        if (getItemAt(cell).isPresent()) throw new IllegalArgumentException();
        items.put(cell, item);
    }

    public Optional<Item> getItemAt(Cell cell) {
        return Optional.ofNullable(items.get(cell));
    }

    public Optional<Item> getItemAt(int row, int col) {
        return getItemAt(new Cell(row, col));
    }
}
