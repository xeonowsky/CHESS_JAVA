package main;
//TO DO
public class Move {
    int oldColumn;
    int oldRow;
    int newColumn;
    int newRow;
    Piece piece;
    Piece capture;

    public Move(Board board,Piece piece,int newColumn,int newRow){
    this.newRow=newRow;
    this.newColumn=newColumn;
    this.oldColumn= piece.column;
    this.oldRow=piece.rows;
    this.piece=piece;
    this.capture=board.getPiece(newColumn,newRow);


    }




}

