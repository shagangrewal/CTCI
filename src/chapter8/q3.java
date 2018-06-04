package chapter8;
//magic index, finding index where a[i]=i;

public class q3 {
    //brute force method
    public static int m1(int a[]){
        if(a.length==0)
            return -1;
        for(int i=0;i<a.length;i++){
            if(a[i]==i)
                return i;
        }
        return -1;
    }
    //Method2: it involves the approach used in binary search
    public static int m2(int a[]){
        return m21(a,0, a.length-1);
    }
    public static int m21(int a[], int start, int end){
        if(start>end)
            return -1;
        int mid = (start+end)/2;
        if(a[mid]==mid)
            return mid;
        else if(a[mid]<mid)
            return m21(a, mid+1, end);
        else
            return m21(a,0,mid-1);
    }
    
    //if the elements are not distinct, then we need to check on the both sides
    public static int m3(int a[]){
        return m31(a, 0, a.length-1);
    }
    public static int m31(int a[], int start, int end){
        if(start>end)
            return -1;
        int mid = (start+end)/2;
        if(a[mid]==mid)
            return mid;
        int leftI = Math.min(mid-1, a[mid]);
        int left = m31(a, start, leftI);
        if(left>=0)
            return left;
        
        int rI = Math.max(mid+1, a[mid]);
        int r = m31(a, rI+1, end);
        return r;
    }
    public static void main(String[] args){
        int a[] = {-40,-20,-1,1,2,3,5,7,9,12,13};
        System.out.println("Method 1:"+m1(a));
        System.out.println("Method 2:"+m2(a));
        System.out.println("Method 3:"+m3(a));
    }
}
