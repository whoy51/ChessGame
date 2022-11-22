public class ChessGame {
    public static void main(String[] args) {
        Board.fillCoords();
        Board.init();
        Pawn whitePawn1 = new Pawn(2,1,true);
        Pawn whitePawn2 = new Pawn(2,2,true);
        Pawn whitePawn3 = new Pawn(2,3,true);
        Pawn whitePawn4 = new Pawn(2,4,true);
        Pawn whitePawn5 = new Pawn(2,5,true);
        Pawn whitePawn6 = new Pawn(2,6,true);
        Pawn whitePawn7 = new Pawn(2,7,true);
        Pawn whitePawn8 = new Pawn(2,8,true);
        Pawn blackPawn1 = new Pawn(7,1,false);
        Pawn blackPawn2 = new Pawn(7,2,false);
        Pawn blackPawn3 = new Pawn(7,3,false);
        Pawn blackPawn4 = new Pawn(7,4,false);
        Pawn blackPawn5 = new Pawn(7,5,false);
        Pawn blackPawn6 = new Pawn(7,6,false);
        Pawn blackPawn7 = new Pawn(7,7,false);
        Pawn blackPawn8 = new Pawn(7,8,false);
        Rook whiteRook1 = new Rook(1,1,true);
        Rook whiteRook2 = new Rook(1,8,true);
        Rook blackRook1 = new Rook(8,1,false);
        Rook blackRook2 = new Rook(8,8,false);
        Knight whiteKnight1 = new Knight(1,2,true);
        Knight whiteKnight2 = new Knight(1,7,true);
        Knight blackKnight1 = new Knight(8,2,false);
        Knight blackKnight2 = new Knight(8,7,false);
        Bishop whiteBishop1 = new Bishop(1,3,true);
        Bishop whiteBishop2 = new Bishop(1,6,true);
        Bishop blackBishop1 = new Bishop(8,3,false);
        Bishop blackBishop2 = new Bishop(8,6,false);
        King whiteKing = new King(1,5,true);
        King blackKing = new King(8,5,false);
        Queen whiteQueen = new Queen(1,4,true);
        Queen blackQueen = new Queen(8,4,false);
    }
}
