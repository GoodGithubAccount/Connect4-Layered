package Client;

import GUI.MainGUI;

import java.awt.*;

public class ClientGUI {

    private int width;
    private int height;
    private int gridSize;
    private int gridCountWidth;
    private int gridCountHeight;

    private Color[] colorArray;

    public ClientGUI(int width, int height){
        this.width = width;
        this.height = height;
        gridSize = height / 5;

        // Just temp color shit. 
        colorArray = new Color[]{Color.BLACK, Color.GRAY, Color.YELLOW, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.PINK, Color.ORANGE};
    }

    void StartGUI(){
        gridCountWidth = 7;
        gridCountHeight= 6;

        while(gridCountWidth * gridSize > width - 200 || gridCountHeight * gridSize > height - 200){
            gridSize -= 5;
        }

        int calculationWidth = (gridCountWidth * gridSize + gridSize / 10 * gridCountWidth);
        int calculationHeight = (gridCountHeight * gridSize + gridSize / 10 * gridCountHeight);

        int startingPointX = (width - calculationWidth) / 2;
        int startingPointY = (height - calculationHeight - (gridSize / 2)) / 2;

        MainGUI myGUI = new MainGUI(width, height, gridSize, gridCountWidth, gridCountHeight, startingPointX, startingPointY);
    }
}