package com.example.murdoku.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemTest {

    @Test
    void shouldCreateItemWithCorrectValue() {
        Item item = new Item("Chair", "Furniture", true, 1);
        assertThat(item.name()).isEqualTo("Chair");
        assertThat(item.type()).isEqualTo("Furniture");
        assertThat(item.canBeOccupied()).isTrue();
        assertThat(item.nbCells()).isEqualTo(1);
    }

    @Test
    void shouldRejectCreationIfMissingValue() {
        assertThrows(IllegalArgumentException.class, () -> new Item(null, "Furniture", true, 1));
        assertThrows(IllegalArgumentException.class, () -> new Item("Chair", null, true, 1));
        assertThrows(IllegalArgumentException.class, () -> new Item("Chair", "Furniture", true, 0));
    }

    @Test
    void shouldReturnSingleCellItem() {
        Item item = Item.singleCell("Chair", "Furniture", true);
        assertThat(item.name()).isEqualTo("Chair");
        assertThat(item.type()).isEqualTo("Furniture");
        assertThat(item.canBeOccupied()).isTrue();
        assertThat(item.nbCells()).isEqualTo(1);
    }

}
