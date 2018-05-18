package chapter8;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
//getting robot from (0,0) position to (r,c) position escaping certain off limit places in between
//movement allowed is either right or down

public class q2 {
    
    public static ArrayList<Point> path(int a[][]){
         ArrayList<Point> path = new ArrayList<Point>();
         if(getPath(a, a.length-1,a[0].length-1, path)){
             return path;
         }
         return null;
    }
    
    public static boolean getPath(int a[][], int i, int j, ArrayList<Point> path){
        if(a[i][j]>=0 || i<0 || j<0)
            return false;
        boolean o = (i==0) && (j==0);
        if(o || getPath(a,i-1,j,path) || getPath(a,i,j-1,path)){
            Point p = new Point(i,j);
            path.add(p);
            return true;
        }
        return false;
    }
    
    
    public static ArrayList<Point> M2(int a[][]){
        if(a==null || a[0].length==0)
            return null;
        ArrayList<Point> p = new ArrayList<Point>();
        HashMap<Point, Boolean> hm = new HashMap<Point, Boolean>(); 
        
        return null;
    }
    
    public static boolean pathM2(int a[][], int i, int j, ArrayList<Point> p, HashMap<Point, Boolean> hm){
        if(a[i][j]<0 || i<0 || j<0)
            return false;
        boolean origin = (i==0) && j==0;
        Point p2 = new Point(i,j);
        if(hm.containsKey(p2))
            return hm.get(p2);
        if(origin || pathM2(a,i-1,j,p,hm) || pathM2(a,i,j-1,p,hm)){
            p.add(p2);
            hm.put(p2, true);
            return true;
        }
        return true;
    }
    public static void main(String[] args){
        int a[][] = {{1,2,3},{4,-1,3},{-8,2,4},{9,2,5}};
    }
}
