package main;
import java.awt.image.BufferedImage;


public class Queen extends Piece{
public Queen(Board board,int column,int rows,boolean isWhite) {

        super(board);
        this.column=column;
        this.rows=rows;
        this.xPos=column*board.tileSize;
        this.yPos=rows*board.tileSize;
        this.isWhite=isWhite;
        this.name="Queen";
        this.sprite=sheet.getSubimage(1*SheetScale,isWhite?0:SheetScale,SheetScale,SheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);


        }

        @Override
        public boolean isValidMovmentOfPiece(int column, int rows) {
                return this.column==column || this.rows==rows|Math.abs(column-this.column)==Math.abs(rows-this.rows);
        }

        @Override
        public boolean CollidesPiece(int column, int rows) {

        if(this.column==column || this.rows==rows) {


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
                                if (board.getPiece(this.column, b) != null) {
                                        return true;
                                }
                        }
                }
                if (this.rows < rows) {
                        for (int b = this.rows + 1; b < rows; b++) {
                                if (board.getPiece(this.column, b) != null) {
                                        return true;
                                }
                        }

                }
        }

        else{
                        if (this.column > column && this.rows > rows) {
                                for (int a = 1; a < Math.abs(this.column - column); a++) {
                                        if (board.getPiece(this.getColumn() - a, this.rows - a) != null) {
                                                return true;
                                        }
                                }
                        }

                        if (this.column < column && this.rows > rows) {
                                for (int a = 1; a < Math.abs(this.column - column); a++) {
                                        if (board.getPiece(this.getColumn() + a, this.rows - a) != null) {
                                                return true;
                                        }
                                }
                        }
                        if (this.column > column && this.rows < rows) {
                                for (int a = 1; a < Math.abs(this.column - column); a++) {
                                        if (board.getPiece(this.getColumn() - a, this.rows + a) != null) {
                                                return true;
                                        }
                                }
                        }
                        if (this.column < column && this.rows < rows) {
                                for (int a = 1; a < Math.abs(this.column - column); a++) {
                                        if (board.getPiece(this.getColumn() + a, this.rows + a) != null) {
                                                return true;
                                        }
                                }
                        }



        }
                return false;

        }
}
