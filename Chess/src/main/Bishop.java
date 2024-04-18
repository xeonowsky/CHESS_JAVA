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

    public boolean isValidMovmentOfPiece(int column, int rows) {
        return Math.abs(column-this.column)==Math.abs(rows-this.rows);

    }


    @Override
    public boolean CollidesPiece(int column, int rows) {
        if(this.column>column&&this.rows>rows){
            for (int a=1;a<Math.abs(this.column-column);a++){
                if(board.getPiece(this.getColumn()-1,this.rows-1)!=null){
                    return true;
                }
            }
        }

        if(this.column<column&&this.rows>rows){
            for (int a=1;a>Math.abs(this.column-column);a++){
                if(board.getPiece(this.getColumn()+1,this.rows-1)!=null){
                    return true;
                }
            }
        }
        if(this.column>column&&this.rows<rows){
            for (int a=1;a<Math.abs(this.column-column);a++){
                if(board.getPiece(this.getColumn()-1,this.rows+1)!=null){
                    return true;
                }
            }
        }
        if(this.column<column&&this.rows<rows){
            for (int a=1;a<Math.abs(this.column-column);a++){
                if(board.getPiece(this.getColumn()-1,this.rows+1)!=null){
                    return true;
                }
            }
        }


        return false;

    }

}