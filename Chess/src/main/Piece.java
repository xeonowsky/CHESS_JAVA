package main;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;

public class Piece {

    public int column, rows;
    public int xPos;
    public int yPos;

    public boolean isWhite;
    public String name;
    public int value;

    Board board;
    Image sprite;
    BufferedImage sheet;

    public boolean isFirstMove=true;

    {
        try {
            sheet = ImageIO.read(ClassLoader.getSystemResource("main/piece.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected int SheetScale=sheet.getWidth()/6;


    public Piece(Board board) {
        this.board = board;}


    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getxPos() {
        return xPos;
    }
    public void checkPosition(Piece piece){
        System.out.println("Column:"+piece.getColumn()+"Row:"+piece.getRows());

    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isValidMovmentOfPiece(int column,int rows){
        return true;
    }
    public boolean CollidesPiece(int column,int rows){
        return false;

    }



    public void paint(Graphics2D g2d) {

            g2d.drawImage(sprite, xPos, yPos, null);

    }
}