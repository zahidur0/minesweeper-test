package com.tsi.training.rahman.mohammed.minesweeper;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Hello, welcome to Minesweeper! \n");

        Grid grid = new Grid();
        Square[][] gridSquares = grid.createGrid();
        grid.printGrid(gridSquares);
        Game game = new Game();

        while (!game.isGameOver()) {

            if (game.getCorrectFlags() == grid.getTotalBombs()) {
                System.out.println("YOU WON!!");
                game.setGameOver(true);
                break;
            }

            System.out.println("Select a square:");
            String squareId = input.next();

            System.out.println("Reveal (r) or Flag (f) square?");
            String squareAction = input.next();

            game.screenUpdate(squareAction, squareId, gridSquares, grid);
        }

       // int correctFlags = 0;
       // boolean gameOver = false;
/*        while (!gameOver) {

            if (correctFlags == grid.getTotalBombs()) {
                System.out.println("YOU WON!!");
                break;
            }

            System.out.println("Select a square:");
            String squareId = input.next();

            System.out.println("Reveal (r) or Flag (f) square?");
            String squareAction = input.next();

            // finds square object using gridSquares[index 1][index 2] and sets reveal or flag to true depending on use input
            if (Objects.equals(squareAction.toLowerCase(), "r")) {
                if (gridSquares[grid.getCoordinates().indexOf(squareId.charAt(0))]
                        [grid.getCoordinates().indexOf(squareId.charAt(1))].isBomb()) {
                    grid.printGrid(gridSquares);
                    System.out.println("GAME OVER");
                    gameOver = true;
                } else {
                    grid.reveal(grid.getCoordinates().indexOf(squareId.charAt(0)),
                            grid.getCoordinates().indexOf(squareId.charAt(1)),
                            gridSquares);
                    grid.printGrid(gridSquares);
                }
            } else if (Objects.equals(squareAction.toLowerCase(), "f")) {
                gridSquares[grid.getCoordinates().indexOf(squareId.charAt(0))]
                        [grid.getCoordinates().indexOf(squareId.charAt(1))].setFlagged(true);
                if (gridSquares[grid.getCoordinates().indexOf(squareId.charAt(0))]
                        [grid.getCoordinates().indexOf(squareId.charAt(1))].isBomb()) {
                    correctFlags += 1;
                }
                grid.printGrid(gridSquares);
            }
        } */
    }
}
