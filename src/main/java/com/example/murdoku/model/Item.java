package com.example.murdoku.model;


public record Item(
        String name,
        String type,
        boolean canBeOccupied,
        int nbCells) implements GridObject {

    public Item {
        if (nbCells < 1) {
            throw new IllegalArgumentException("Number of cells must be greater than 0");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Item must have a name");
        }

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Item must have a type");
        }
    }

    public static Item singleCell(String name, String type, boolean canBeOccupied) {
        return new Item(name, type, canBeOccupied, 1);
    }
}
