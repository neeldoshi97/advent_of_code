package org.example;

import org.example.model.RockPaperScissorEnum;
import org.example.model.UserResultEnum;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import static org.example.model.UserResultEnum.*;

public class RockPaperScissors {

    static Map<String, RockPaperScissorEnum> rockPaperScissorsInputMap = Map.of(
            "A", RockPaperScissorEnum.ROCK,
            "B", RockPaperScissorEnum.PAPER,
            "C", RockPaperScissorEnum.SCISSORS,
            "X", RockPaperScissorEnum.ROCK,
            "Y", RockPaperScissorEnum.PAPER,
            "Z", RockPaperScissorEnum.SCISSORS
    );

    public static void main(String[] args) {

        int totalPoints = 0;

        try {
            File file = RockPaperScissors.getFileFromResource("input.txt");

            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!data.isEmpty()) {
                    RockPaperScissorEnum opponentInput = retrieveSelectionFromInput(String.valueOf(data.charAt(0)));
                    RockPaperScissorEnum userInput = retrieveSelectionFromInput(String.valueOf(data.charAt(2)));

                    UserResultEnum resultEnum = checkResultOutcome(opponentInput, userInput);

                    totalPoints += calculateScoreForResult(userInput, resultEnum);

                }
            }
            myReader.close();
            System.out.println("total points for user: " + totalPoints);


        } catch (FileNotFoundException | URISyntaxException | NullPointerException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    public static UserResultEnum checkResultOutcome(RockPaperScissorEnum opponentInput, RockPaperScissorEnum userInput) {
        if (opponentInput.equals(userInput)) {
            return DRAW;
        }
        return userInput.getBeats().equals(opponentInput.getName()) ? WIN : LOSE;
    }

    public static int calculateScoreForResult(RockPaperScissorEnum userInput, UserResultEnum userResult) {
        return userInput.getScore() + userResult.getScore();
    }

    public static RockPaperScissorEnum retrieveSelectionFromInput(String input) {
        return rockPaperScissorsInputMap.get(input);
    }

    private static File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = RockPaperScissors.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }

    }
}