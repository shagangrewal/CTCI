package chapter17;
import java.util.*;
//find k smallest numbers in an array

public class q14 {
    //Brute force Method
    int[] ks(int a[], int k ){
        int[] s = new int[k];
        
        Arrays.sort(a); //sorting the array in O(N Log N)
        for(int i=0;i<k;i++){
            s[i] = a[i];
        }
        
        return s;
    }
    
    //using a priority queue and max heap
    //runs in O(N Log K)
    int[] ksmallest(int[] a, int k){
        if(k==0 || a.length==0)
            return null;
        int sub[] = new int[k];
        PriorityQueue<Integer> heap = getMaxheap(a,k);
        
        sub = heaptoArray(heap);
        return sub;
    }
    PriorityQueue<Integer> getMaxheap(int a[], int k){
        PriorityQueue<Integer> mHeap = new PriorityQueue<Integer>(k);
        
        for(int i : a){
            if(mHeap.size()<k)
                mHeap.add(i);
            else if(i < mHeap.peek()){
                mHeap.poll();
                mHeap.add(i);
            }
        }
        return mHeap;
    }
    
    int[] heaptoArray(PriorityQueue<Integer> a){
        int b[] = new int[a.size()];
        int i = 0;
        while(!a.isEmpty()){
            b[i] = a.poll();
            i++;
        }
        return b;
    }
    
    //Method 3: Selection Rank Algorithm(if all elements are not unique)
    int[] small(int a[], int k){
        if(k<=0 || k>a.length)
            return null;
        
        //rank of k-1
        int thresh = rank(a,k-1);
        
        int sub[] = new int[k];
        
        int count = 0;
        for(int i : a){
            if(i < thresh){
                sub[count] = i;
                count++;
            }
        }
        
        while(count<k){
            sub[count] = thresh;
            count++;
        }
        
        return sub;
    }
    //finding an element woth rank k in the array
    int rank(int a[], int k){
        if(k>a.length)
            return -1;
        
        return rank(a,k, 0,a.length-1);
    }
    
    //find the rank k in the subarrays, between start and end
    int rank(int[] a, int k, int start, int end){
        //considering a random number start and end of the array as the pivot element
        int piv = a[inRange(start,end)];
        
        int[] p = partition(a, start, end, piv);
        
        int leftS = p[0];
        int rightS = p[1];
        
        if(k<leftS){
            return rank(a,k,start,start+leftS-1);
        }
        else if(k < leftS+rightS){
            return piv;
        }
        else{
            return rank(a,k-leftS-rightS, start+leftS+rightS, end);
        }
    }
    int[] partition(int a[], int start, int end, int pivot){
        int[] p = new int[2]; //p[0] == left and [1] == right
        
        int left = start;
        int right = end;
        
        int mid = start; //setting the mid point on the right side of the array
        while(mid <= end){
            if(a[mid] < pivot){
                //this means the left side is atleast not greater than pivot
                //swap the right end the middle part
                int temp = a[mid];
                a[mid] = a[left];
                a[left] = temp;
                mid++;
                left++;
            }
            else if(a[mid] > pivot){
                //in this case, we find the element is greatere than the pivot
                //we swap this with right end and, decrease the right end
                int temp = a[mid];
                a[mid] = a[right];
                a[right]  = temp;
                right--;
            }
            else if(a[mid] == pivot){
                mid++;
            }
        }
        p[0] = left - start;//the relative position of the left end
        p[1] = right - left + 1; //depicting the size
        return p;
    }
    
    int inRange(int min, int max){
        Random r = new Random();
        return r.nextInt(max-min+1)+min;
    }
    public static void main(String[] args){}
}
