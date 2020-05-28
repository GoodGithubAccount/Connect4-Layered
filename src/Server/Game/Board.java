package Server.Game;

public class Board {

    private int height;
    private int width;
    private int layers;
    private int layerLevel;

    private BoardMap myBoard;

    private int currentLevel;
    private BoardMap currentObject;
    private BoardMap[][] currentBoard;

    // needs to be rewritten so we have currentObject, and currentBoard.
    // object needs to get the actual object, board needs to keept track of the current board, getting it from the current object.

    public Board(int height, int width, int layers){
        this.height = height;
        this.width = width;
        this.layers = layers;
        layerLevel = 0;

        myBoard = new BoardMap(this.height, this.width, this.layers, layerLevel, null);
        currentBoard = myBoard.getBoardMap();
        currentObject = myBoard;
        currentObject.generateLayer();
        currentLevel = 0;
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

    public void traverseBoard(int y, int x){
        // Remember to make y zero later.
        if(hwCheck(y, x) && currentLevel < layers){
            currentObject = currentBoard[y][x];
            currentObject.generateLayer();
            currentBoard = currentObject.getBoardMap();

            currentLevel++;
        }
    }
}
