package Server.Game;

public class BoardMap {
    private int height;
    private int width;
    private int layers;

    private BoardMap[][] boardMap;

    public BoardMap(int height, int width, int layers){
        this.layers = (layers - 1);
        this.height = height;
        this.width = width;

        boardMap = new BoardMap[height][width];

        if(layers > 0){
            generateBoardMap();
        }
    }

    private void generateBoardMap(){
        for(int i = 0; i < height; i++){
            for(int a = 0; a < width; a++){
                boardMap[i][a] = new BoardMap(height, width, layers);
            }
        }
    }
}
