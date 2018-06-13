package chapter16;
import java.util.*;
//design algo to find two nums in an array if they sum upto a particular sum
class Pair{
    int a, b;
    Pair(int x,int y){
        this.a = x;
        this.b = y;
    }
}
public class q24 {
    //Method 1: brute force
    void method1(int a[], int sum){
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;i<a.length;j++){
                if((a[i]+a[j])==sum){
                    System.out.println("Pair: "+a[i]+" "+a[j]);
                    System.out.println();
                }
            }
        }
    }
    
    //Method 2: using arrayLists
    ArrayList<Pair> method2(int a[], int sum){
        ArrayList<Pair> l = new ArrayList<Pair>();
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i: a){
            int c = sum-i;
            if(!hs.contains(c) && hs.contains(i)){
                l.add(new Pair(i,c));
            }
            hs.add(i);
        }
        return l;
    }
    
    //Method c: wothout using any list
    void method3(int a[], int sum){
        Arrays.sort(a);
        int f = 0;
        int l = a.length-1;
        while(f<l){
            int s = a[f] + a[l];
            if(s == sum){
                System.out.println(a[f]+" "+a[l]);
            }
            f++;
            l--;
        }
    }
    public static void main(String[] args){}
}
