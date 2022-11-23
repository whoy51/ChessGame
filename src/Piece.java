import java.awt.Color;

public class Piece {
    //Coords is an int array storing column and row in that order ranging from 1 - 8
    public int[] coords = new int[2];
    public boolean eaten = false;
    public boolean white;
    public void draw(){

    }
    public void move(int col, int row){
        System.out.println("Tryna move to " + col + ", " + row);
        if (this.canMove(col, row)){
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
