package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input extends MouseAdapter {
Board board;
    public Input(Board board) {
    this.board=board;
    }



    public void mousePressed(MouseEvent mouseEvent) {
        int column = mouseEvent.getX() / board.tileSize;
        int row = mouseEvent.getY() / board.tileSize;
        board.selectPiece = board.capturePiece(column, row);
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        int column = mouseEvent.getX() / board.tileSize;
        int row = mouseEvent.getY() / board.tileSize;

        if (board.selectPiece != null) {

            Move move = new Move(board, board.selectPiece, row, column);
            if (board.isValidMove(move)) {
                board.makeMove(move);
            } else {
                // Jeśli ruch jest nieprawidłowy, przywróć położenie wybranej figury
                board.selectPiece.xPos = board.selectPiece.column * board.tileSize;
                board.selectPiece.yPos = board.selectPiece.rows * board.tileSize;
            }
            board.selectPiece = null; // Zresetuj wybraną figurę po ruchu
            board.repaint(); // Odśwież planszę
        }
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if(board.selectPiece!=null){
        board.selectPiece.xPos=mouseEvent.getX() - board.tileSize/2;
        board.selectPiece.yPos=mouseEvent.getY() - board.tileSize/2;
        board.repaint();
         }
    }



}
