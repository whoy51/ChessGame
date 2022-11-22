import java.awt.*;

public class Queen extends Piece{

    public Queen(int row, int col, boolean whi) {
        super(row, col, whi);
    }
    public void draw(){
        if (white){
            StdDraw.setPenColor(Color.WHITE);
        } else {
            StdDraw.setPenColor(Color.BLACK);
        }
        if (StdDraw.getPenColor() == Color.WHITE) {
            StdDraw.picture(coords[1] / 8.0 + 1 / 16.0, coords[0] / 8.0 + 1 / 16.0, "/resources/queen_white.png", 0.1, 0.1);
        } else {
            StdDraw.picture(coords[1] / 8.0 + 1 / 16.0, coords[0] / 8.0 + 1 / 16.0, "/resources/queen_black.png", 0.1, 0.1);
        }

    }
}
