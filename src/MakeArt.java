import java.awt.*;
import java.io.Console;
import java.util.*;

public class MakeArt {
    //Fields
    private int gridSize;
    private Set<Color> colorsSet;
    private int[][] pixelGrid;

    //classes
    public MakeArt() {
        gridSize = 20;
                //4096;
        colorsSet = fillSet();
        makeGrid();
        drawGrid();
    }

    public Set<Color> fillSet() {
        Set<Color> returnSet = new HashSet<>();
        return returnSet;
    }

    public void makeGrid() {
        int count = 1;
        pixelGrid = new int[gridSize][gridSize];

        for (int i = 0; i < pixelGrid.length; i++) {
            int row = 0;
            int col = i;

            while (col >= 0) {
                if (col > row) {
                    pixelGrid[row][col] = count;
                    count++;
                    row++;
                } else {
                    pixelGrid[row][col] = count;
                    count++;
                    col--;
                }
            }
        }
    }

    public void drawGrid() {
        for (int row = 0; row < pixelGrid.length; row++) {
            for (int col = 0; col < pixelGrid[0].length; col++) {
                System.out.print(pixelGrid[row][col] + ", ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        MakeArt obj = new MakeArt();
    }
}
