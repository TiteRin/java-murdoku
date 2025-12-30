package com.example.murdoku.model;

import org.jspecify.annotations.NonNull;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Cell(Integer row, Integer col) {
    public Cell {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("Row and column must be positive");
        }
    }

    @Override
    public @NonNull String toString() {
        return String.format("Cell(%s, %s)", rowToString(), colToString());
    }

    public static Cell fromString(String cellString) {
        Pattern regex = Pattern.compile("(R\\s*-?\\d+)\\D*(C\\s*-?\\d+)|(C\\s*-?\\d+)\\D*(R\\s*-?\\d+)");
        Matcher matcher = regex.matcher(cellString);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid cell string: " + cellString);
        }

        String group1 = matcher.group(1);
        String group2 = matcher.group(2);

        int col = -1, row = -1;

        if (group1.toLowerCase().startsWith("r")) {
            row = Integer.parseInt(group1.substring(1)) - 1;
        }
        if (group1.toLowerCase().startsWith("c")) {
            col = Integer.parseInt(group1.substring(1)) - 1;
        }

        if (group2.toLowerCase().startsWith("r")) {
            row = Integer.parseInt(group2.substring(1)) - 1;
        }
        if (group2.toLowerCase().startsWith("c")) {
            col = Integer.parseInt(group2.substring(1)) - 1;
        }

        System.out.println(row + " " + col);

        if (col >= 0 && row >= 0) return new Cell(row, col);

        throw new IllegalArgumentException("Invalid cell string: " + cellString);
    }

    public String rowToString() {
        return String.format("R%d", (row + 1));
    }

    public String colToString() {
        return String.format("C%d", (col + 1));
    }
}
