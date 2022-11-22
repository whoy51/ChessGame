import java.awt.Color;
public class Board {
    public static double[][][] boardCoords= new double[8][8][2];
    public static void fillCoords(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                boardCoords[i][j][0] = i / 8.0 + 1/16.0;
                //System.out.println(boardCoords[i][j][0]);
                boardCoords[i][j][1] = j / 8.0 + 1/16.0;
                //System.out.println(boardCoords[i][j][1]);
            }
        }
    }
    public static void init() {
        Board.fillCoords();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if ((i + j) % 2 == 0){
                    StdDraw.setPenColor(new Color(128, 64, 0));
                } else {
                    StdDraw.setPenColor(new Color(255, 204, 153));
                }
                StdDraw.filledSquare(boardCoords[i][j][0], boardCoords[i][j][1], 1/16.0);
                //System.out.println("Made square at column " + i + " and row " + j);
            }
        }
    }
}
