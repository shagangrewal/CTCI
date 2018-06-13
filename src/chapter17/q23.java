package chapter17;
//given a square matrix, cell being either black or white
//design an algorithm to find the maximum subsequence such that all four borders are filled with black pixels

class SubSquare{
    int row, col, size;
    public SubSquare(int a, int b, int c){
        this.row = a;
        this.col = b;
        this.size = c;
    }
}

class SquareCell{
    int zerosRight =0, zerosBelow = 0;
    SquareCell(int a, int b){
        this.zerosRight=a;
        this.zerosBelow = b;
    }
}

public class q23 {
    //Method 1: moving from largest possible of N^2 to smaller ones
    int[] findSq(int[][] m){
        for(int i=m.length-1;i>=1;i--){
            int b[] = squareSize(m,i); //this will contains the ending indices, from 0,0 to i,i
            if(b!=null)
                return b;
        }
        return null;
    }
    int[] squareSize(int[][] m, int sqSize){
        int count = m.length - sqSize+1;
        int result[] = {0,0};
        for(int i=0;i<count;i++){
            for(int j=0;j<count;j++){
                if(isSquare(m,i,j,sqSize)){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    boolean isSquare(int[][] m, int row, int col, int size){
        //checking left and top of matrix
        for(int i=0;i<size;i++){
            if(m[row][col+i]==1)
                return false;
            
            if(m[row+size-1][col+i]==1)
                return false;
        }
        //checking the sides
        for(int i=0;i<size;i++){
            if(m[row+i][col]==1)
                return false;
            if(m[row+i][col+size-1]==1)
                return false;
        }
        return true;
    }
    //the above method results in the compleity of O(N^4)
    
    
    //Method 3: it involves pre-computing and results in O(N^3)
    int[] findSq2(int[][] m){
        SquareCell[][] p  = countZeros(m);
        for(int i = m.length;i>=1;i--){
            int[] c = squareSize(m,i);
            if(c!=null)
                return c;
        }
        return null;
    }
    SquareCell[][] countZeros(int[][] m){
        SquareCell[][] a = new SquareCell[m.length][m[0].length];
        
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                int rZeros = 0, bZeros=0;
                if(m[i][j] == 0){
                    rZeros++;
                    bZeros++;
                    if(j+1<m.length){
                        SquareCell prev = a[i][j+1];
                        rZeros += prev.zerosRight;
                    }
                    if(i+1<m.length){
                        SquareCell prev = a[i+1][j];
                        bZeros += prev.zerosBelow;
                    }
                }
                a[i][j] = new SquareCell(rZeros, bZeros);
            }
        }
        return a;
    }
    
    boolean isSquare(SquareCell[][] m, int row, int col, int size){
        SquareCell topLeft = m[row][col];
        SquareCell topRight = m[row][col+size-1];
        SquareCell bottomLeft = m[row+size-1][col];
        
        if(topLeft.zerosRight<size || topLeft.zerosBelow<size ||topRight.zerosBelow<size || bottomLeft.zerosRight<size){
            return false;
        }
        return true;
    }
    public static void main(String[] args){}
}
