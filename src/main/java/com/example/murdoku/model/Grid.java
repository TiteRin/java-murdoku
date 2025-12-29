package com.example.murdoku.model;

import java.util.HashSet;
import java.util.Set;

public class Grid {

    private final int size;
    private final Set<Room> rooms = new HashSet<>();

    public Grid(int size) {

        if (size <= 0) {
            throw new IllegalArgumentException("Grid size must be positive");
        }

        this.size = size;
    }

    public void placeRoom(Room room) {

        if (room.cells().stream().anyMatch(cell -> getRoomAt(cell.row(), cell.col()) != null)) {
            throw new IllegalArgumentException("Room overlaps with another room");
        }

        if (room.cells().stream().anyMatch(cell -> cell.row() < 0 || cell.col() < 0 || cell.row() >= size || cell.col() >= size)) {
            throw new IllegalArgumentException("Room contains cell out of bounds");
        }
        this.rooms.add(room);
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

    public Set<Room> rooms() {
        return Set.copyOf(rooms);
    }

    public Room getRoomAt(int row, int col) {

        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Cell is out of bounds");
        }

        for (Room room : rooms) {
            if (room.containsCell(row, col)) {
                return room;
            }
        }
        return null;
    }
}
