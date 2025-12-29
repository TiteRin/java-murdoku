package com.example.murdoku.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {

    @Test
    void shouldCreateItemWithCorrectValue() {
        Item item = new Item("Chair", "Furniture", true, 1);
        assertThat(item.name()).isEqualTo("Chair");
        assertThat(item.type()).isEqualTo("Furniture");
        assertThat(item.canBeOccupied()).isTrue();
        assertThat(item.nbCells()).isEqualTo(1);
    }

}
