package com.example.murdoku.model;


import java.util.HashSet;
import java.util.Set;

public class Item implements GridObject {

    private final String name;
    private final Set<Cell> cells = new HashSet<>();
    private final boolean canBeOccupied;

    public Item(String name, Cell cell, boolean canBeOccupied) {
        this(name, Set.of(cell), canBeOccupied);
    }


    public Item(String name, Set<Cell> cells, boolean canBeOccupied) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Item must have a name");
        }

        this.name = name;
        this.canBeOccupied = canBeOccupied;

        setCells(cells);
    }

    public String name() {
        return name;
    }

    public Set<Cell> cells() {
        return Set.copyOf(cells);
    }

    public boolean canBeOccupied() {
        return canBeOccupied;
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
