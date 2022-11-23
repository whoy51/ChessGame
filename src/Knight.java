import java.awt.Color;

public class Knight extends Piece{

    public Knight(int col, int row, boolean whi) {
        super(col, row, whi);
    }
    public void draw(){
        if ((coords[0] + coords[1]) % 2 == 0){
            StdDraw.setPenColor(new Color(128, 64, 0));
        } else {
            StdDraw.setPenColor(new Color(255, 204, 153));
        }
        StdDraw.filledSquare(coords[0] / 8.0 - 1/16.0, coords[1] / 8.0 - 1/16.0, 1/16.0);
        if (white){
            StdDraw.setPenColor(Color.WHITE);
        } else {
            StdDraw.setPenColor(Color.BLACK);
        }
        double[] x = {coords[0] / 8.0 - 1 / 16.0 - 0.02,coords[0] / 8.0 - 1 / 16.0 + 0.02,coords[0] / 8.0 - 1 / 16.0};
        double[] y = {coords[1] / 8.0 - 1 / 16.0 - 0.02,coords[1] / 8.0 - 1 / 16.0 - 0.02,coords[1] / 8.0 - 1 / 16.0 + 0.02};
        StdDraw.filledPolygon(x, y);
    }
    public boolean canMove(int col, int row){
        if ((Math.abs(coords[0] - col) == 1 && Math.abs(coords[1] - row) == 2) || (Math.abs(coords[0] - col) == 2 && Math.abs(coords[1] - row) == 1)){
            boolean occupied = false;
            for (int i = 0; i < 16; i++){
                int[] checker = {col, row};
                if (ChessGame.all[white? 0 : 1][i].coords[0] == checker[0] && ChessGame.all[white? 0 : 1][i].coords[1] == checker[1]){
                    occupied = true;
                    break;
                } else {
                    occupied = false;
                }
            }
            if (!occupied){
                System.out.println("Can Move");
                return true;
            } else {
                System.out.println("Cannot Move");
                return false;
            }
        } else {
            System.out.println("Impossible");
            return false;
        }
    }
}
