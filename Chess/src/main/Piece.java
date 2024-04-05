package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Piece {

    public int column, row;
    public int xPos, yPos;
    public boolean isWhite;
    public String name;
    public int value;
    private int sheetScale;
    public BufferedImage sheet;

    Board board;
    Image sprite;


    public Piece(Board board) {
        this.board = board;}
    {
        try {
            sheet = ImageIO.read(getClass().getResource("/piece.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics2D g2d) {
        if (sprite != null) {
            g2d.drawImage(sprite, xPos, yPos, null);
        }
    }
}