import java.awt.Color;
import java.util.*;


public class Piece {
    //Coords is an int array storing column and row in that order ranging from 1 - 8
    public int[] coords = new int[2];
    public boolean white;
    public void draw(){

    }
    public boolean move(int col, int row){
        System.out.println("Trying to move to " + col + ", " + row);
        if (this.canMove(col, row)){
            //This takes pieces
            for (int i = 0; i < 16; i++) {
                int[] checker = {col, row};
                if (ChessGame.all[white ? 1 : 0][i].coords[0] == checker[0] && ChessGame.all[white ? 1 : 0][i].coords[1] == checker[1]) {
                    ChessGame.all[white ? 1 : 0][i].coords[0] = -1;
                    ChessGame.all[white ? 1 : 0][i].coords[1] = -1;
                }
            }
            int[] oldC = {coords[0],coords[1]};
            coords[0] = col;
            coords[1] = row;
            if ((oldC[0] + oldC[1]) % 2 == 0){
                StdDraw.setPenColor(new Color(128, 64, 0));
            } else {
                StdDraw.setPenColor(new Color(255, 204, 153));
            }
            StdDraw.filledSquare(oldC[0] / 8.0 - 1 / 16.0, oldC[1] / 8.0 - 1 / 16.0, 1/16.0);
            this.draw();
            if (ChessGame.turn == Turn.WHITE) {
                ChessGame.turn = Turn.BLACK;
                StdDraw.setTitle("Turn: Black");
            }else {
                ChessGame.turn = Turn.WHITE;
                StdDraw.setTitle("Turn: White");
            }
            return true;
        } else {
            return false;
        }
    }
    public boolean canMove(int col, int row){
        return true;
    }
    public Piece(int col, int row, boolean whi){
        coords[0] = col;
        coords[1] = row;
        white = whi;
        this.draw();
    }
}
