package chapter16;
//design an algo to check if someone has won a game of tic tac toe

public class q4 {
    enum Piece{
        empty, red, blue;
    }
    //if hasWon() is called many times we need to pre-process data for optimization
    //that is make use of memorization
    
    //Method 1: if know the last move made
    Piece hasWon(Piece[][] b, int r, int c){
        if(b.length != b[0].length)
            return Piece.empty;
        
        Piece p = b[r][c];
        if(p == Piece.empty)
            return Piece.empty;
        
        if(hasWRow(b,r) || hasWCol(b,c))
            return p;
        
        if(r==c && hasWDiag(b,1))
            return p;
        
        if(r==(b.length-c-1) && hasWDiag(b,-1))
            return p;
        
        return Piece.empty;
    }
    boolean hasWRow(Piece b[][], int r){
        for(int i=1;i<b[r].length;i++){
            if(b[r][i-1] != b[r][i])
                return false;
        }
        return true;
    }
    boolean hasWCol(Piece b[][], int c){
        for(int i=1;i<b.length;i++){
            if(b[i-1][c] != b[i][c])
                return false;
        }
        return true;
    }
    boolean hasWDiag(Piece b[][], int dir){
        int r = 0;
        int c = dir==1?0:b[0].length-1;
        Piece p = b[r][c];
        for(int i=0;i<b.length;i++){
            if(p != b[r][c])
                return false;
            r++;
            c += dir;
        }
        return true;
    }
    
    //if we are only talking about a 3*3 board
    Piece hasWon2(Piece b[][]){
        for(int i=0;i<b.length;i++){
            if(winner(b[i][0], b[i][1],b[i][2]))
                return b[i][0];
            
            if(winner(b[0][i],b[1][i],b[2][i]))
                return b[0][i];
            
            if(winner(b[0][0],b[1][1],b[2][2]))
                return b[0][0];
            
            if(winner(b[0][2],b[1][1],b[2][0]))
                return b[1][1];
        }
        
        return Piece.empty;
    }
    boolean winner(Piece p1, Piece p2, Piece p3 ){
        if(p1 == Piece.empty)
            return false;
        
        return p1==p2 && p2==p3;
    }
    
    public static void main(String[] args){}
}
