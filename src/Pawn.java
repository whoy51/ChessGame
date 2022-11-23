import java.awt.Color;

public class Pawn extends Piece{

    public Pawn(int col, int row, boolean whi) {
        super(col, row, whi);
    }
    public void draw(){
        if (white){
            StdDraw.setPenColor(Color.WHITE);
        } else {
            StdDraw.setPenColor(Color.BLACK);
        }
        StdDraw.filledCircle(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, 0.02);
        if (StdDraw.getPenColor() == Color.WHITE) {
            StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/Juan.jpg", 0.1, 0.1);
        } else {
            StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/Wesley.jpg", 0.1, 0.1);
        }
    }
    // public boolean canMove(int col, int row){
    //     if (Math.abs(coords[0] - col) == 0 && Math.abs(coords[1] - row) == 1){
    //         boolean occupied = false;
    //         for (int i = 0; i < 16; i++){
    //             //System.out.println("Check iteration " + i);
    //             int[] checker = {col, row};
    //             //System.out.println(checker[0] + ", " + checker[1]);
    //             //System.out.println(ChessGame.all[white? 0 : 1][i].coords[0] + ", " + ChessGame.all[white? 0 : 1][i].coords[1]);
    //             if (ChessGame.all[white? 0 : 1][i].coords[0] == checker[0] && ChessGame.all[white? 0 : 1][i].coords[1] == checker[1]){
    //                 occupied = true;
    //                 //System.out.println("Spot occupied");
    //                 break;
    //             } else {
    //                 occupied = false;
    //             }
    //         }
    //         if (!occupied){
    //             System.out.println("Can Move");
    //             return true;
    //         } else {
    //             System.out.println("Cannot Move");
    //             return false;
    //         }
    //     } else {
    //         return false;
    //     }
    // }
}
