package org.example;

import org.example.model.Elf;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CalorieCount {
    public static void main(String[] args) {

        List<Integer> calorieList = new ArrayList<>();
        List<Elf> elves = new ArrayList<>();

        try {
            File file = CalorieCount.getFileFromResource("input.txt");

            int id = 1;

            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!data.isEmpty()) {
                    calorieList.add(Integer.parseInt(data));
                } else {
                    elves.add(new Elf(id, calculateTotalCaloriesForElf(calorieList)));
                    id++;
                    calorieList.clear();
                }
            }
            myReader.close();
            System.out.println("Total elves: " + elves.size());
            System.out.println("Max number of calories for one elf: " + getElfWithMostCalories(elves).totalCalories());

        } catch (FileNotFoundException | URISyntaxException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static int calculateTotalCaloriesForElf(List<Integer> calorieList) {
        int totalCals = 0;
        for (Integer calorieCount : calorieList) {
            totalCals = totalCals + calorieCount;
        }
        return totalCals;
    }

    public static Elf getElfWithMostCalories(List<Elf> elves) {
        return Collections.max(elves, Comparator.comparing(Elf::totalCalories));
    }

    private static File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = CalorieCount.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }

    }
}