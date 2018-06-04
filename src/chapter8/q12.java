package chapter8;
import java.util.*;
//given a 8*8 chessboard, evaluate methods to places 8 queens
//such that none share same row, column or diagnol

public class q12 {
    int Grid_Size = 8;
    void placeQ(int row, int[] columns){
        for(int col1 = 0;col1<Grid_Size;col1++){
            if(checkVal(columns, row, col1)){
                columns[row] = col1; 
                placeQ(row+1, columns);
            }
        }
    }
    boolean checkVal(int[] columns, int row, int col){
        for(int row2 = 0; row2<row;row2++){ //rows will never be same
            int col2 = columns[row2];
            if(col2 == col) //check if columns are same
                return false;
            int coldis = Math.abs(col2-col);
            int rowdis = Math.abs(row2-row);
            if(coldis == rowdis)
                return false;
        }
        return true;
    }
    public static void main(String[] args){}
}
