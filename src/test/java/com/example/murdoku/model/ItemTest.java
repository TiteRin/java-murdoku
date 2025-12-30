package com.example.murdoku.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemTest {

    @Test
    void shouldCreateItemWithCorrectValue() {
        Item item = new Item("Chair", new Cell(1, 1), true);
        assertThat(item.name()).isEqualTo("Chair");
        assertThat(item.canBeOccupied()).isTrue();
    }

    @Test
    void shouldRejectCreationIfMissingValue() {
        assertThrows(IllegalArgumentException.class, () -> new Item(null, new Cell(0, 0), true));
        assertThrows(IllegalArgumentException.class, () -> new Item("Chair", new Cell(-1, -1), true));
    }
}
