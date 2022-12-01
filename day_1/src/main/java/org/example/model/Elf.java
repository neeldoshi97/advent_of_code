package org.example.model;

public class Elf {

    private final Integer id;
    private final Integer totalCalories;

    public Elf(Integer id, Integer totalCalories) {
        this.id = id;
        this.totalCalories = totalCalories;
    }

    public Integer totalCalories() {
        return totalCalories;
    }
}
