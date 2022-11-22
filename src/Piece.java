public class Piece {
    public int[] coords = new int[2];
    public boolean eaten = false;
    public boolean white;
    public void draw(){

    }
    public Piece(int row, int col, boolean whi){
        coords[0] = row - 1;
        coords[1] = col - 1;
        white = whi;
        this.draw();
    }
}
