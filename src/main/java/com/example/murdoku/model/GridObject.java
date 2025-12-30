package com.example.murdoku.model;

import java.util.Set;

public interface GridObject {

    String name();
    Set<Cell> cells();

    void addCell(Cell cell);
    void setCells(Set<Cell> cells);

    default boolean containsCellAt(int row, int col) {
        return this.cells().stream().anyMatch(cell -> cell.row() == row && cell.col() == col);
    }

    default boolean containsCell(Cell cell) {
        return this.cells().contains(cell);
    }
}
