import java.awt.Color;

public class Queen extends Piece{

    public Queen(int col, int row, boolean whi) {
        super(col, row, whi);
    }
    public void draw(){
        if (white){
            StdDraw.setPenColor(Color.WHITE);
        } else {
            StdDraw.setPenColor(Color.BLACK);
        }
        if (StdDraw.getPenColor() == Color.WHITE) {
            StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/queen_white.jpg", 0.1, 0.1);
        } else {
            StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/queen_black.jpg", 0.1, 0.1);
        }
    }
}
