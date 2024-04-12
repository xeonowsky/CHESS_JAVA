package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    int rows = 8;
    int columns = 8;
    ArrayList<Piece> pieceList = new ArrayList<>();
    public int tileSize = 85;

    Input input = new Input(this);

    public Board() {
        this.setPreferredSize(new Dimension(columns * tileSize, rows * tileSize));
        addPiece();
        this.addMouseListener(input);
        this.addMouseMotionListener(input);
    }

    public Piece selectPiece;

    public void makeMove(Move move) {
        move.piece.column = move.newColumn;
        move.piece.rows = move.newRow;
        move.piece.xPos = move.newColumn * tileSize;
        move.piece.yPos = move.newRow * tileSize;
        capture(move);
    }

    public void capture(Move move) {


            pieceList.remove(move.capture);


    }

    public boolean isValidMove(Move move) {


        if (sameTeam(move.piece, move.capture)) {
            return false;
        }
        return true;

    }

    public boolean sameTeam(Piece piece1, Piece piece2) {
        if ((piece1 == null) || (piece2 == null)) {
            return false;

        }
        return piece1.isWhite== piece2.isWhite;

    }




        public Piece getPiece(int column,int rows){
        for (Piece piece:pieceList){
            if(piece.column==column&&piece.rows==rows){
                return piece;
            }

        }
        return null;


        }



public void addPiece(){
    pieceList.add(new Knight(this,1,0,false));
    pieceList.add(new Knight(this,6,0,false));
    pieceList.add(new Pawn(this,0,1,false));
    pieceList.add(new Pawn(this,1,1,false));
    pieceList.add(new Pawn(this,2,1,false));
    pieceList.add(new Pawn(this,3,1,false));
    pieceList.add(new Pawn(this,4,1,false));
    pieceList.add(new Pawn(this,5,1,false));
    pieceList.add(new Pawn(this,6,1,false));
    pieceList.add(new Pawn(this,7,1,false));
    pieceList.add(new Rook(this,0,0,false));
    pieceList.add(new Rook(this,7,0,false));
    pieceList.add(new Bishop(this,2,0,false));
    pieceList.add(new Bishop(this,5,0,false));
    pieceList.add(new Queen(this,3,0,false));
    pieceList.add(new King(this,4,0,false));

    pieceList.add(new Knight(this,1,7,true));
    pieceList.add(new Knight(this,6,7,true));
    pieceList.add(new Pawn(this,0,6,true));
    pieceList.add(new Pawn(this,1,6,true));
    pieceList.add(new Pawn(this,2,6,true));
    pieceList.add(new Pawn(this,3,6,true));
    pieceList.add(new Pawn(this,4,6,true));
    pieceList.add(new Pawn(this,5,6,true));
    pieceList.add(new Pawn(this,6,6,true));
    pieceList.add(new Pawn(this,7,6,true));
    pieceList.add(new Rook(this,0,7,true));
    pieceList.add(new Rook(this,7,7,true));
    pieceList.add(new Bishop(this,2,7,true));
    pieceList.add(new Bishop(this,5,7,true));
    pieceList.add(new Queen(this,3,7,true));
    pieceList.add(new King(this,4,7,true));




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