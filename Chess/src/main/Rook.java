package main;

import java.awt.image.BufferedImage;

public class Rook extends Piece {

    public Rook(Board board, int column, int rows, boolean isWhite) {

        super(board);
        this.column = column;
        this.rows = rows;
        this.xPos = column * board.tileSize;
        this.yPos = rows * board.tileSize;
        this.isWhite = isWhite;
        this.name = "Rook";
        this.sprite = sheet.getSubimage(4 * SheetScale, isWhite ? 0 : SheetScale, SheetScale, SheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);


    }

    public boolean isValidMovmentOfPiece(int column, int rows) {
        return this.getColumn() == column || this.rows == rows;

    }

    @Override
    public boolean CollidesPiece(int column, int rows) {


        if (this.column > column) {
            for (int a = this.column - 1; a > column; a--) {
                if (board.getPiece(a, this.rows) != null) {
                    return true;
                }
            }
        }

        if (this.column < column) {
            for (int a = this.column + 1; a < column; a++) {
                if (board.getPiece(a, this.rows) != null) {
                    return true;
                }
            }
        }
        if (this.rows > rows) {
            for (int b = this.rows - 1; b > rows; b--) {
                if (board.getPiece(this.column,b) != null) {
                    return true;
                }
            }
        }
        if (this.rows < rows) {
            for (int b = this.rows + 1; b < rows; b++) {
                if (board.getPiece(this.column,b) != null) {
                    return true;
                }
            }

        }
        return false;
    }
}