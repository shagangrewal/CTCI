package chapter16;
import java.util.*;
//integer matrix representing plot of land, 0 being water, other values height above sea level
//a pond is connected vertically, horizontally and diagnolly. size being total number of connected water cells
//write method to compute all sizes of ponds on the matrix

public class q19 {
    ArrayList<Integer> allSizes(int land[][]){
        ArrayList<Integer> all = new ArrayList<Integer>();
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j]==0){
                    int size = sizes(land, i, j);
                    all.add(size);
                }
            }
        }
        return all;
    }
    int sizes(int[][] land, int r, int c){
        if(r<0 || c<0 || r>land.length || c>land[0].length || land[r][c] != 0)
            return 0;
        int size = 1;
        land[r][c] = -1; //to mark it visited
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                size += sizes(land, r+i, c+j);
            }
        }
        return size;
    }
    public static void main(String[] args){}
}
