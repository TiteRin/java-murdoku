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

        String[] results = extractCoordinates(cellString);

        return new Cell(
                Integer.parseInt(results[0].substring(1)) - 1,
                Integer.parseInt(results[1].substring(1)) - 1
        );
    }

    private static String[] extractCoordinates(String cellString) {
        Pattern regex = Pattern.compile("(?<R1>R\\s*-?\\d+)\\D*(?<C1>C\\s*-?\\d+)|(?<C2>C\\s*-?\\d+)\\D*(?<R2>R\\s*-?\\d+)(R\\s*-?\\d+)\\D*(C\\s*-?\\d+)|(C\\s*-?\\d+)\\D*(R\\s*-?\\d+)");
        Matcher matcher = regex.matcher(cellString);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid cell string: " + cellString);
        }

        MatchResult results = matcher.toMatchResult();
        String[] coordinates = new String[2];

        if (results.group("R1") != null && results.group("C1") != null) {
            coordinates[0] = results.group("R1");
            coordinates[1] = results.group("C1");
            return coordinates;
        }

        if (results.group("C2") != null && results.group("R2") != null) {
            coordinates[0] = results.group("R2");
            coordinates[1] = results.group("C2");
            return coordinates;
        }

        throw new IllegalArgumentException("Invalid cell string: " + cellString);
    }

    public String rowToString() {
        return String.format("R%d", (row + 1));
    }

    public String colToString() {
        return String.format("C%d", (col + 1));
    }
}
