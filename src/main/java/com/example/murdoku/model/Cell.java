package com.example.murdoku.model;

import org.jspecify.annotations.NonNull;

import java.util.regex.MatchResult;
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

        Pattern pattern = Pattern.compile("(?i)(R|C)\\s*(-?\\d+)");
        Matcher matcher = pattern.matcher(cellString);

        Integer row = null;
        Integer col = null;

        while (matcher.find()) {
            String type = matcher.group(1).toUpperCase();
            int value = Integer.parseInt(matcher.group(2)) - 1;

            if (type.equals("R")) row = value;
            else if (type.equals("C")) col = value;
        }

        if (row == null || col == null) {
            throw new IllegalArgumentException("Invalid cell string: " + cellString);
        }

        return new Cell(row, col);
    }

    public String rowToString() {
        return String.format("R%d", (row + 1));
    }

    public String colToString() {
        return String.format("C%d", (col + 1));
    }
}
