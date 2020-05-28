package Server.Game;

public class Board {

    private int height;
    private int width;
    private int layers;
    private int layerLevel;

    private BoardMap[][] boardState;

    private int currentLevel;
    private BoardMap[][] currentObject;

    public Board(int height, int width, int layers){
        this.height = height;
        this.width = width;
        this.layers = layers;
        layerLevel = 0;

        boardState = new BoardMap[height][width];
        currentObject = boardState;
        currentLevel = 0;
        generateBoard();
    }

    private void generateBoard(){
        for(int i = 0; i < height; i++){
            for(int a = 0; a < width; a++){
                boardState[i][a] = new BoardMap(height, width, layers, layerLevel, boardState);
            }
        }
    }

    private boolean hwCheck(int y, int x){
        if(y > 0 && y < 8 && x > 0 && x < 8){
            return true;
        }
        else{
            return false;
        }
    }

    public int getLayerLevel(){
        return layerLevel;
    }

    // Debug function.
    public void printBoard(){
        for(int i = 0; i < height; i++){
            System.out.println();
            for(int a = 0; a < height; a++){
                System.out.print(currentObject[i][a].getLayerLevel() + "-" + i+ "-" + a + "  ");
            }
        }
    }

    public void traverseBoard(int y, int x){
        // Remember to make y zero later.
        if(hwCheck(y, x) && currentLevel < layers){
            currentObject[y][x].generateLayer();
            currentObject = currentObject[y][x].getBoardMap();
            currentLevel++;
        }
    }
}
