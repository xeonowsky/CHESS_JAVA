package main;


import java.awt.image.BufferedImage;

public class King extends Piece {

    public King(Board board, int column, int rows, boolean isWhite) {

        super(board);
        this.column = column;
        this.rows = rows;
        this.xPos = column * board.tileSize;
        this.yPos = rows * board.tileSize;
        this.isWhite = isWhite;
        this.name = "King";
        this.sprite = sheet.getSubimage(0 * SheetScale, isWhite ? 0 : SheetScale, SheetScale, SheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);


    }

    @Override
    public boolean isValidMovmentOfPiece(int column, int rows) {
        return Math.abs((column - this.column) * (rows - this.rows)) == 1 || Math.abs(column - this.column) + Math.abs(rows - this.rows) == 1 || canCastle(column,rows);
    }


    private boolean canCastle(int column, int rows) {

        if (this.rows == rows) {

            if (column == 6) {
                Piece rook = board.getPiece(7, rows);
                if (rook != null && rook.isFirstMove && isFirstMove) {
                    return board.getPiece(5, rows) == null &&
                            board.getPiece(6, rows) == null &&
                            !board.check.isCheck(new Move(board, this, 5, rows));
                }

            } else if (column == 2) {
                Piece rook = board.getPiece(0, rows);
                if (rook != null && rook.isFirstMove && isFirstMove) {
                    return board.getPiece(3, rows) == null &&
                            board.getPiece(2, rows) == null &&
                            board.getPiece(1, rows) == null &&
                            !board.check.isCheck(new Move(board, this, 3, rows));
                }

            }




        }
        return false;
    }
}