package Server.Game;

public class Board {

    private int width;
    private int height;

    private int layers;
    private int layerLevel;

    private BoardMap myBoard;

    private int currentLevel;
    private BoardMap currentObject;
    private BoardMap[][] currentBoard;

    public Board(int width, int height, int layers){
        this.width = width;
        this.height = height;
        this.layers = layers;
        layerLevel = 0; // So the first board gets set to layer 1.

        myBoard = new BoardMap(this.width, this.height, this.layers, layerLevel, null);
        currentBoard = myBoard.getBoardMap();
        currentObject = myBoard;
        currentObject.generateLayer();
        currentLevel = currentObject.getLayerLevel();
    }

    private boolean hwCheck(int x, int y){
        if(x > 0 && x < 8 && y > 0 && y < 8){
            return true;
        }
        else{
            return false;
        }
    }

    // Debug function.
    public void printBoard(){
        for(int i = 0; i < width; i++){
            System.out.println();
            for(int a = 0; a < height; a++){
                System.out.print(currentObject.getLayerLevel() + "-" + i+ "-" + a + "  ");
            }
        }
    }

    public void goBack(){
        currentObject = currentObject.getParent();
        if(currentObject == null){
            currentObject = myBoard;
        }
    }

    public void traverseBoard(int x, int y){
        // Remember to make y one above the highest up piece.
        if(hwCheck(x, y) && currentLevel < layers){
            currentObject.setPlayingFor(x, y);
            currentObject = currentBoard[x][y];
            currentObject.generateLayer();
            currentBoard = currentObject.getBoardMap();

            currentLevel = currentObject.getLayerLevel();
        }
    }
}
