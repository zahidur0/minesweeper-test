package com.tsi.training.rahman.mohammed.minesweeper;

/* responsible for creating the grid and if the user requires
* f - flag
* x for bomb
* forward slash for empty
* o for unrevealed
* */

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;


public class Grid extends Game{
    ////////////////////////////////////////fields/////////////////////////////////////////////////////
    private int totalBombs = 2;
    private int[][] bombIndices = new int[totalBombs][2];
    ////////////////////////////////////////properties/////////////////////////////////////////////////
    private int size = 8;

    String coordinates = "abcdefghijklmnopqrstuvwxyz";
    ////////////////////////////////////////constructors///////////////////////////////////////////////
    ////////////////////////////////////////methods////////////////////////////////////////////////////

    public Square[][] createGrid() {
        Square[][] gridSquares = new Square[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gridSquares[i][j] = new Square();
            }
        }

        // randomly assigns bombs to squares
        for (int i = 0; i < totalBombs; i++) {
            int[] randomPair = bombIndexPair(bombIndices);
            bombIndices[i] = randomPair;
            gridSquares[randomPair[0]][randomPair[1]].setBomb(true);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                bombsNear(i, j, gridSquares);
            }
        }
        return gridSquares;
    }

    public int[] bombIndexPair(int[][] bombIndices) {
        Random rand = new Random();
        int[] randomPair = {rand.nextInt(size), rand.nextInt(size)};
        for (int[] bombPair : bombIndices) {
            if (Arrays.equals(randomPair, bombPair)) {
                return bombIndexPair(bombIndices);
            }
        }
        return randomPair;
    }

    public void reveal(int x, int y, Square[][] gridSquares) {
        if (inBounds(x, y) && !gridSquares[x][y].isRevealed()) {
                gridSquares[x][y].setRevealed(true);
                if (gridSquares[x][y].getBombCount() == 0 && !gridSquares[x][y].isBomb()){
                    for (int xOffset = -1; xOffset <= 1; xOffset++) {
                        for (int yOffset = -1; yOffset <= 1; yOffset++) {
                            if (inBounds(x + xOffset, y + yOffset)) {
                                reveal(x + xOffset, y + yOffset, gridSquares);
                            }
                        }
                    }
                }
        }
    }

    public boolean inBounds(int x,int y){
        return x >= 0 && y >= 0 && size > x && size > y;
    }

    // calculates the bombCount of a specific square
    private void bombsNear(int x, int y, Square[][] gridSquares) {
        if (!gridSquares[x][y].isBomb()) {
            for (int xOffset = -1; xOffset <= 1; xOffset++) {
                for (int yOffset = -1; yOffset <= 1; yOffset++) {
                    if (inBounds(x + xOffset, y + yOffset) && gridSquares[x + xOffset][y + yOffset].isBomb()) {
                            gridSquares[x][y].setBombCount(gridSquares[x][y].getBombCount() + 1);
                    }
                }
            }
        }
    }

    public void printGrid(Square[][] gridLabels) {
        for (int i = 0; i < size; i++) {
            System.out.print("  " + coordinates.charAt(i) + "  ");
            for (int j = 0; j < size; j++) {
                gridLabels[i][j].printSquare();
            }
            System.out.println();
            System.out.println();
        }
        System.out.print("     ");
        for (int i = 0; i < size; i++) {
            System.out.print("  " + coordinates.charAt(i) + "  ");
        }
        System.out.println();
        System.out.println();
    }

    public String getCoordinates() {
        return coordinates;
    }

    public int[][] getBombIndices() {
        return bombIndices;
    }

    public int getTotalBombs() {
        return totalBombs;
    }

    public void setTotalBombs(int totalBombs) {
        this.totalBombs = totalBombs;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
