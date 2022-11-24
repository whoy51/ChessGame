import javax.swing.*;
import java.awt.Color;

public class Pawn extends Piece{
    public String type = "Pawn";
    public Pawn(int col, int row, boolean whi) {
        super(col, row, whi);
        type = "Pawn";
        draw();
    }
    public void draw(){
        if (type.equals("Pawn")) {
            if ((coords[0] + coords[1]) % 2 == 0) {
                StdDraw.setPenColor(new Color(128, 64, 0));
            } else {
                StdDraw.setPenColor(new Color(255, 204, 153));
            }
            StdDraw.filledSquare(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, 1 / 16.0);
            if (ChessGame.memeMode) {
                if (white) {
                    StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/Ollie.jpg", 0.1, 0.1);
                } else {
                    StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/Luther.jpg", 0.1, 0.1);
                }
            } else {
                if (white) {
                    StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/pawn_white.jpg", 0.1, 0.1);
                } else {
                    StdDraw.picture(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, "/resources/pawn_black.jpg", 0.1, 0.1);
                }
            }
        } else if (type.equals("Bishop")) {
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
            double[] x = {coords[0] / 8.0 -1 / 16.0 - 0.02,coords[0] / 8.0 -1 / 16.0,coords[0] / 8.0 -1 / 16.0 + 0.02, coords[0] / 8.0 -1 / 16.0};
            double[] y = {coords[1] / 8.0 -1 / 16.0,coords[1] / 8.0 -1 / 16.0 - 0.02,coords[1] / 8.0 -1 / 16.0, coords[1] / 8.0 -1 / 16.0 + 0.02};
            StdDraw.filledPolygon(x, y);
        } else if (type.equals("Knight")){
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
            double[] x = {coords[0] / 8.0 - 1 / 16.0 - 0.02,coords[0] / 8.0 - 1 / 16.0 + 0.02,coords[0] / 8.0 - 1 / 16.0};
            double[] y = {coords[1] / 8.0 - 1 / 16.0 - 0.02,coords[1] / 8.0 - 1 / 16.0 - 0.02,coords[1] / 8.0 - 1 / 16.0 + 0.02};
            StdDraw.filledPolygon(x, y);
        } else if (type.equals("Queen")) {
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
        } else {
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
            StdDraw.filledSquare(coords[0] / 8.0 - 1 / 16.0, coords[1] / 8.0 - 1 / 16.0, 0.02);
        }
    }
     public boolean canMove(int col, int row) {
        if ((ChessGame.turn == Turn.WHITE && !white) || (ChessGame.turn == Turn.BLACK && white)) {
            return false;
        }
        if (tryMove(col, row)){
            if (type.equals("Pawn")) {
                if (row == 8 && white || row == 1 && !white) {
                    promptUser();
                    System.out.println("Prompt success");
                }
            }
            return true;
        }
        return false;
     }
     public boolean tryMove(int col, int row){
        if (type.equals("Pawn")) {
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
            } else if (Math.abs(coords[0] - col) == 0 && ((coords[1] - row) == (white ? -2 : 2)) && coords[1] == (white ? 2 : 7)) {
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
            } else if (Math.abs(coords[0] - col) == 1 && ((coords[1] - row) == (white ? -1 : 1))) {
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
        } else if (type.equals("Bishop")) {
            if (Math.abs(coords[0] - col) == Math.abs(coords[1] - row)){
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
            
        } else if (type.equals("Knight")) {
            if ((Math.abs(coords[0] - col) == 1 && Math.abs(coords[1] - row) == 2) || (Math.abs(coords[0] - col) == 2 && Math.abs(coords[1] - row) == 1)){
                boolean occupied = false;
                for (int i = 0; i < 16; i++){
                    int[] checker = {col, row};
                    if (ChessGame.all[white? 0 : 1][i].coords[0] == checker[0] && ChessGame.all[white? 0 : 1][i].coords[1] == checker[1]){
                        occupied = true;
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
                System.out.println("Impossible");
                return false;
            }
        } else if (type.equals("Queen")) {
            if (Math.abs(coords[0] - col) == 0){
                boolean occupied = false;
                for (int i = 0; i < 16; i++){
                    for (int j = coords[1] + 1; j <= row; j++) {
                        int[] checker = {col, j};
                        //System.out.println("Checking " + checker[0] + ", " + checker[1]);
                        if (ChessGame.all[white? 0 : 1][i].coords[0] == checker[0] && ChessGame.all[white? 0 : 1][i].coords[1] == checker[1]){
                            occupied = true;
                            //System.out.println("Occupied");
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
            } else if (Math.abs(coords[1] - row) == 0) {
                boolean occupied = false;
                for (int i = 0; i < 16; i++) {
                    for (int j = coords[0] + 1; j <= col; j++) {
                        int[] checker = {j, row};
                        //System.out.println("Checking " + checker[0] + ", " + checker[1]);
                        if (ChessGame.all[white ? 0 : 1][i].coords[0] == checker[0] && ChessGame.all[white ? 0 : 1][i].coords[1] == checker[1]) {
                            occupied = true;
                            //System.out.println("Occupied");
                            break;
                        } else {
                            occupied = false;
                        }
                    }
                    if (occupied) {
                        break;
                    }
                }
                if (!occupied) {
                    System.out.println("Can Move");
                    return true;
                } else {
                    System.out.println("Cannot Move");
                    return false;
                }
            } else if (Math.abs(coords[0] - col) == Math.abs(coords[1] - row)){
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
        } else {
            if (Math.abs(coords[0] - col) == 0){
                boolean occupied = false;
                for (int i = 0; i < 16; i++){
                    for (int j = coords[1] + 1; j <= row; j++) {
                        int[] checker = {col, j};
                        //System.out.println("Checking " + checker[0] + ", " + checker[1]);
                        if (ChessGame.all[white? 0 : 1][i].coords[0] == checker[0] && ChessGame.all[white? 0 : 1][i].coords[1] == checker[1]){
                            occupied = true;
                            //System.out.println("Occupied");
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
            } else if (Math.abs(coords[1] - row) == 0){
                boolean occupied = false;
                for (int i = 0; i < 16; i++){
                    for (int j = coords[0] + 1; j <= col; j++){
                        int[] checker = {j, row};
                        //System.out.println("Checking " + checker[0] + ", " + checker[1]);
                        if (ChessGame.all[white? 0 : 1][i].coords[0] == checker[0] && ChessGame.all[white? 0 : 1][i].coords[1] == checker[1]){
                            occupied = true;
                            //System.out.println("Occupied");
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
    public void promptUser(){
        JFrame frame = new JFrame();
        frame.setTitle("Select New Piece");
        frame.setSize(450, 75);
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        JButton button1 = new JButton("Queen");
        JButton button2 = new JButton("Rook");
        JButton button3 = new JButton("Knight");
        JButton button4 = new JButton("Pawn");
        JButton button5 = new JButton("Bishop");
        button1.addActionListener(e -> {
            frame.dispose();
            System.out.println("Queen Selected");
            makeQueen();
            draw();
        });
        button2.addActionListener(e -> {
            frame.dispose();
            makeRook();
            draw();
        });
        button3.addActionListener(e -> {
            frame.dispose();
            makeKnight();
            draw();
        });
        button4.addActionListener(e -> {
            frame.dispose();
            makePawn();
            draw();
        });
        button5.addActionListener(e -> {
            frame.dispose();
            makeBishop();
            draw();
        });

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
    public void makeQueen(){
        type = "Queen";
    }
    public void makeRook(){
        type = "Rook";
    }
    public void makeBishop(){
        type = "Bishop";
    }
    public void makePawn(){
        type = "Pawn";
    }
    public void makeKnight(){
        type = "Knight";
    }
}
