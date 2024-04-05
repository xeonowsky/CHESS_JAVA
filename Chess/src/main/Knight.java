package main;

import java.awt.*;
import java.awt.image.BufferedImage;




///Naprawic knighta 

public class Knight extends Piece {

    public Knight(int column, int row, boolean isWhite, Board board) {
        super(board);

        this.column = column;
        this.row = row;
        this.isWhite = isWhite;
        this.name = "Knight";
        this.value = 3;

        int tileSize = board.tileSize;
        int spriteY = isWhite ? 0 : tileSize;
        BufferedImage unscaledSprite = sheet.getSubimage(tileSize * 3, spriteY, tileSize, tileSize); //
        int sheetScale=sheet.getWidth()/6;

        // Tworzenie przeskalowanej figury
        this.sprite = sheet.getScaledInstance(3*sheetScale,0,isWhite?0:sheetScale);

    }
}