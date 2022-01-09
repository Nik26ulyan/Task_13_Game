package ru.vsu.cs.course1.game;

public class SocobanGameParams {
    private String levelName;

    public SocobanGameParams(String levelName) {
        this.levelName = levelName;
    }

    public SocobanGameParams() {
        this("exampleLevel");
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelName() {
        return levelName;
    }
}
