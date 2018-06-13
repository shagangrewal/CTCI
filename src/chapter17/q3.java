package chapter17;
import java.util.Random;
//write method to randomly generate set of m-integers from n-sized array, each with equal probability

public class q3 {
    //randomly selection an index
    int rand(int low, int high){
        return (int)(Math.random()*(high-low));
    }
    //using iteration
    int[] randSub(int a[], int m, int n){
        if(m>n)
            return null;
        
        int sub[] = new int[m];
        
        for(int i = 0;i<m;i++){
            int k = rand(0,n);
            sub[i] = a[k];
        }
        return sub;
    }
    //above discussed method may result in duplicates
    
    //second method, using rest of the array (n-m, and selecting one of those randomly to swap with existing
    //this method more efficient
    int[] randSub2(int[] a, int m){
        int[] sub = new int[m];
        
        for(int i=0;i<m;i++){
            sub[i] = a[i];
        }
        
        for(int i = m;i<a.length;i++){
            int k = rand(0,i);
            if(k<m){
                sub[k] = a[i];
            }
        }
        return sub;
    }
    public static void main(String[] args){}
}
