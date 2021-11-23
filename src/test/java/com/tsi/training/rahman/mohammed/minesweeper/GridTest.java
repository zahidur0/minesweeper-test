package com.tsi.training.rahman.mohammed.minesweeper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {
    @Test
    public void testInBounds() {
        Grid grid = new Grid();
        assertEquals(grid.inBounds(-1, -1), false, "failed inBounds test");
        assertEquals(grid.inBounds(3, 9), false, "failed inBounds test");
    }

    @Test
    public void testGetSize() {
        Grid grid = new Grid();
        int size = 8;
        grid.setSize(size);
        assertEquals(size, grid.getSize(), "failed getSize test");
    }

    @Test
    public void testSetSize() {
        Grid grid = new Grid();
        int size = 8;
        grid.setSize(size);
        assertEquals(size, grid.getSize(), "failed setSize test");
    }

    @Test
    public void testSetTotalBombs() {
        Grid grid = new Grid();
        int totalBombs = 10;
        grid.setTotalBombs(totalBombs);
        assertEquals(totalBombs, grid.getTotalBombs(), "failed setTotalBombs test");
    }

    @Test
    public void testGetTotalBombs() {
        Grid grid = new Grid();
        int totalBombs = 10;
        grid.setTotalBombs(totalBombs);
        assertEquals(totalBombs, grid.getTotalBombs(), "failed getTotalBombs test");
    }

    @Test
    public void testGetBombIndices() {
        Grid grid = new Grid();
        assertEquals(grid.getBombIndices().length, 10, "failed getBombIndices test");
    }

    @Test
    public void testGetCoordinates() {
        Grid grid = new Grid();
        assertEquals("abcdefghijklmnopqrstuvwxyz", grid.getCoordinates(), "failed getCoordinates test ");
    }
}
