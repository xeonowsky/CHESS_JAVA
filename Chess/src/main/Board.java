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
        addPiece();
    }
public void addPiece(){
    pieceList.add(new Knight(this,0,-85,false));
    pieceList.add(new Knight(this,425,-85,false));
    pieceList.add(new Pawn(this,-85,0,false));
    pieceList.add(new Pawn(this,0,0,false));
    pieceList.add(new Pawn(this,85,0,false));
    pieceList.add(new Pawn(this,170,0,false));
    pieceList.add(new Pawn(this,255,0,false));
    pieceList.add(new Pawn(this,340,0,false));
    pieceList.add(new Pawn(this,425,0,false));
    pieceList.add(new Pawn(this,510,0,false));
    pieceList.add(new Rook(this,510,-85,false));
    pieceList.add(new Rook(this,-85,-85,false));
    pieceList.add(new Bishop(this,85,-85,false));
    pieceList.add(new Bishop(this,340,-85,false));
    pieceList.add(new Queen(this,170,-85,false));
    pieceList.add(new King(this,255,-85,false));

    pieceList.add(new Knight(this,0,510,true));
    pieceList.add(new Knight(this,425,510,true));
    pieceList.add(new Pawn(this,-85,425,true));
    pieceList.add(new Pawn(this,0,425,true));
    pieceList.add(new Pawn(this,85,425,true));
    pieceList.add(new Pawn(this,170,425,true));
    pieceList.add(new Pawn(this,255,425,true));
    pieceList.add(new Pawn(this,340,425,true));
    pieceList.add(new Pawn(this,425,425,true));
    pieceList.add(new Pawn(this,510,425,true));
    pieceList.add(new Rook(this,510,510,true));
    pieceList.add(new Rook(this,-85,510,true));
    pieceList.add(new Bishop(this,85,510,true));
    pieceList.add(new Bishop(this,340,510,true));
    pieceList.add(new Queen(this,170,510,true));
    pieceList.add(new King(this,255,510,true));




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
            piece.paint(g2d);
        }
    }
}