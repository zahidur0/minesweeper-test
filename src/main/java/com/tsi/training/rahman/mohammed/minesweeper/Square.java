package com.tsi.training.rahman.mohammed.minesweeper;

import java.util.Objects;

public class Square {
    ////////////////////////////////////////fields///////////////////////////////////////////////
    private boolean flagged = false;
    private boolean bomb = false;
    private boolean revealed = false;
    private int bombCount = 0;
    private boolean bombIsFlagged = false;
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_YELLOW = "\u001B[33m";
    ////////////////////////////////////////properties////////////////////////////////////////////////
    ////////////////////////////////////////constructors///////////////////////////////////////////////
    ////////////////////////////////////////methods////////////////////////////////////////////////////
    public void printSquare() {
        if (Objects.equals(flagged, true)) {
            System.out.print(ANSI_BLUE + "  F  " + ANSI_RESET);
        } else if (Objects.equals(revealed, false)) {
            System.out.print(ANSI_RESET + "  ?  " + ANSI_RESET);
        } else if (Objects.equals(revealed, true)) {
            if (bombCount != 0) {
                System.out.print(ANSI_YELLOW + "  " + Integer.toString(bombCount)+ "  " + ANSI_RESET);
            } else if (Objects.equals(bomb, true)) {
                System.out.print(ANSI_RED + "  x  " + ANSI_RESET);
            } else if (bombCount == 0) {
                System.out.print(ANSI_GREEN + "  0  " + ANSI_RESET);
            }
        }
    }


    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public int getBombCount() {
        return bombCount;
    }

    public void setBombCount(int bombCount) {
        this.bombCount = bombCount;
    }
}
