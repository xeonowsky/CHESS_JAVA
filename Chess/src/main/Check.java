package main;

public class Check {
    Board board;
    public Check(Board board) {
        this.board=board;
    }
    public boolean isCheck(Move move) {


        Piece king = board.checkKing(move.piece.isWhite);
        assert king != null;
        int kingColumn = king.column;
        int kingRow = king.rows;
        if (board.selectPiece != null && board.selectPiece.name.equals("King")) {

            kingColumn = move.newColumn;
            kingRow = move.newRow;
        }
        return false;
    }


private boolean hitRook(int column, int row, Piece king,int kingCol,int kingRow,int colVal,int rowVal) {
        for(int i=1;i<8;i++) {
            if(kingCol+(i*colVal)==column&&kingRow+(i*rowVal)==row){
                break;}
            Piece piece = board.getPiece(kingCol+(i*colVal),kingRow+(i*rowVal));
            if(!board.sameTeam(king,piece)&&(piece.name.equals("Rook")|| piece.name.equals("Queen"))){
                return true;
            }
    break;


        }
        return false;

}



    private boolean hitBishop(int column, int row, Piece king,int kingCol,int kingRow,int colVal,int rowVal) {
        for(int i=1;i<8;i++) {
            if(kingCol-(i*colVal)==column&&kingRow-(i*rowVal)==row){
                break;}
            Piece piece = board.getPiece(kingCol-(i*colVal),kingRow-(i*rowVal));
            if(!board.sameTeam(king,piece)&&(piece.name.equals("Bishop"))||piece.name.equals("Queen")){
                return true;
            }
            break;


        }
        return false;

    }



    private boolean hitKnight(int column, int row, Piece king,int colVal,int rowVal,int kingCol,int kingRow) {
        for(int i=1;i<8;i++) {
            if(kingCol-(i*colVal)==column&&kingRow-(i*rowVal)==row){
                break;}
            Piece piece = board.getPiece(kingCol-(i*colVal),kingRow-(i*rowVal));
            if(!board.sameTeam(king,piece)&&(piece.name.equals("Bishop"))||piece.name.equals("Queen")){
                return true;
            }
            break;


        }
        return false;

    }
    private boolean chceckKnight(Piece a,Piece b,int col,int row){
        return a!=null &&!board.sameTeam(a,b)&&a.name.equals("Knight")&&!(a.column==col&&a.rows==row);

    }
//    private boolean hitPawn(int column, int row, Piece king,int kingCol,int kingRow) {
//    return
//    }
//
//    private boolean hitKnight(int column, int row, Piece king,int kingCol,int kingRow) {
//        checkKnight(board.getPiece(kingCol-1,kingRow-2),king,column,row)||
//                checkKnight(board.getPiece(kingCol+2,kingRow+1),king,column,row)||
//                checkKnight(board.getPiece(kingCol+2,kingRow-1),king,column,row)||
//                checkKnight(board.getPiece(kingCol-2,kingRow+1),king,column,row)||
//                checkKnight(board.getPiece(kingCol-2,kingRow-1),king,column,row)||
//                checkKnight(board.getPiece(kingCol+1,kingRow+2),king,column,row)||
//                checkKnight(board.getPiece(kingCol-1,kingRow-2),king,column,row);
//
//
//    }
    
    private boolean hitKing(int column, int row, Piece king,int kingCol,int kingRow) {
        return checkKing(board.getPiece(kingCol-1,kingRow-1),king)||

                checkKing(board.getPiece(kingCol,kingRow+1),king)||
                checkKing(board.getPiece(kingCol,kingRow-1),king)||
                checkKing(board.getPiece(kingCol-1,kingRow+1),king)||

                checkKing(board.getPiece(kingCol+1,kingRow-1),king)||

                checkKing(board.getPiece(kingCol+1,kingRow),king)||
                checkKing(board.getPiece(kingCol-1,kingRow),king)||


                checkKing(board.getPiece(kingCol+1,kingRow+1),king);




    }


//    private boolean hitQueen(int column, int row, Piece king,int kingCol,int kingRow) {
//        return
//    }


//    private boolean hitQueen(int column, int row, Piece king,int kingCol,int kingRow) {
//        return
//    }
    private boolean checkKnight(Piece a,Piece b,int col,int row) {
        return a!=null &&!board.sameTeam(a,b)&&a.name.equals("Knight")&&!(a.column==col&&a.rows==row);

    }
    private boolean checkKing(Piece a,Piece b){
        return a!=null&&!board.sameTeam(a,b)&&a.name.equals("King")&&!(a.column==b.column&&a.rows==b.rows);
    }



}
