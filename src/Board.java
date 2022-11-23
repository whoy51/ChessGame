import java.awt.Color;
public class Board {
    public static void init() {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if ((i + j) % 2 == 0){
                    StdDraw.setPenColor(new Color(128, 64, 0));
                } else {
                    StdDraw.setPenColor(new Color(255, 204, 153));
                }
                StdDraw.filledSquare(i / 8.0 + 1/16.0, j / 8.0 + 1/16.0, 1/16.0);
                //System.out.println("Made square at column " + i + " and row " + j);
            }
        }
    }
}
