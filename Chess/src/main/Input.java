package main;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Input extends MouseAdapter {
    Board board;
    public Input(Board board){
        this.board=board;
    }




    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        int col=mouseEvent.getX()/board.tileSize;
        int row=mouseEvent.getY()/board.tileSize;
        Piece PieceXY=board.getPiece(col,row);
        if(PieceXY!=null){
            board.selectPiece=PieceXY;

        }

    }
    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if(!(board.selectPiece==null)){
            board.selectPiece.xPos= mouseEvent.getX()-board.tileSize/2;
            board.selectPiece.yPos= mouseEvent.getY()-board.tileSize/2;
            board.repaint();

        }
    }


    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        int col=mouseEvent.getX()/ board.tileSize;
        int row=mouseEvent.getY()/ board.tileSize;
        if(!(board.selectPiece==null)){
            Move move=new Move(board,board.selectPiece,col,row);
            if(board.isValidMove(move)){
                board.makeMove(move);
            }
            else {
                board.selectPiece.xPos=board.selectPiece.column* board.tileSize;
                board.selectPiece.yPos=board.selectPiece.rows*board.tileSize;
            }
        }
        board.selectPiece=null;
        board.repaint();

    }

}




