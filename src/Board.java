import java.awt.Color;
public class Board{
    public static void main (String[] args){
        for (int i = 0; i < 8; i++){
            double x = i / 8.0;
            for (int j = 0; j < 8; j++){
                double y = j / 8.0;
                StdDraw.setPenColor(((i + j) % 2 == 0)? Color.WHITE : Color.BLACK);
                StdDraw.filledSquare((x + 1 / 16.0), (y + 1 / 16.0), (1 / 16.0));
                System.out.println("Made square at column " + i + " and row " + j);
            }
        }
    }
}