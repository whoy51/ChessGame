import java.awt.Color;

public class Bishop extends Piece{

    public Bishop(int col, int row, boolean whi) {
        super(col, row, whi);
    } 
    public void draw(){
        if (white){
            StdDraw.setPenColor(Color.WHITE);
        } else {
            StdDraw.setPenColor(Color.BLACK);
        }
        double[] x = {coords[0] / 8.0 -1 / 16.0 - 0.02,coords[0] / 8.0 -1 / 16.0,coords[0] / 8.0 -1 / 16.0 + 0.02, coords[0] / 8.0 -1 / 16.0};
        double[] y = {coords[1] / 8.0 -1 / 16.0,coords[1] / 8.0 -1 / 16.0 - 0.02,coords[1] / 8.0 -1 / 16.0, coords[1] / 8.0 -1 / 16.0 + 0.02};
        StdDraw.filledPolygon(x, y);
    }
    public boolean canMove(int col, int row){
        //System.out.println("Testing");
        if (Math.abs(coords[0] - col) == Math.abs(coords[1] - row)){
            boolean occupied = false;
            for (int i = 0; i < 16; i++){
                int deltaX = (coords[0] - col > 0)? 1: -1;
                int deltaY = (coords[1] - col > 0)? 1: -1;
                for (int j = Math.abs(coords[0] - col) ; j > 0; j--) {
                    int[] checker = {coords[0] - (j * deltaX), coords[1] - (j * deltaY)};
                    //System.out.println("Checking " + checker[0] + ", " + checker[1]);
                    if (ChessGame.all[white? 0 : 1][i].coords[0] == checker[0] && ChessGame.all[white? 0 : 1][i].coords[1] == checker[1]){
                        occupied = true;
                        System.out.println("Occupied");
                        break;
                    } else {
                        occupied = false;
                    }
                }
                if (occupied){
                    break;
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
            return false;
        }
    }
}
