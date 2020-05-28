package Server.Game;

import java.util.Scanner;

public class TempUseBoard {


    public static void main(String[] args) {
        Board myBoard = new Board(8, 8, 3);

        myBoard.printBoard();

        Scanner sc = new Scanner(System.in);


        while(true){
            int x = Integer.parseInt(sc.nextLine());
            int y = Integer.parseInt(sc.nextLine());

            myBoard.traverseBoard(x, y);
            myBoard.printBoard();

        }
    }

}
