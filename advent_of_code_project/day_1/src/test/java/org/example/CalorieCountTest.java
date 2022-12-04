package org.example;

import org.example.model.Elf;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalorieCountTest {

    @Test
    void calculateTotalCaloriesForElf() {
        int result = CalorieCount.calculateTotalCaloriesForElf(List.of(1,2));
        assertEquals(3, result);
    }

    @Test
    void getElfWithMostCalories() {
        Elf elf = new Elf(1);
        Elf elf2 = new Elf(3);
        Elf result = CalorieCount.getElfWithMostCalories(List.of(elf, elf2));
        assertEquals(elf2, result);

    }
}