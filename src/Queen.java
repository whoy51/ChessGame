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
        StdDraw.text(coords[1] / 8.0 + 1 / 16.0, coords[0] / 8.0 + 1 / 16.0, "Q");
    }
}
