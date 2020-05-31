package GUI;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JPanel {

    private int width;
    private int height;

    private int gridSize;
    private int gridCountWidth;
    private int gridCountHeight;

    private int startingPointX;
    private int startingPointY;


    public MainGUI(int width, int height, int gridSize, int gridCountWidth, int gridCountHeight, int startingPointX, int startingPointY){
        this.width = width;
        this.height = height;
        this.gridSize = gridSize;
        this.gridCountWidth = gridCountWidth;
        this.gridCountHeight = gridCountHeight;
        this.startingPointX = startingPointX;
        this.startingPointY = startingPointY;

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(board);
    }

    private JPanel board = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Color myColor = Color.GRAY;
            g.setColor(myColor);

            int newX = startingPointX;
            int newY = startingPointY;


            for(int i = 0; i < gridCountHeight; i++){
                g.setColor(Color.BLACK);
                g.fillRect(newX, newY, (gridSize * gridCountWidth) + ((gridSize / 20) * (gridCountWidth + 1)), gridSize / 20);

                newY += gridSize / 20;

                for(int a = 0; a < gridCountWidth * 2 + 1; a++){
                    if(a % 2 == 0){
                        g.setColor(Color.BLACK);
                        g.fillRect(newX, newY, gridSize / 20, gridSize);

                        newX += gridSize / 20;
                    }
                    else{
                        g.setColor(myColor);
                        if(myColor == Color.GRAY) myColor = Color.LIGHT_GRAY;
                        else myColor = Color.GRAY;

                        g.fillRect(newX, newY, gridSize, gridSize);
                        newX += gridSize;
                    }
                }
                newX = startingPointX;
                newY += gridSize;
            }
            g.setColor(Color.BLACK);
            g.fillRect(newX, newY, (gridSize * gridCountWidth) + ((gridSize / 20) * (gridCountWidth + 1)), gridSize / 20);

        }
    };
}