package com.example.murdoku.model;

import java.util.HashSet;
import java.util.Set;

public class Room {
    private final String name;
    private final Set<Cell> cells = new HashSet<>();

    public Room(String name) {
        this.name = name;
    }

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public String name() {
        return name;
    }

    public Set<Cell> cells() {
        return Set.copyOf(cells);
    }

    public boolean containsCell(int row, int col) {
        return cells.stream().anyMatch(cell -> cell.row() == row && cell.col() == col);
    }
}
