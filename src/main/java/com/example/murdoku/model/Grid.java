package com.example.murdoku.model;

public class Grid {

    private final int size;

    public Grid(int size) {

        if (size <= 0) {
            throw new IllegalArgumentException("Grid size must be positive");
        }

        this.size = size;
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
}
