package main;

public class Check {
    Board board;

    public Check(Board board) {
        this.board = board;
    }

    public boolean isCheck(Move move) {



        Piece king=board.findKing(move.piece.isWhite);
        assert king != null;
        int kingColumn = king.column;
        int kingRow = king.rows;
        if (board.selectPiece != null && board.selectPiece.name.equals("King")) {

            kingColumn = move.newColumn;
            kingRow = move.newRow;
        }
        return hitRook   (move.newColumn, move.newRow, king,kingColumn,kingRow,0,1)|| //upp
                hitRook  (move.newColumn, move.newRow, king,kingColumn,kingRow,1,0)|| //right
                hitRook  (move.newColumn, move.newRow, king,kingColumn,kingRow,0,-1)|| //down
                hitRook  (move.newColumn, move.newRow, king,kingColumn,kingRow,-1,0)|| //left


                hitKnight(move.newColumn, move.newRow, king,kingColumn,kingRow)|| //up
                hitPawn(move.newColumn, move.newRow, king,kingColumn,kingRow)||
                hitKing(king,kingColumn,kingRow)||

                hitBishop(move.newColumn, move.newRow, king,kingColumn,kingRow,-1,-1)|| //upleft
                hitBishop(move.newColumn, move.newRow, king,kingColumn,kingRow,1,-1)|| //upright
                hitBishop(move.newColumn, move.newRow, king,kingColumn,kingRow,1,1)|| //downright
                hitBishop(move.newColumn, move.newRow, king,kingColumn,kingRow,-1,1);//downleft
    }


    private boolean hitRook(int column, int row, Piece king, int kingCol, int kingRow, int colVal, int rowVal) {
        for (int i = 1; i < 8; i++) {
            if (kingCol + (i * colVal) == column && kingRow + (i * rowVal) == row) {
                break;
            }
            Piece piece = board.getPiece(kingCol + (i * colVal), kingRow + (i * rowVal));
            if(piece != null &&piece!=board.selectPiece) {

                if (!board.sameTeam(piece, king) && (piece.name.equals("Rook") || piece.name.equals("Queen"))) {
                    return true;
                }
                break;
            }

        }
        return false;

    }


    private boolean hitBishop(int column, int row, Piece king, int kingCol, int kingRow, int colVal, int rowVal) {
        for (int i = 1; i < 8; i++) {
            if (kingCol - (i * colVal) == column && kingRow - (i * rowVal) == row) {
                break;
            }
            Piece piece = board.getPiece(kingCol - (i * colVal), kingRow - (i * rowVal));
            if(piece!=null && piece!=board.selectPiece){

                if (!board.sameTeam(piece, king) && (piece.name.equals("Bishop") || piece.name.equals("Queen"))) {
                    return true;
                }
                break;
            }

        }
        return false;

    }






    private boolean hitKnight(int column, int row, Piece king,int kingCol,int kingRow) {
        return
                checkKnight(board.getPiece(kingCol-1,kingRow-2),king,column,row)||
                checkKnight(board.getPiece(kingCol+2,kingRow+1),king,column,row)||
                checkKnight(board.getPiece(kingCol+2,kingRow-1),king,column,row)||
                checkKnight(board.getPiece(kingCol-2,kingRow+1),king,column,row)||
                checkKnight(board.getPiece(kingCol-2,kingRow-1),king,column,row)||
                        checkKnight(board.getPiece(kingCol+1,kingRow+2),king,column,row)||
                        checkKnight(board.getPiece(kingCol+1,kingRow-2),king,column,row)||

                checkKnight(board.getPiece(kingCol-1,kingRow +2),king,column,row);


    }
    
    private boolean hitKing(Piece king, int kingCol,int kingRow) {
        return checkKing(board.getPiece(kingCol-1,kingRow-1),king)||//

                checkKing(board.getPiece(kingCol,kingRow+1),king)||//
                checkKing(board.getPiece(kingCol,kingRow-1),king)||//
                checkKing(board.getPiece(kingCol-1,kingRow+1),king)||//

                checkKing(board.getPiece(kingCol+1,kingRow-1),king)||//

                checkKing(board.getPiece(kingCol+1,kingRow),king)||//
                checkKing(board.getPiece(kingCol-1,kingRow),king)||//


                checkKing(board.getPiece(kingCol+1,kingRow+1),king);//




    }



    private boolean checkKnight(Piece a,Piece b,int col,int row) {
        return a!=null &&!board.sameTeam(a,b)&&a.name.equals("Knight")&&!(a.column==col&&a.rows==row);

    }
    private boolean checkKing(Piece a,Piece b){
        return a!=null&&!board.sameTeam(a,b)&&a.name.equals("King");
    }


    private boolean checkPawn(Piece a,Piece b,int col,int row){
        return a!=null&&!board.sameTeam(a,b)&&a.name.equals("Pawn");
    }

public boolean hitPawn(int column, int row, Piece king,int kingCol,int kingRow){
        int colVal=king.isWhite?-1:1;
        return checkPawn(board.getPiece(kingCol+1,kingRow+colVal),king,column,row)||
                checkPawn(board.getPiece(kingCol-1,kingRow+colVal),king,column,row);

}






}
