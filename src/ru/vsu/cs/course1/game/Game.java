package ru.vsu.cs.course1.game;

import javax.swing.*;

public class Game {

    public enum GameState {
        NOT_STARTED,
        PLAYING,
        WIN,
        FAIL
    }

    public enum CellState {
        EMPTY,
        WALL,
        PLAYER,
        WRONG_BOX,
        PLACE_FOR_BOX,
        RIGHT_BOX
    }


    public static class SocobanCell {
        private CellState state;

        public SocobanCell(CellState state) {
            this.state = state;
        }

        public CellState getState() {
            return state;
        }
    }

    private static final int TIME_FOR_ONE_BOX = 20;
    private Timer gameTimer = new Timer(1000, e -> {
        this.timeLeft--;
    });
    private SocobanCell[][] field = null;
    private GameState state = GameState.NOT_STARTED;
    private CellState cellUnderPlayer = CellState.EMPTY;
    private int wrongBoxCount = 0;
    private int timeLeft = 0;
    private int playerRow = 0, playerCol = 0;

    public Game() {
    }

    public void newGame(String fileName) {
        LevelLoader levelLoader = new LevelLoader();
        field = levelLoader.loadLevelFromFile(fileName);

        this.wrongBoxCount = 0;

        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                switch (field[r][c].state) {
                    case WRONG_BOX:
                        this.wrongBoxCount++;
                        break;
                    case PLAYER:
                        this.playerRow = r;
                        this.playerCol = c;
                        break;
                }
            }
        }
        timeLeft = wrongBoxCount * TIME_FOR_ONE_BOX;
        cellUnderPlayer = CellState.EMPTY;
        gameTimer.restart();
        state = GameState.PLAYING;
    }

    public void movePlayer(int rowMove, int colMove) {
        if (state != GameState.PLAYING) {
            return;
        }

        int playerRow = getPlayerRow(), playerCol = getPlayerCol();
        int verticalMovement = playerRow + rowMove;
        int horizontalMovement = playerCol + colMove;

        switch (field[verticalMovement][horizontalMovement].getState()) {
            case WALL:
                break;
            case EMPTY:
                movePlayerWithoutBox(verticalMovement,  horizontalMovement,  rowMove,  colMove, playerRow,  playerCol, CellState.EMPTY);
                break;
            case WRONG_BOX:
                movePlayerWithBox(verticalMovement,  horizontalMovement,  rowMove,  colMove, playerRow,  playerCol, CellState.EMPTY);
                break;
            case PLACE_FOR_BOX:
                movePlayerWithoutBox(verticalMovement,  horizontalMovement,  rowMove,  colMove, playerRow,  playerCol, CellState.PLACE_FOR_BOX);
                break;
            case RIGHT_BOX:
                movePlayerWithBox(verticalMovement,  horizontalMovement,  rowMove,  colMove, playerRow,  playerCol, CellState.PLACE_FOR_BOX);
                break;
        }
        calculateGameState();
    }

    private void movePlayerWithBox(int verticalMovement, int horizontalMovement, int rowMove, int colMove,
                                   int playerRow, int playerCol, CellState cellOnPlayerWay) {
        if (field[verticalMovement + rowMove][horizontalMovement + colMove].state != CellState.WALL
                && field[verticalMovement + rowMove][horizontalMovement + colMove].state != CellState.WRONG_BOX
                && field[verticalMovement + rowMove][horizontalMovement + colMove].state != CellState.RIGHT_BOX) {
            field[playerRow][playerCol].state = cellUnderPlayer;
            if (field[verticalMovement + rowMove][horizontalMovement + colMove].state == CellState.PLACE_FOR_BOX) {
                field[verticalMovement + rowMove][horizontalMovement + colMove].state = CellState.RIGHT_BOX;
                if (field[verticalMovement][horizontalMovement].state == CellState.WRONG_BOX){
                    wrongBoxCount--;
                }
            } else {
                field[verticalMovement + rowMove][horizontalMovement + colMove].state = CellState.WRONG_BOX;
                if (field[verticalMovement][horizontalMovement].state == CellState.RIGHT_BOX){
                    wrongBoxCount++;
                }
            }
            field[verticalMovement][horizontalMovement].state = CellState.PLAYER;
            cellUnderPlayer = cellOnPlayerWay;
            this.playerRow += rowMove;
            this.playerCol += colMove;
        }
    }

    private void movePlayerWithoutBox(int verticalMovement, int horizontalMovement, int rowMove, int colMove,
                                      int playerRow, int playerCol, CellState cellOnPlayerWay) {
        field[verticalMovement][horizontalMovement].state = CellState.PLAYER;
        field[playerRow][playerCol].state = cellUnderPlayer;
        cellUnderPlayer = cellOnPlayerWay;
        this.playerRow += rowMove;
        this.playerCol += colMove;
    }

    private void calculateGameState() {
        if (this.wrongBoxCount == 0) {
            state = GameState.WIN;
        } else if (timeLeft <= 0) {
            state = GameState.FAIL;
            gameTimer.stop();
        }
    }

    public GameState getState() {
        return state;
    }

    public int getRowCount() {
        return field == null ? 0 : field.length;
    }

    public int getColCount() {
        return field == null ? 0 : field[0].length;
    }

    public int getPlayerRow() {
        return playerRow;
    }

    public int getPlayerCol() {
        return playerCol;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public SocobanCell getCell(int row, int col) {
        return (row < 0 || row >= getRowCount() || col < 0 || col >= getColCount()) ? null : field[row][col];
    }
}
