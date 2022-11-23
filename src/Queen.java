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
        StdDraw.text(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "Q");
    }
}
