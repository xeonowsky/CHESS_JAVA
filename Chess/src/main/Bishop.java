package main;

import java.awt.image.BufferedImage;

public class Bishop extends Piece{

    public Bishop(Board board,int column,int rows,boolean isWhite) {

        super(board);
        this.column=column;
        this.rows=rows;
        this.xPos=column*board.tileSize;
        this.yPos=rows*board.tileSize;
        this.isWhite=isWhite;
        this.name="Bishop";
        this.sprite=sheet.getSubimage(2*SheetScale,isWhite?0:SheetScale,SheetScale,SheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);


    }
}