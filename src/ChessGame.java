import java.awt.*;

public class ChessGame {
    public static Piece[][] all = new Piece[2][16];
    public static int[] selectedTile = new int[2];
    public static boolean mousePressed = false;
    public static boolean selected = false;
    public static void main(String[] args) {
        Board.init();
        Pawn whitePawn1 = new Pawn(1,2,true);
        Pawn whitePawn2 = new Pawn(2,2,true);
        Pawn whitePawn3 = new Pawn(3,2,true);
        Pawn whitePawn4 = new Pawn(4,2,true);
        Pawn whitePawn5 = new Pawn(5,2,true);
        Pawn whitePawn6 = new Pawn(6,2,true);
        Pawn whitePawn7 = new Pawn(7,2,true);
        Pawn whitePawn8 = new Pawn(8,2,true);
        Pawn blackPawn1 = new Pawn(1,7,false);
        Pawn blackPawn2 = new Pawn(2,7,false);
        Pawn blackPawn3 = new Pawn(3,7,false);
        Pawn blackPawn4 = new Pawn(4,7,false);
        Pawn blackPawn5 = new Pawn(5,7,false);
        Pawn blackPawn6 = new Pawn(6,7,false);
        Pawn blackPawn7 = new Pawn(7,7,false);
        Pawn blackPawn8 = new Pawn(8,7,false);
        Rook whiteRook1 = new Rook(1,1,true);
        Rook whiteRook2 = new Rook(8,1,true);
        Rook blackRook1 = new Rook(1,8,false);
        Rook blackRook2 = new Rook(8,8,false);
        Knight whiteKnight1 = new Knight(2,1,true);
        Knight whiteKnight2 = new Knight(7,1,true);
        Knight blackKnight1 = new Knight(2,8,false);
        Knight blackKnight2 = new Knight(7,8,false);
        Bishop whiteBishop1 = new Bishop(3,1,true);
        Bishop whiteBishop2 = new Bishop(6,1,true);
        Bishop blackBishop1 = new Bishop(3,8,false);
        Bishop blackBishop2 = new Bishop(6,8,false);
        King whiteKing = new King(5,1,true);
        King blackKing = new King(5,8,false);
        Queen whiteQueen = new Queen(4,1,true);
        Queen blackQueen = new Queen(4,8,false);
        all[0][0]= whitePawn1;
        all[0][1]= whitePawn2;
        all[0][2]= whitePawn3;
        all[0][3]= whitePawn4;
        all[0][4]= whitePawn5;
        all[0][5]= whitePawn6;
        all[0][6]= whitePawn7;
        all[0][7]= whitePawn8;
        all[0][8]= whiteRook1;
        all[0][9]= whiteRook2;
        all[0][10]= whiteKnight1;
        all[0][11]= whiteKnight2;
        all[0][12]= whiteBishop1;
        all[0][13]= whiteBishop2;
        all[0][14]= whiteKing;
        all[0][15]= whiteQueen;
        all[1][0]= blackPawn1;
        all[1][1]= blackPawn2;
        all[1][2]= blackPawn3;
        all[1][3]= blackPawn4;
        all[1][4]= blackPawn5;
        all[1][5]= blackPawn6;
        all[1][6]= blackPawn7;
        all[1][7]= blackPawn8;
        all[1][8]= blackRook1;
        all[1][9]= blackRook2;
        all[1][10]= blackKnight1;
        all[1][11]= blackKnight2;
        all[1][12]= blackBishop1;
        all[1][13]= blackBishop2;
        all[1][14]= blackKing;
        all[1][15]= blackQueen;
        //whiteBishop1.move(3,3);
        System.out.println("Ready");
//        while(!selected){
//            if (!mousePressed && StdDraw.isMousePressed && !selected){
//                System.out.println("test");
//                mousePressed = true;
//                ChessGame.selectTile();
//            }
//        }
        while (true){
            if (StdDraw.isMousePressed() && !mousePressed){
                mousePressed = true;
                selectTile();
            } else if (!StdDraw.isMousePressed() && mousePressed) {
                mousePressed = false;
            }
            else if (mousePressed) {
                // hold stuff
            }

        }

    }

    public static void selectTile(){
        System.out.println("firing");
        StdDraw.setPenColor(Color.BLUE);
        selectedTile[0] = (int) (StdDraw.mouseX() * 16) + 1;
        selectedTile[1] = (int) (StdDraw.mouseY() * 16) + 1;
        StdDraw.square(selectedTile[0], selectedTile[1], 1/16.0);
        selected = true;
    }
}