package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    int rows = 8;
    int columns = 8;
    ArrayList<Piece> pieceList = new ArrayList<>();
    public int tileSize = 85;

    public Board() {
        this.setPreferredSize(new Dimension(columns * tileSize, rows * tileSize));
        addPieces(); // Dodanie pionków na planszę
    }

    public void addPieces() {
        pieceList.add(new Knight(2, 0, false, this));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                g2d.setColor((c + r) % 2 == 0 ? new Color(123) : new Color(0x6C6CB7));
                g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
            }
        }
        for (Piece piece : pieceList) {
            piece.paint(g2d); // Rysowanie pionków
        }
    }
}