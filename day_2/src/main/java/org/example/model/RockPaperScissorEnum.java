package org.example.model;

public enum RockPaperScissorEnum {
    ROCK(1, "rock", "scissors"), PAPER(2, "paper", "rock"), SCISSORS(3, "scissors", "paper");

    private final int score;
    private final String name;
    private final String beats;

    RockPaperScissorEnum(int score, String name, String beats) {
        this.score = score;
        this.name = name;
        this.beats = beats;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public String getBeats() {
        return beats;
    }
}
