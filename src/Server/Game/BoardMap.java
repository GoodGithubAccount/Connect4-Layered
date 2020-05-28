package Server.Game;

public class BoardMap {
    private int height;
    private int width;

    private int layers;
    private int layerLevel;

    private BoardMap[][] boardMap;
    private BoardMap[][] parentBoard;

    public BoardMap(int height, int width, int layers, int layerLevel, BoardMap[][] parentBoard){
        this.layers = layers - 1;
        this.layerLevel = layerLevel + 1;
        this.height = height;
        this.width = width;
        this.parentBoard = parentBoard;

        boardMap = new BoardMap[height][width];
    }

    public void generateLayer(){
        for(int i = 0; i < height; i++){
            for(int a = 0; a < width; a++){
                boardMap[i][a] = new BoardMap(height, width, layers, layerLevel, boardMap);
            }
        }
    }

    public BoardMap[][] getBoardMap(){
        return boardMap;
    }

    public int getLayerLevel(){
        return layerLevel;
    }
}
