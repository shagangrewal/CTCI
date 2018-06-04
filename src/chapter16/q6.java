package chapter16;
//given two arrays, find the smallest difference of elements from two arrays(one element from each array)

import java.util.Arrays;


public class q6 {
    //brute for method
    static int smallDiff(int a[], int b[]){
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(Math.abs(a[i]-b[j])<diff)
                    diff = Math.abs(a[i]-b[j]);
            }
        }
        return diff;
    }//results in time complexity of O(A*B)
    
    //Method 2: applying it on a sorted arrays
    static int smallDiff2(int a[], int b[]){
        int min = Integer.MAX_VALUE; 
        Arrays.sort(a);
        Arrays.sort(b);
        int x = 0;
        int y = 0;
        while(x<a.length && y<b.length){
            if(Math.abs(a[x]-b[y])<min)
                min = Math.abs(a[x]-b[y]);
            else{
                if(a[x]<b[y])
                    x++;
                else
                    y++;
            }
        }
        return min;
    }//this method is done in O(nlogn), n correspoding to bigger no of elements in an array
    
    public static void main(String[] args){
        int a[] = {15,2,1,11};
        int b[] = {4,19,127,23,235,12};
        System.out.println(smallDiff(a,b));
        System.out.println(smallDiff2(a,b));
    }
}
