package main;

import java.awt.image.BufferedImage;

public class Pawn extends Piece{

    public Pawn(Board board,int column,int rows,boolean isWhite) {

        super(board);
        this.column=column;
        this.rows=rows;
        this.xPos=column+board.tileSize;
        this.yPos=rows+board.tileSize;
        this.isWhite=false;
        this.name="Pawn";
        this.sprite=sheet.getSubimage(5*SheetScale,isWhite?0:SheetScale,SheetScale,SheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);


    }
}