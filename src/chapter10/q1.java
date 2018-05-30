package chapter10;
//given two sorted arrays A and B, merge b into sorted array A

public class q1 {
    void merge(int[] a, int[] b, int idxA, int idxB){//idxA and idxB being last indexes of a and b array's
        //instead of inserting at front and swapping we will insert from end
        int idxMerge = idxA + idxB - 1;
        while(idxB>=0){
            if(idxA>=0 && a[idxA]>=b[idxB]){
                a[idxMerge] = a[idxA];
                idxA--;
            }
            else{
                a[idxMerge] = a[idxB];
                idxB--;
            }
            idxMerge--;
        }
    }
    public static void main(String[] args){}
}
