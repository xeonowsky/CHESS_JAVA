package main;
//TO DO
public class Move {
    public int oldColumn;
    public int oldRow;
    public int newRow;
    public int newColumn;
    Board board;
    Piece piece;
    Piece capture;

    public Move(Board board, Piece piece, int newColumn, int newRow) {
       this.oldColumn=piece.column;
       this.oldRow=piece.rows;
        this.newRow = newRow;
        this.newColumn = newColumn;
        this.piece=piece;
        this.capture=board.capturePiece(newColumn,newRow);
    }

    public int getOldColumn() {
        return oldColumn;
    }

    public void setOldColumn(int oldColumn) {
        this.oldColumn = oldColumn;
    }

    public int getOldRow() {
        return oldRow;
    }

    public void setOldRow(int oldRow) {
        this.oldRow = oldRow;
    }

    public int getNewRow() {
        return newRow;
    }

    public void setNewRow(int newRow) {
        this.newRow = newRow;
    }

    public int getNewColumn() {
        return newColumn;
    }

    public void setNewColumn(int newColumn) {
        this.newColumn = newColumn;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getCapture() {
        return capture;
    }

    public void setCapture(Piece capture) {
        this.capture = capture;
    }

}

