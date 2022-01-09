package ru.vsu.cs.course1.game;

import ru.vsu.cs.util.ArrayUtils;

public class LevelLoader {
    public Game.SocobanCell[][] loadLevelFromFile(String fileName) {
        String[][] levelStringArray = ArrayUtils.readStringArray2FromFile("levels/" + fileName + ".txt");
        assert levelStringArray != null;
        return stringArrayToLevelField(levelStringArray);
    }

    private Game.SocobanCell[][] stringArrayToLevelField(String[][] levelStringArray) {
        Game.SocobanCell[][] field = new Game.SocobanCell[levelStringArray.length][levelStringArray[0].length];
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                switch (levelStringArray[r][c]) {
                    case "w":
                        field[r][c] = new Game.SocobanCell(Game.CellState.WALL);
                        break;
                    case "e":
                        field[r][c] = new Game.SocobanCell(Game.CellState.EMPTY);
                        break;
                    case "b":
                        field[r][c] = new Game.SocobanCell(Game.CellState.WRONG_BOX);
                        break;
                    case "s":
                        field[r][c] = new Game.SocobanCell(Game.CellState.PLACE_FOR_BOX);
                        break;
                    case "r":
                        field[r][c] = new Game.SocobanCell(Game.CellState.RIGHT_BOX);
                        break;
                    case "p":
                        field[r][c] = new Game.SocobanCell(Game.CellState.PLAYER);
                        break;
                }
            }
        }
        return field;
    }
}
