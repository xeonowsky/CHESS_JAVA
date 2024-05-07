package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    int rows = 8;
    int columns = 8;
    ArrayList<Piece> pieceList = new ArrayList<>();
    public int tileSize = 85;


    public int caputreInAir=-1;

    Input input = new Input(this);

    public Board() {
        this.setPreferredSize(new Dimension(columns * tileSize, rows * tileSize));
        addPiece();
        this.addMouseListener(input);
        this.addMouseMotionListener(input);
    }

    public Piece selectPiece;

    public void makeMove(Move move) {


        if(move.piece.name.equals("Pawn")){
            movePawn(move);



        }else {

            move.piece.column = move.newColumn;
            move.piece.rows = move.newRow;
            move.piece.xPos = move.newColumn * tileSize;
            move.piece.yPos = move.newRow * tileSize;
            capture(move.capture);
            move.piece.isFirstMove = false;
        }
    }

    private void movePawn(Move move) {
        int ColorIndex = move.piece.isWhite? 1 : -1;



        if(getTileNumberr(move.newColumn,move.newRow)==caputreInAir){
            move.capture=getPiece(move.newColumn,move.newRow+ColorIndex);
        }

        if(getTileNumberr(move.newColumn,move.newRow)==caputreInAir){
            move.capture=getPiece(move.newColumn,move.newRow+ColorIndex);
        }
        if(Math.abs(move.piece.getRows()-move.newRow)==2){

            caputreInAir=getTileNumberr(move.newColumn,move.newRow+ColorIndex);


        }






        else{
                caputreInAir = -1;

            }
            ColorIndex = move.piece.isWhite ? 0 : 7;
            if (move.newRow == ColorIndex) {
                promotePawn(move);

            }






        move.piece.column = move.newColumn;
        move.piece.rows = move.newRow;
        move.piece.xPos = move.newColumn * tileSize;
        move.piece.yPos = move.newRow * tileSize;
        capture(move.capture);
        move.piece.isFirstMove = false;


    }

    private void promotePawn(Move move) {
        String[] options = {"Knight", "Bishop", "Rook", "Queen"};


        int choice = JOptionPane.showOptionDialog(
                null,
                "Chose a piece to promote your pawn",
                "Pawn Promote",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[3]);


        if (choice >= 0 && choice < options.length) {
            String selectedOption = options[choice];
            System.out.println("Choosed: " + selectedOption);



            if (choice == 0) {
                {
                    pieceList.add(new Knight(this, move.newColumn, move.newRow, move.piece.isWhite));

                    capture(move.piece);

                }
            }

        }
        if (choice == 1) {

                pieceList.add(new Bishop(this, move.newColumn, move.newRow, move.piece.isWhite));

                capture(move.piece);

            }
            if (choice == 2) {
                pieceList.add(new Rook(this, move.newColumn, move.newRow, move.piece.isWhite));
                capture(move.piece);
            }
            if (choice == 3) {
                pieceList.add(new Queen(this, move.newColumn, move.newRow, move.piece.isWhite));
                capture(move.piece);
            }



    }


    Piece checkKing(boolean isWhite) {
        for (Piece piece : pieceList) {
            if (piece.name.equals("King") && piece.isWhite == isWhite) {
                return piece;
            }
        }
        return null;
    }



    public void capture(Piece piece) {


            pieceList.remove(piece);


    }






    public boolean isValidMove(Move move) {

        if(!move.piece.isValidMovmentOfPiece(move.newColumn,move.newRow)){
            return false;

        }
        if(move.piece.CollidesPiece(move.newColumn,move.newRow)){
            return false;
        }


        return !sameTeam(move.piece, move.capture);
    }


    public boolean sameTeam(Piece piece1, Piece piece2) {





        if (piece1 == null || piece2 == null) {
            return false;
        }



        return piece1.isWhite()== piece2.isWhite();
    }




        public Piece getPiece(int column,int rows){
        for (Piece piece:pieceList){
            if(piece.column==column&&piece.rows==rows){
                return piece;
            }

        }
        return null;


        }







public int getTileNumberr(int column,int row){
        return rows*row+columns*column;

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
if(selectPiece!= null) {

    for (int i = 0; i < 8; i++) {
        for (int a = 0; a < 8; a++) {

            if (isValidMove(new Move(this, selectPiece, a, i))) {
                g2d.setColor(new Color(0x84B64EE3, true));
                g2d.fillRect(a * tileSize, i * tileSize, tileSize, tileSize);
            }



        }
    }
}


        for (Piece piece : pieceList) {
            piece.paint(g2d);
        }
    }
}