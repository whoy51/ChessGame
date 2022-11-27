import java.awt.Color;

public class King extends Piece{

    public King(int col, int row, boolean whi) {
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
        if (ChessGame.memeMode) {
            if (StdDraw.getPenColor() == Color.WHITE) {
                StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/Ollie.jpg", 0.1, 0.1);
            } else {
                StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/Luther.jpg", 0.1, 0.1);
            }
        } else {
            if (StdDraw.getPenColor() == Color.WHITE) {
                StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/king_white.jpg", 0.1, 0.1);
            } else {
                StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/king_black.jpg", 0.1, 0.1);
            }
        }


    }
    public boolean canMove(int col, int row){
        if ((ChessGame.turn == Turn.WHITE && !white) || (ChessGame.turn == Turn.BLACK && white)) {
            return false;
        }
        if (!hasMoved && col == 3){
            boolean occupied = false;
            for (int i = 0; i < 16; i++){
                int[] checker = {col, row};
                if ((ChessGame.all[white? 0 : 1][i].coords[0] > 1 && ChessGame.all[white? 0 : 1][i].coords[0] <= 4 )&& ChessGame.all[white? 0 : 1][i].coords[1] == checker[1]){
                    System.out.println("Castle Fail");
                    occupied = true;
                }
            }
            if (!occupied){
                if (!ChessGame.all[white? 0 : 1][8].hasMoved) {
                    System.out.println("Can Move");
                    ChessGame.all[white ? 0 : 1][8].move(4,row);
                    if (ChessGame.turn == Turn.WHITE) {
                        ChessGame.turn = Turn.BLACK;
                        StdDraw.setTitle("Turn: Black");
                    }else {
                        ChessGame.turn = Turn.WHITE;
                        StdDraw.setTitle("Turn: White");
                    }
                    return true;
                } else {
                    System.out.println("Rook Moved");
                    return false;
                }
            } else {
                System.out.println("Cannot Move");
                return false;
            }
        }
        if (!hasMoved && col == 7){
            boolean occupied = false;
            for (int i = 0; i < 16; i++){
                int[] checker = {col, row};
                if ((ChessGame.all[white? 0 : 1][i].coords[0] > 5 && ChessGame.all[white? 0 : 1][i].coords[0] < 8 )&& ChessGame.all[white? 0 : 1][i].coords[1] == checker[1]){
                    System.out.println("Castle Fail");
                    occupied = true;
                }
            }
            if (!occupied){
                if (!ChessGame.all[white? 0 : 1][9].hasMoved) {
                    System.out.println("Can Move");
                    ChessGame.all[white ? 0 : 1][9].move(6,row);
                    if (ChessGame.turn == Turn.WHITE) {
                        ChessGame.turn = Turn.BLACK;
                        StdDraw.setTitle("Turn: Black");
                    }else {
                        ChessGame.turn = Turn.WHITE;
                        StdDraw.setTitle("Turn: White");
                    }
                    return true;
                } else {
                    System.out.println("Rook Moved");
                    return false;
                }
            } else {
                System.out.println("Cannot Move");
                return false;
            }
        }
        if (Math.abs(coords[0] - col) <= 1 && Math.abs(coords[1] - row) <= 1){
            boolean occupied = false;
            for (int i = 0; i < 16; i++){
                //System.out.println("Check iteration " + i);
                int[] checker = {col, row};
                //System.out.println(checker[0] + ", " + checker[1]);
                //System.out.println(ChessGame.all[white? 0 : 1][i].coords[0] + ", " + ChessGame.all[white? 0 : 1][i].coords[1]);
                if (ChessGame.all[white? 0 : 1][i].coords[0] == checker[0] && ChessGame.all[white? 0 : 1][i].coords[1] == checker[1]){
                    occupied = true;
                    //System.out.println("Spot occupied");
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
            return false;
        }
    }
}
