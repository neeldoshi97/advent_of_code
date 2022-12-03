package org.example;

import org.example.model.RockPaperScissorEnum;
import org.example.model.UserResultEnum;
import org.junit.jupiter.api.Test;

import static org.example.model.RockPaperScissorEnum.*;
import static org.example.model.UserResultEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RockPaperScissorsTest {

    @Test
    public void testGetRockPaperScissorsOptionFromInput_OpponentRock(){
        RockPaperScissorEnum result = RockPaperScissors.retrieveSelectionFromInput("A");
        assertEquals(ROCK, result);
    }

    @Test
    public void testGetRockPaperScissorsOptionFromInput_OpponentPaper(){
        RockPaperScissorEnum result = RockPaperScissors.retrieveSelectionFromInput("B");
        assertEquals(PAPER, result);
    }
    @Test
    public void testGetRockPaperScissorsOptionFromInput_OpponentScissors(){
        RockPaperScissorEnum result = RockPaperScissors.retrieveSelectionFromInput("C");
        assertEquals(SCISSORS, result);
    }

    @Test
    public void testGetRockPaperScissorsOptionFromInput_UserRock(){
        RockPaperScissorEnum result = RockPaperScissors.retrieveSelectionFromInput("X");
        assertEquals(ROCK, result);
    }

    @Test
    public void testGetRockPaperScissorsOptionFromInput_UserPaper(){
        RockPaperScissorEnum result = RockPaperScissors.retrieveSelectionFromInput("Y");
        assertEquals(PAPER, result);
    }
    @Test
    public void testGetRockPaperScissorsOptionFromInput_UserScissors(){
        RockPaperScissorEnum result = RockPaperScissors.retrieveSelectionFromInput("Z");
        assertEquals(SCISSORS, result);
    }


    @Test
    public void testRockBeatsScissors_userWins(){
        UserResultEnum userResultEnum = RockPaperScissors.checkResultOutcome(SCISSORS, ROCK);
        assertEquals(WIN, userResultEnum);
    }

    @Test
    public void testPaperBeatsRock_userLoses(){
        UserResultEnum userResultEnum = RockPaperScissors.checkResultOutcome(PAPER, ROCK);
        assertEquals(LOSE, userResultEnum);
    }

    @Test
    public void testScissorsBeatsPaper_userWins(){
        UserResultEnum userResultEnum = RockPaperScissors.checkResultOutcome(PAPER, SCISSORS);
        assertEquals(WIN, userResultEnum);
    }

    @Test
    public void testScissorsBeatsPaper_userLoses(){
        UserResultEnum userResultEnum = RockPaperScissors.checkResultOutcome(SCISSORS, PAPER);
        assertEquals(LOSE, userResultEnum);
    }

    @Test
    public void testPaperAndPaperIsDraw(){
        UserResultEnum userResultEnum = RockPaperScissors.checkResultOutcome(PAPER, PAPER);
        assertEquals(DRAW, userResultEnum);
    }

    @Test
    public void testScissorsAndScissorsIsDraw(){
        UserResultEnum userResultEnum = RockPaperScissors.checkResultOutcome(SCISSORS, SCISSORS);
        assertEquals(DRAW, userResultEnum);
    }

    @Test
    public void testRockAndRockIsDraw(){
        UserResultEnum userResultEnum = RockPaperScissors.checkResultOutcome(ROCK, ROCK);
        assertEquals(DRAW, userResultEnum);
    }

    @Test
    public void testCalculateResult_WhenUserWins_Paper(){
        int result = RockPaperScissors.calculateScoreForResult(PAPER, WIN);
        assertEquals(8, result);
    }

    @Test
    public void testCalculateResult_WhenUserWins_Rock(){
        int result = RockPaperScissors.calculateScoreForResult(ROCK, WIN);
        assertEquals(7, result);
    }

    @Test
    public void testCalculateResult_WhenUserWins_Scissors(){
        int result = RockPaperScissors.calculateScoreForResult(SCISSORS, WIN);
        assertEquals(9, result);
    }

    @Test
    public void testCalculateResult_WhenUserDraws_Paper(){
        int result = RockPaperScissors.calculateScoreForResult(PAPER, DRAW);
        assertEquals(5, result);
    }

    @Test
    public void testCalculateResult_WhenUserDraws_Rock(){
        int result = RockPaperScissors.calculateScoreForResult(ROCK, DRAW);
        assertEquals(4, result);
    }

    @Test
    public void testCalculateResult_WhenUserDraws_Scissors(){
        int result = RockPaperScissors.calculateScoreForResult(SCISSORS, DRAW);
        assertEquals(6, result);
    }

    @Test
    public void testCalculateResult_WhenUserLoses_Paper(){
        int result = RockPaperScissors.calculateScoreForResult(PAPER, LOSE);
        assertEquals(2, result);
    }

    @Test
    public void testCalculateResult_WhenUserLoses_Rock(){
        int result = RockPaperScissors.calculateScoreForResult(ROCK, LOSE);
        assertEquals(1, result);
    }

    @Test
    public void testCalculateResult_WhenUserLoses_Scissors(){
        int result = RockPaperScissors.calculateScoreForResult(SCISSORS, LOSE);
        assertEquals(3, result);
    }
}