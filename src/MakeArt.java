import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class MakeArt {
    //Fields
    private int gridSize;
    private List<Color> coloursList;
    private Color[][] pixelGrid;

    //classes
    public MakeArt() {
        gridSize = 4096;
                //4096;
        coloursList = fillSet();
        System.out.println("Colors Generated Successfully");
        makeGrid();
        createImage();
        System.out.println("Done!");
    }

    public List<Color> fillSet() {
        System.out.println("Preparing colours ... Please Wait!");
        List<Color> returnList = new ArrayList<>();
        for (int r = 0; r <= 255; r++) {
            for (int g = 0; g <= 255; g++) {
                for (int b = 0; b <= 255; b++) {
                        returnList.add(new Color(r,g,b));
                    }
                }
            }

        return returnList;
    }

    public void makeGrid() {
        System.out.println("Generating pixel grid");
        int count = 0;
        pixelGrid = new Color[gridSize][gridSize];

        for (int i = 0; i < pixelGrid.length; i++) {
            int row = 0;
            int col = i;

            while (col >= 0) {
                if (col > row) {
                    pixelGrid[row][col] = coloursList.get(count);
                    count++;
                    row++;
                } else {
                    pixelGrid[row][col] = coloursList.get(count);
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

    public void createImage() {
        try {
        BufferedImage bufferedImage = new BufferedImage(pixelGrid.length, pixelGrid[0].length, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < pixelGrid.length; x++) {
            for (int y = 0; y < pixelGrid[x].length; y++) {
                bufferedImage.setRGB(x, y, pixelGrid[x][y].getRGB());
            }
        }

        File outputFile = new File("art.png");
            ImageIO.write(bufferedImage, "png", outputFile);
        } catch (java.io.IOException e) { System.out.print("error: " + e);}


    }

    public static void main(String[] args) {
        MakeArt obj = new MakeArt();
    }
}
