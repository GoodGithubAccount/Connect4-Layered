package Server.Game;

public class Board {

    private int height;
    private int width;
    private int layers;

    private BoardMap[][] boardState;

    public Board(int height, int width, int layers){
        this.height = height;
        this.width = width;
        this.layers = layers;

        boardState = new BoardMap[height][width];

        generateBoard();
    }

    private void generateBoard(){
        for(int i = 0; i < height; i++){
            System.out.print("\n" + i);
            for(int a = 0; a < width; a++){
                boardState[i][a] = new BoardMap(height, width, layers);
                System.out.print(a);
            }
        }
    }


}
