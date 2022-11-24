import java.awt.Color;

public class Pawn extends Piece{
    public Pawn(int col, int row, boolean whi) {
        super(col, row, whi);
    }
    public void draw(){
        if ((coords[0] + coords[1]) % 2 == 0){
            StdDraw.setPenColor(new Color(128, 64, 0));
        } else {
            StdDraw.setPenColor(new Color(255, 204, 153));
        }
        StdDraw.filledSquare(coords[0] / 8.0 - 1/16.0, coords[1] / 8.0 - 1/16.0, 1/16.0);
        if (white) {
            StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/Juan.jpg", 0.1, 0.1);
        } else {
            StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/Wesley.jpg", 0.1, 0.1);
        }
    }
     public boolean canMove(int col, int row) {
        if ((ChessGame.turn == Turn.WHITE && !white) || (ChessGame.turn == Turn.BLACK && white)) {
            return false;
        }
        if (tryMove(col, row)){
            if (row == 8 && white){
                NewPiece piece = Board.promptUser(true);
                if (piece == NewPiece.QUEEN) {
                    ChessGame.all[0][col - 1] = new Queen(col, row, true);
                }
                else if (piece == NewPiece.ROOK) {
                    ChessGame.all[0][col - 1] = new Rook(col, row, true);
                }
                else if (piece == NewPiece.KNIGHT) {
                    ChessGame.all[0][col - 1] = new Knight(col, row, true);
                }
                else if (piece == NewPiece.PAWN) {
                    ChessGame.all[0][col - 1] = new Pawn(col, row, true);
                }
                else if (piece == NewPiece.BISHOP) {
                    ChessGame.all[0][col - 1] = new Bishop(col, row, true);
                }
                System.out.println("White conversion");
            }
            if (row == 1 && !white){
                NewPiece piece = Board.promptUser(false);
                System.out.println("Black conversion");
                if (piece == NewPiece.QUEEN) {
                    ChessGame.all[0][col - 1] = new Queen(col, row, false);
                }
                else if (piece == NewPiece.ROOK) {
                    ChessGame.all[0][col - 1] = new Rook(col, row, false);
                }
                else if (piece == NewPiece.KNIGHT) {
                    ChessGame.all[0][col - 1] = new Knight(col, row, false);
                }
                else if (piece == NewPiece.PAWN) {
                    ChessGame.all[0][col - 1] = new Pawn(col, row, false);
                }
                else if (piece == NewPiece.BISHOP) {
                    ChessGame.all[0][col - 1] = new Bishop(col, row, false);
                }
            }
            return true;
        }
        return false;
     }
     public boolean tryMove(int col, int row){
         if (Math.abs(coords[0] - col) == 0 && (coords[1] - row) == (white ? -1 : 1)) {
             boolean occupied = false;
             for (int j = 0; j < 2; j++) {
                 for (int i = 0; i < 16; i++) {
                     int[] checker = {col, row};
                     if (ChessGame.all[j][i].coords[0] == checker[0] && ChessGame.all[j][i].coords[1] == checker[1]) {
                         occupied = true;
                     }
                 }
             }
             if (!occupied) {
                 System.out.println("Can Move");
                 return true;
             } else {
                 System.out.println("Cannot Move");
                 return false;
             }
         } else if (Math.abs(coords[0] - col) == 0 && ((coords[1] - row) == (white? -2 : 2)) && coords [1] == (white? 2 : 7)){
             boolean occupied = false;
             for (int i = 0; i < 16; i++) {
                 //System.out.println("Check iteration " + i);
                 int[] checker = {col, row};
                 //System.out.println(checker[0] + ", " + checker[1]);
                 //System.out.println(ChessGame.all[white? 0 : 1][i].coords[0] + ", " + ChessGame.all[white? 0 : 1][i].coords[1]);
                 if (ChessGame.all[white ? 0 : 1][i].coords[0] == checker[0] && ChessGame.all[white ? 0 : 1][i].coords[1] == checker[1]) {
                     occupied = true;
                     //System.out.println("Spot occupied");
                     break;
                 } else {
                     occupied = false;
                 }
             }
             if (!occupied) {
                 System.out.println("Can Move");
                 return true;
             } else {
                 System.out.println("Cannot Move");
                 return false;
             }
         } else if (Math.abs(coords[0] - col) == 1 && ((coords[1] - row) == (white? -1 : 1))){
             boolean occupied = false;
             for (int i = 0; i < 16; i++) {
                 //System.out.println("Check iteration " + i);
                 int[] checker = {col, row};
                 //System.out.println(checker[0] + ", " + checker[1]);
                 //System.out.println(ChessGame.all[white? 0 : 1][i].coords[0] + ", " + ChessGame.all[white? 0 : 1][i].coords[1]);
                 if (ChessGame.all[white ? 1 : 0][i].coords[0] == checker[0] && ChessGame.all[white ? 1 : 0][i].coords[1] == checker[1]) {
                     occupied = true;
                     //System.out.println("Spot occupied");
                     break;
                 } else {
                     occupied = false;
                 }
             }
             if (occupied) {
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
