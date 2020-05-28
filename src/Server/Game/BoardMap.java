package Server.Game;

public class BoardMap {
    private int width;
    private int height;

    private int layers;
    private int layerLevel;

    private BoardMap[][] boardMap;
    private BoardMap parent;

    private int[][] owner;

    // Keeps track of what position was last being played for.
    private int playingForX;
    private int playingForY;

    public BoardMap(int width, int height, int layers, int layerLevel, BoardMap parent){
        this.layers = layers - 1;
        this.layerLevel = layerLevel + 1;
        this.width = width;
        this.height = height;
        this.parent = parent;

        owner = new int[width][height];
        boardMap = new BoardMap[width][height];
    }

    public void generateLayer(){
        for(int i = 0; i < width; i++){
            for(int a = 0; a < height; a++){
                owner[i][a] = 0;
                boardMap[i][a] = new BoardMap(width, height, layers, layerLevel, this);
            }
        }
    }

    public void setPlayingFor(int x, int y){
        playingForX = x;
        playingForY = y;
    }

    public BoardMap getParent(){
        return parent;
    }

    public BoardMap[][] getBoardMap(){
        return boardMap;
    }

    public int getLayerLevel(){
        return layerLevel;
    }
}
