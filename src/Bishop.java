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
        System.out.print("test");
    }  
}
