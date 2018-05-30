package chapter10;
//given an M*N matrix, sorted in each row and column, write a method to find an element

class Coordinate implements Cloneable{
    public int row, column;
    Coordinate(int r, int c){
        row = r;
        column = c;
    }
    public boolean inBounds(int[][] a){
        return row>=0 && column>=0 && row<a.length && column<a[0].length;
    }
    public boolean isBefore(Coordinate p){
        return row<=p.row && column<=p.column;
    }
    public Coordinate clone(Coordinate p){
        return new Coordinate(row, column);
    }
    public void setToAvg(Coordinate min, Coordinate max){
        row = (min.row + max.row);
        column = (min.column + max.column);
    }
}

public class q9 {
    //Method 1: checking according to starting of row and column and then moving accordingly
    static boolean isPresent(int a[][], int x){
        int row = 0;
        int col = a[0].length-1;
        while(row<a.length && col>=0){
            if(a[row][col]==x)
                return true;
            if(a[row][col]>x){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
    //Method 2: it is based on the binry search approach
    Coordinate findElement(int a[][], Coordinate origin, Coordinate dest, int x){
        if(!origin.inBounds(a) || !dest.inBounds(a) )
            return null;
        if(a[origin.row][origin.column]==x)
            return null;
        else if(a[dest.row][dest.column]==x)
            return dest;
        else if(origin.isBefore(dest))
            return null;
        
        Coordinate start =  origin.clone(origin);
        int diagD = Math.min(dest.row-origin.row, dest.column-origin.column);
        Coordinate end = new Coordinate(start.row+diagD, start.column+diagD);
        Coordinate p = new Coordinate(0,0);
        
        while(start.isBefore(end)){
            p.setToAvg(start, end);
            if(x>a[p.row][p.column]){
                start.row = p.row+1;
                start.column = p.column+1;
            }
            else{
                end.row = p.row-1;
                end.column = p.column-1;
            }
        }
        
        return partAndSearch(a, origin, dest, start, x);
    }
    Coordinate partAndSearch(int a[][], Coordinate origin, Coordinate dest, Coordinate pivot, int x){
        Coordinate lowerLOrigin = new Coordinate(pivot.row, origin.column);
        Coordinate lowerLDest = new Coordinate(dest.row, pivot.column-1);
        Coordinate upperROrigin = new Coordinate(origin.row, pivot.column);
        Coordinate upperRdest = new Coordinate(pivot.row-1, dest.column);
        
        Coordinate lowerLeft = findElement(a, lowerLOrigin, lowerLOrigin, x);
        if(lowerLeft == null)
            return findElement(a, upperROrigin, upperRdest, x);
        return lowerLeft;
    }
    Coordinate findElement(int[][] m, int x){
        Coordinate origin = new Coordinate(0,0);
        Coordinate dest = new Coordinate(m.length-1,m[0].length-1);
        return findElement(m, origin, dest, x);
    }
    public static void main(String[] args){
        int a[][] = {{15,20,70,85},{20,35,80,95},{30,55,95,105},{40,80,100,120}};
        System.out.println(isPresent(a, 95));
    }
}
