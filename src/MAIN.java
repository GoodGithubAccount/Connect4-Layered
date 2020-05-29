import GUI.MainGUI;
import com.sun.tools.javac.Main;

public class MAIN {

    private int width;
    private int height;
    private int gridSize;
    private int gridCountWidth;
    private int gridCountHeight;


    public static void main(String[] args) {
        int userWidth = 1600;
        int userHeight = 900;

        //gridSize = (width / 100) * 3;

        MAIN myMain = new MAIN(userWidth, userHeight);
        myMain.StartGUI();
    }

    public MAIN(int width, int height){
        this.width = width;
        this.height = height;
        gridSize = height / 5;
    }

    private void StartGUI(){
        gridCountWidth = 7;
        gridCountHeight= 6;

        while(gridCountWidth * gridSize > width - 200 || gridCountHeight * gridSize > height - 200){
            gridSize -= 5;
        }

        int calculationWidth = (gridCountWidth * gridSize);
        int calculationHeight = (gridCountHeight * gridSize);

        int startingPointX = (width - calculationWidth) / 2;
        int startingPointY = (height - calculationHeight - (gridSize / 2)) / 2;

        MainGUI myGUI = new MainGUI(width, height, gridSize, gridCountWidth, gridCountHeight, startingPointX, startingPointY);
    }
}