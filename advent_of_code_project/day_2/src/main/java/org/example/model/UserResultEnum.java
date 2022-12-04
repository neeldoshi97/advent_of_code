package org.example.model;

public enum UserResultEnum {

    WIN(6), DRAW(3), LOSE(0);

    private final int score;

    UserResultEnum(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
