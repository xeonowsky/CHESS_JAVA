package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Piece {

    public int column, rows;
    public int xPos, yPos;
    public boolean isWhite;
    public String name;
    public int value;

    Board board;
    Image sprite;
    BufferedImage sheet;

    {
        try {
            sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("piece.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected int SheetScale=sheet.getWidth()/6;


    public Piece(Board board) {
        this.board = board;}














    public void paint(Graphics2D g2d) {

            g2d.drawImage(sprite, xPos, yPos, null);

    }
}