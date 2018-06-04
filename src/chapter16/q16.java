package chapter16;
//given array of integers, implement method to sort array from indices m to n,
//such that whole array is sorted, minimize n-m

public class q16 {
    void findUnsortedSeq(int a[]){
        //find the sorted part of the ;eft array
        int end_l = findLeftSeqEnd(a); 
        if(end_l == a.length-1) //if already sorted
            return;
        //find the last sorted index on right side;
        int start_r = findRightSeq(a);
        //sorted already checked, no need for it again
        
        int max_idx = end_l;
        int min_idx = start_r;
        
        //finding min and max
        for(int i= end_l+1;i<start_r;i++){
            if(a[i]<a[min_idx])
                min_idx = i;
            if(a[i]>a[max_idx])
                max_idx = i;
        }
        
        //sliding right and left into individual parts
        int l = ShrinkLeft(a,min_idx,end_l);
        int r = ShrinkRight(a,max_idx,start_r);
        
        //these l and r contains the starting and final indices of to be sorted subsequence
        System.out.println(l+" "+r);
    }
    int findLeftSeqEnd(int a[]){
        for(int i=1;i<a.length;i++){
            if(a[i]<a[i-1])
                return i-1;
        }
        return a.length-1;
    }
    int findRightSeq(int a[]){
        for(int i=a.length-1;i>=0;i--){
            if(a[i-1]>a[i])
                return i;
        }
        return 0;
    }
    int ShrinkLeft(int a[], int min_i, int start){
        int c = a[min_i];
        for(int i=start-1;i>=0;i--){
            if(a[i] <= c)
                return i+1;
        }
        return 0;
    }
    int ShrinkRight(int a[], int max_i, int start){
        int c = a[max_i];
        for(int i=start;i<a.length;i--){
            if(a[i]>c)
                return i-1;
        }
        return a.length-1;
    }
    public static void main(String[] args){}
}
