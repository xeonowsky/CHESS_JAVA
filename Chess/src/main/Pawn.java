package main;

import java.awt.image.BufferedImage;

public class Pawn extends Piece{

    public Pawn(Board board,int column,int rows,boolean isWhite) {

        super(board);
        this.column=column;
        this.rows=rows;
        this.xPos=column*board.tileSize;
        this.yPos=rows*board.tileSize;
        this.isWhite=isWhite;
        this.name="Pawn";
        this.sprite=sheet.getSubimage(5*SheetScale,isWhite?0:SheetScale,SheetScale,SheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);


    }

    @Override
    public boolean isValidMovmentOfPiece(int column, int rows) {
       int colorIndex =isWhite?1:-1;
       if(this.column==column &&rows==this.rows-colorIndex && board.getPiece(column,rows)==null){
           return true;
       }
        if(isFirstMove&&this.column==column &&rows==this.rows-colorIndex*2&& board.getPiece(column,rows)==null&& board.getPiece(column,rows+colorIndex)==null){
            return true;
        }
        if(column==this.column-1&&rows==this.rows-colorIndex&&board.getPiece(column,rows)!=null) return true;

            if(column==this.column+1&&rows==this.rows-colorIndex&&board.getPiece(column,rows)!=null) return true;

    return false;
    }
}