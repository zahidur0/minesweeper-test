package com.tsi.training.rahman.mohammed.minesweeper;

import java.util.Objects;

public class Game {

    ////////////////////////////////////////fields////////////////////////////////////////////////////
    ////////////////////////////////////////properties////////////////////////////////////////////////
    private int correctFlags = 0;
    private boolean gameOver = false;
    ////////////////////////////////////////constructors///////////////////////////////////////////////
    ////////////////////////////////////////methods////////////////////////////////////////////////////
    public void screenUpdate(String squareAction, String squareId,
                             Square[][] gridSquares, Grid grid) {

        int gridSquareIndexY = grid.getCoordinates().indexOf(squareId.charAt(0));
        int gridSquareIndexX = grid.getCoordinates().indexOf(squareId.charAt(1));

        if (Objects.equals(squareAction.toLowerCase(), "r")) {

            if (gridSquares[gridSquareIndexY][gridSquareIndexX].isBomb()) {
                grid.printGrid(gridSquares);
                System.out.println("GAME OVER");
                gameOver = true;
            } else {
                grid.reveal(gridSquareIndexY, gridSquareIndexX, gridSquares);
                grid.printGrid(gridSquares);
            }
        } else if (Objects.equals(squareAction.toLowerCase(), "f")) {
            gridSquares[gridSquareIndexY][gridSquareIndexX].setFlagged(true);

            if (gridSquares[gridSquareIndexY][gridSquareIndexX].isBomb()) {
                correctFlags += 1;

            }
            grid.printGrid(gridSquares);
        }
    }

    public int getCorrectFlags() {
        return correctFlags;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

}