package chapter10;
import java.util.Arrays;
//given a array of integer, sort it into alternating peeks and valleys 
//peek:greater than adjacent elements, valley: smaller than adjacent elements

public class q11 {
    static void createValley(int a[]){
        Arrays.sort(a);
        int i=1;
        while(i<a.length){
            int temp = a[i];
            a[i] = a[i-1];
            a[i-1] = temp;
            i += 2;
        }
    }
     static void printArray(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    //Method 2: we need to do it without sorting the array
    static void sortedValley(int a[]){
        for(int i=1;i<a.length;i++){
            int bigIdx = maxIndex(a, i-1,i,i+1);
            if(i!=bigIdx){
                int temp = a[bigIdx];
                a[bigIdx] = a[i];
                a[i] = temp;
            }
        }
    }
    static int maxIndex(int a[], int l,int b,int h){
        int len  = a.length;
        int lV = l>=0 && l<len? a[l] :Integer.MIN_VALUE;
        int bV = b>=0 && b<len? a[b] : Integer.MIN_VALUE;
        int hV = h>=0 && h<len? a[h] : Integer.MIN_VALUE;
        
        int max = Math.max(lV, Math.max(bV, hV));
        if(max == lV)
            return l;
        else if(max == bV)
            return b;
        else
            return h;
    }
    public static void main(String[] args){}
}
