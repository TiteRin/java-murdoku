package com.example.murdoku.model;

import java.util.HashSet;
import java.util.Set;

public class Room implements GridObject {
    private final String name;
    private final Set<Cell> cells = new HashSet<>();

    public Room(String name) {
        this.name = name;
    }

    public Room(String name, Set<Cell> cells) {
        this.name = name;
        setCells(cells);
    }

    public String name() {
        return name;
    }

    public Set<Cell> cells() {
        return Set.copyOf(cells);
    }

    @Override
    public void addCell(Cell cell) {
        this.cells.add(cell);
    }

    @Override
    public void setCells(Set<Cell> cells) {
        this.cells.clear();
        this.cells.addAll(cells);
    }
}
