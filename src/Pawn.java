import java.awt.Color;

public class Pawn extends Piece{

    public Pawn(int row, int col, boolean whi) {
        super(row, col, whi);
    }
    public void draw(){
        if (white){
             StdDraw.picture(coords[1] / 8.0 + 1 / 16.0, coords[0] / 8.0 + 1 / 16.0, "/resources/Wesley.jpg", 0.1, 0.1);
        } else {
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.filledCircle(coords[1] / 8.0 + 1 / 16.0, coords[0] / 8.0 + 1 / 16.0, 0.02);
        }
    }

}
