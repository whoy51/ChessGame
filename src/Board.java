import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public static NewPiece promptUser(boolean whi){
        final NewPiece[] result = {null};
        JFrame frame = new JFrame();
        frame.setTitle("Select New Piece");
        frame.setSize(400, 400);
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        JButton button1 = new JButton(NewPiece.QUEEN.name());
        JButton button2 = new JButton(NewPiece.ROOK.name());
        JButton button3 = new JButton(NewPiece.KNIGHT.name());
        JButton button4 = new JButton(NewPiece.PAWN.name());
        JButton button5 = new JButton(NewPiece.BISHOP.name());
        button1.addActionListener(e -> {
            frame.dispose();
            result[0] = NewPiece.QUEEN;
        });
        button2.addActionListener(e -> {
            frame.dispose();
            result[0] = NewPiece.ROOK;
        });
        button3.addActionListener(e -> {
            frame.dispose();
            result[0] = NewPiece.KNIGHT;
        });
        button4.addActionListener(e -> {
            frame.dispose();
            result[0] = NewPiece.PAWN;
        });
        button5.addActionListener(e -> {
            frame.dispose();
            result[0] = NewPiece.BISHOP;
        });

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        while (true){
            if (!(result[0] == null)){
                return result[0];
            }
        }
    }
}

