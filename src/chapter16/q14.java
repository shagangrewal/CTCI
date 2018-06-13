package chapter16;
import java.util.*;
//given 2-D graph, find line which passes the most number of points

class Graph{
    public Node[] nodes;
}
class Node{
    String name;
    Node[] children;
}
class Line1{
    static double epsilon = .0001;
    double slope, intercept;
    boolean inf_slope = false;
    
    Line1(Points a, Points b){
        if(Math.abs(a.x-b.x)>epsilon){
            slope = (a.y-b.y)/(a.x-b.x);
            intercept = a.y - slope*a.x;
        }
        else{
            inf_slope = true;
            intercept = a.x;
        }
    }
    
    double floorToNearest(double d){
        int r = (int ) (d/epsilon);
        return ((double) r)*epsilon;
    }
    
    boolean isEquivalent(double a, double b){
        return Math.abs(a-b)<epsilon;
    }
    
    boolean isEquivalent(Object o){
        Line1 a = (Line1) o;
        if(isEquivalent(a.slope,slope) && isEquivalent(a.intercept, intercept) &&
                a.inf_slope == inf_slope)
            return true;
        
        return false;
    }
}
public class q14 {
    Line1 findBestLine(Points[] p){
        HashMap<Double, Line1> list = new HashMap<Double, Line1>();
        return getBestLine(list);
    }
    HashMap<Double, Line1> getList(Points[] p){
        HashMap<Double, Line1> a = new HashMap<Double, Line1>();
        for(int i=0;i<p.length-1;i++){
            for(int j= i+1;j<p.length;j++){
                Line1 l1 = new Line1(p[i],p[j]);
                double key = l1.floorToNearest(l1.slope);
                a.put(key, l1);
            }
        }
        return a;
     }
    
    Line1 getBestLine(HashMap<Double, Line1> list){
        Line1 best = null;
        int bestC = 0;
        
        Set<Double> slopes = list.keySet();
        
        for(double s: slopes){
            ArrayList<Line1> l = new ArrayList<Line1>();
            l.add(list.get(s));
            for(Line1 a : l){
                
            }
        }
        return best;
    }
    
    int countEqLines(HashMap<Double, Line1> a, Line1 b){
        double k = b.floorToNearest(b.slope);
        ArrayList<Line1> a1 = new ArrayList<Line1>();
        a1.add(a.get(k));
        ArrayList<Line1> a2 = new ArrayList<Line1>();
        a2.add(a.get(k-Line1.epsilon));
        ArrayList<Line1> a3 = new ArrayList<Line1>();
        a3.add(a.get(k+Line1.epsilon));
        int count = countEquivalentLines(a1,b);
        count += countEquivalentLines(a2,b);
        count += countEquivalentLines(a3,b);
        
        return count;
    }
    
    int countEquivalentLines(ArrayList<Line1> a, Line1 b){
        if(a == null)
            return 0;
        
        int count  = 0;
        for(Line1 p : a){
            if(p.isEquivalent(b))
                count++;
        }
        return count;
    }
    
    public static void main(String[] args){}
}
