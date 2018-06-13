package chapter16;
import java.util.*;
//given a grid, of black and white color boards, and ant, which intially faces right
//if white board, flip color turn clockwise and move forward one unit
//if black board, do eactly the same, just turn anti-clockwise
//simulate the first k-moves and print the grid

class Board{
    private HashSet<Position> w = new HashSet<Position>();
    private Ant ant = new Ant();
    private Position topL = new Position(0,0);
    private Position bottomR = new Position(0,0);
    
    public Board(){}
    
    void move(){
        ant.Turn(isWhite(ant.ps));
        flip(ant.ps);
        ant.move();
        fit(ant.ps);
    }
    
    void flip(Position p){
        if(w.contains(p))
            w.remove(p);
        else
            w.add(p.clone());
    }
    
    void fit(Position ps){
        int r = ps.row;
        int c = ps.column;
        
        topL.row = Math.min(topL.row,r);
        topL.column = Math.min(topL.column,c);
        
        bottomR.row = Math.max(bottomR.row, r);
        bottomR.column = Math.max(bottomR.column, c);
    }
    
    boolean isWhite(Position p){
        return w.contains(p);
    }
    
    boolean isWhite(int r, int c){
        return w.add(new Position(r,c));
    }
    
    String toString2(){
        StringBuilder sb = new StringBuilder();
        int rMin = topL.row;
        int rMax = bottomR.row;
        int cMin = topL.column;
        int cMax = bottomR.column;
        
        for(int r= rMin;r<=rMax;r++){
            for(int c = cMin; c<=cMax;c++){
                if(r == ant.ps.row && c == ant.ps.column)
                    sb.append(ant.ort);
                else if(isWhite(r,c))
                    sb.append("X");
                else
                    sb.append("_");
            }
            sb.append("\n");
        }
        sb.append("Ant: "+ ant.ort+"\n");
        return sb.toString();
    }
}

class Ant{
    Position ps = new Position(0,0);
    Orientation ort = Orientation.right;
    
    void Turn(boolean clockwise){
        ort = ort.getTurn(clockwise);
    }
    
    void move(){
        if(ort==Orientation.left)
            ps.column--;
        else if(ort==Orientation.right)
            ps.column++;
        else if(ort==Orientation.up)
            ps.row--;
        else
            ps.row++;
    }
    
    void adjustPos(int shiftR, int shiftC){
        ps.row += shiftR;
        ps.column += shiftC;
    }
}

enum Orientation{
    left, right, up, down;
    
    public Orientation getTurn(boolean clockwise){
        if(this==left)
            return clockwise?up:down;
        else if(this==up)
            return clockwise?right:left;
        else if (this==right)
            return clockwise? down:up;
        else{
            return clockwise? left:right;
        }
    }
    
    public String toString1(){
        if(this==left)
            return "\u2190";
        else if(this == up)
            return "\u2191";
        else if(this == right)
            return "\u2192";
        else
            return "\u2193";
    }
}

class Position{
    public int row, column;
    
    public Position(int a, int b){
        this.row = a;
        this.column = b;
    }
    
    public boolean equals(Object o){
        if(o instanceof Position){
            Position p = (Position) o;
            return p.row == row && p.column==column;
        }
        return false;
    }
    
    public int HashCode(){
        return (row*31)^column;
    }
    
    public Position clone(){
        return new Position(row, column);
    }
}
public class q22 {
    public static void main(String[] args){}
}
