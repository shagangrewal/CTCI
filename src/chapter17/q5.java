package chapter17;
import java.util.*;
//given array with numbers and letters, find longest subarray with equal numbers of letters and numbers

public class q5 {
    char[] findLongestSub(char[] a){
        int d[] = computeDiff(a);
        
        int match[] = longestMatch(d);
        
        return extractSub(a, match[0], match[1]);
    }
    char[] extractSub(char[] a,int low, int high){
        if(low==high)
            return null;
        char t[] = new char[high-low+1];
        for(int i=low;i<=high;i++){
            t[i] = a[i-low];
        }
        return t;
    }
    int[] computeDiff(char[] a){
        int d[] = new int[a.length];
        int delta = 0;
        for(int i=0;i<a.length;i++){
            if(Character.isLetter(a[i]))
                delta++;
            else
                delta--;
            d[i] = delta;
        }
        return d;
    }
    
    int[] longestMatch(int[] d){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, -1); //base case of size 0
        
        int m[] = new int[2];
        
        for(int i=0;i<d.length;i++){
            if(!hm.containsKey(d[i]))
                hm.put(d[i], i);
            else{
                int match = hm.get(d[i]);
                int temp = i - match; //total distance
                int l = m[1] - m[0]; //longest possible so far
                if(temp > l){
                    m[1] = i;
                    m[0] = match;
                }
            }
        }
        return m;
    }
    
    //Method 2: starting from the middle element and traversing both directions
    //this wont always work, needs to be modified, as both sides are symmetric and we aint considering assymetric cases
    char[] maxSub(char[] a){
        int counter = 0;
        int n = a.length/2;
        int min=n,max=n;
        for(int i=0;i<n;i++){
            if(Character.isDigit(n-i-1))
                counter--;
            else
                counter++;
            
            if(Character.isLetter(a[n+i]))
                counter++;
            else
                counter--;
            
            if(counter==0){
                min = n -i-1;
                max = n + i;
            }
        }
        return extractSub(a, min, max);
    }
    public static void main(String[] args){}
}
