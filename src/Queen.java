import java.awt.Color;

public class Queen extends Piece{

    public Queen(int col, int row, boolean whi) {
        super(col, row, whi);
        draw();
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
        if (StdDraw.getPenColor() == Color.WHITE) {
            StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/queen_white.jpg", 0.1, 0.1);
        } else {
            StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/queen_black.jpg", 0.1, 0.1);
        }
    }
    public boolean canMove(int col, int row){
        if ((ChessGame.turn == Turn.WHITE && !white) || (ChessGame.turn == Turn.BLACK && white)) {
            return false;
        }
        //System.out.println("Testing");
        if (Math.abs(coords[0] - col) == 0 && Math.abs(coords[1] - row) > 0){
            //System.out.println("Hi");
            boolean occupied = false;
            for (int i = 0; i < 16; i++) {
                if (row - coords[1] > 0) {
                    for (int j = coords[1] + 1; j <= row; j++) {
                        int[] checker = {col, j};
                        //System.out.println("Checking " + checker[0] + ", " + checker[1]);
                        if (ChessGame.all[white ? 0 : 1][i].coords[0] == checker[0] && ChessGame.all[white ? 0 : 1][i].coords[1] == checker[1]) {
                            occupied = true;
                            System.out.println("Occupied");
                        }
                    }
                } else {
                    for (int j = coords[1] - 1; j >= row; j--) {
                        int[] checker = {col, j};
                        System.out.println("Checking " + checker[0] + ", " + checker[1]);
                        if (ChessGame.all[white ? 0 : 1][i].coords[0] == checker[0] && ChessGame.all[white ? 0 : 1][i].coords[1] == checker[1]) {
                            occupied = true;
                            System.out.println("Occupied");
                        }
                    }
                }
                if (occupied) {
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
        } else if (Math.abs(coords[1] - row) == 0 && Math.abs(coords[0] - col) > 0){
            //System.out.println("Hi");
            boolean occupied = false;
            for (int i = 0; i < 16; i++){
                //System.out.println(i);
                if (col - coords[0] > 0) {
                    for (int j = coords[0] + 1; j <= col; j++) {
                        //System.out.println("PLS");
                        int[] checker = {j, row};
                        //System.out.println("Checking " + checker[0] + ", " + checker[1]);
                        if (ChessGame.all[white ? 0 : 1][i].coords[0] == checker[0] && ChessGame.all[white ? 0 : 1][i].coords[1] == checker[1]) {
                            occupied = true;
                            System.out.println("Occupied");
                        }
                    }
                } else {
                    for (int j = coords[0] - 1; j >= col; j--) {
                        //System.out.println("PLS");
                        int[] checker = {j, row};
                        //System.out.println("Checking " + checker[0] + ", " + checker[1]);
                        if (ChessGame.all[white ? 0 : 1][i].coords[0] == checker[0] && ChessGame.all[white ? 0 : 1][i].coords[1] == checker[1]) {
                            occupied = true;
                            System.out.println("Occupied");
                        }
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
        } else if (Math.abs(coords[0] - col) == Math.abs(coords[1] - row) && Math.abs(coords[0] - col) > 0){
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
