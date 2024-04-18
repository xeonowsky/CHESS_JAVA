package main;


import java.awt.image.BufferedImage;

public class Knight extends Piece{

    public Knight(Board board,int column,int rows,boolean isWhite) {

        super(board);
        this.column=column;
        this.rows=rows;
        this.xPos=column*board.tileSize;
        this.yPos=rows*board.tileSize;
        this.isWhite=isWhite;
        this.name="Knight";
        this.sprite=sheet.getSubimage(3*SheetScale,isWhite?0:SheetScale,SheetScale,SheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);


    }

    @Override
    public boolean isValidMovmentOfPiece(int column, int rows) {
        return Math.abs(column-this.column)*Math.abs(rows-this.rows)==2;
    }
}